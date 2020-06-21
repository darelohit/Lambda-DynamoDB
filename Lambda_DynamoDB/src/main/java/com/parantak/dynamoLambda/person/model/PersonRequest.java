package com.parantak.dynamoLambda.person.model;

public class PersonRequest {
    private String id;
    private String name;

    public PersonRequest() {
    }
    public PersonRequest(String id) {
        this.id = id;
    }
    public PersonRequest(String id, String name){
        this.id = id;
        this.name = name;
    }
    public String getId() {
        return id;
    }
    public String getName() {
        return name;
    }
}
