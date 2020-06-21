package com.parantak.dynamoLambda.person.handlers;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.parantak.dynamoLambda.person.model.Person;
import com.parantak.dynamoLambda.person.model.PersonRequest;

import javax.inject.Singleton;

@Singleton
public class SetPersonHandler implements RequestHandler<PersonRequest, Person> {
    @Override
    public Person handleRequest(PersonRequest personRequest, Context context) {
        // Create a connection to DynamoDB
        AmazonDynamoDB client = AmazonDynamoDBClientBuilder.defaultClient();

//        AmazonDynamoDB dynamoDBClient = new AmazonDynamoDBClient();
//        DynamoDBMapper mapper = new DynamoDBMapper(dynamoDBClient);

        // Build a mapper
        DynamoDBMapper mapper = new DynamoDBMapper(client);

        // Save the person by ID
        Person person = new Person();
        person.setId(personRequest.getId());
        person.setName(personRequest.getName());

        try{
            mapper.save(person);
        }catch (Exception e){
            context.getLogger().log("Could not insert person: " + personRequest.getId() + "\n");
            return new Person();
        }

        // Return the person
        return person;
    }
}