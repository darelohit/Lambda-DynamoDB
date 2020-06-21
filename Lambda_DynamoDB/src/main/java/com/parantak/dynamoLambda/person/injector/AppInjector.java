package com.parantak.dynamoLambda.person.injector;

import com.google.inject.AbstractModule;
import com.parantak.dynamoLambda.person.handlers.GetPersonHandler;
import com.parantak.dynamoLambda.person.handlers.SetPersonHandler;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class AppInjector extends AbstractModule {

    @Override
    protected void configure(){
        //bind the handler to implementation class

        bind (RequestHandler.class).to(SetPersonHandler.class);
//        bind (RequestHandler.class).to(GetPersonHandler.class);

    }

}
