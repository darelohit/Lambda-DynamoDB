package com.parantak.dynamoLambda.person.easymock;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.parantak.dynamoLambda.person.handlers.GetPersonHandler;
import com.parantak.dynamoLambda.person.handlers.SetPersonHandler;

import static org.easymock.EasyMock.*;
import static org.junit.jupiter.api.Assertions.*;

import org.easymock.EasyMockSupport;
import org.easymock.Mock;
import org.easymock.TestSubject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class EasyAnnotation {

    @Mock
    private RequestHandler mockRequestHandler;

    @TestSubject
    private GetPersonHandler getPersonHandler = new GetPersonHandler();

    @BeforeEach
    public void setup() {
        EasyMockSupport.injectMocks(this);
    }

    @Test
    public void test(Context context) {

    }
}
