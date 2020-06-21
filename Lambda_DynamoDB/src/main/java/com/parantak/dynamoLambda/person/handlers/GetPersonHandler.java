package com.parantak.dynamoLambda.person.handlers;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.parantak.dynamoLambda.person.model.Person;
import com.parantak.dynamoLambda.person.model.PersonRequest;

// google guice setup
 import javax.inject.Singleton;

@Singleton
public class GetPersonHandler implements RequestHandler<PersonRequest, Person> {
    @Override
    public Person handleRequest(PersonRequest personRequest, Context context) {
        //DEBUG: entry
        context.getLogger().log("entry");

        // Create a connection to DynamoDB
        AmazonDynamoDB client = AmazonDynamoDBClientBuilder.defaultClient();

//        AmazonDynamoDB dynamoDBClient = new AmazonDynamoDBClient();
//        DynamoDBMapper mapper = new DynamoDBMapper(dynamoDBClient);

        // Build a mapper
        DynamoDBMapper mapper = new DynamoDBMapper(client);

        // Load the person by ID
        Person person = mapper.load(Person.class, personRequest.getId());
        if(person == null) {
            // We did not find a person with this ID, so return an empty Person
            context.getLogger().log("No Person found with ID: " + personRequest.getId() + "\n");
            return new Person();
        }

        // Return the person
        return person;
    }
}