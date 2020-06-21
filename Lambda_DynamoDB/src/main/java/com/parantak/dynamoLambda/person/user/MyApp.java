package com.parantak.dynamoLambda.person.user;

import javax.inject.Inject;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.parantak.dynamoLambda.person.model.Person;
import com.parantak.dynamoLambda.person.model.PersonRequest;

public class MyApp {
    private RequestHandler handler;

    // setter method injector
    @Inject
    public void setHandler(RequestHandler hdl){
        this.handler = hdl;
    }

    public Person handleRequest(PersonRequest personRequest, Context context){
        return (Person) handler.handleRequest(personRequest, context);
    }
}
