package com.parantak.dynamoLambda.person.test;


import com.google.inject.Guice;
import com.google.inject.Injector;

import com.parantak.dynamoLambda.person.model.Person;
import com.parantak.dynamoLambda.person.model.PersonRequest;
import com.amazonaws.services.lambda.runtime.Context;
import com.parantak.dynamoLambda.person.user.MyApp;
import com.parantak.dynamoLambda.person.injector.AppInjector;




public class ClientApp  {

    public static Person cApp(String[] args, Context context){

        Injector injector = Guice.createInjector(new AppInjector());

        PersonRequest personRequest = new PersonRequest(args[0],args[1]);

        MyApp app = injector.getInstance(MyApp.class);

        return app.handleRequest(personRequest, context);
    }
}
