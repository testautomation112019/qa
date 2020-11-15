package com.jsystems.qa.qaapi.model.user;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserAzure {
    @JsonProperty(value = "id")
    public int id;


    @JsonProperty(value = "userName")
    public String userName;

    @JsonProperty(value = "password")
    public String password;
}
