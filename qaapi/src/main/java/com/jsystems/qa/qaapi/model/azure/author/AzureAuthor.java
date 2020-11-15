package com.jsystems.qa.qaapi.model.azure.author;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AzureAuthor {


    @JsonProperty(value = "id", required = true)
    public long id;

    @JsonProperty(value = "idBook", required = true)
    public long idBook;

    @JsonProperty(value = "firstName", required = true)
    public String firstName;

    @JsonProperty(value = "lastName", required = true)
    public String lastName;

}
