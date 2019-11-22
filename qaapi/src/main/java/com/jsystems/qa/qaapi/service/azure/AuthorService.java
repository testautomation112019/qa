package com.jsystems.qa.qaapi.service.azure;

import com.jsystems.qa.qaapi.model.azure.author.AzureAuthor;
import com.jsystems.qa.qaapi.model.user.UserAzure;
import com.jsystems.qa.qaapi.specification.Specification;
import io.restassured.RestAssured;

import java.util.List;

public class AuthorService {
    private static final String API_AUTHORS = "/api/Authors";
    private static final String API_USERS_ID = "/api/Users/{id}";

    public static UserAzure getUserAzureById(long id) {
        return RestAssured.given()
                .spec(Specification.fakeAzureSpecBuilder())
//                .queryParam("name", "Piotr")
//                .queryParam("surname", "Kowalski")
                .when()
                .get(API_USERS_ID, id)
                .andReturn()
                .then()
                .assertThat()
                .statusCode(200)
                .extract()
                .body()
                .as(UserAzure.class);
    }

    public static List<AzureAuthor> getAzureAuthors() {
        return RestAssured.given()
                .spec(Specification.fakeAzureSpecBuilder())
                .when()
                .get(API_AUTHORS)
                .then()
                .assertThat()
                .statusCode(200)
                .extract()
                .body()
                .jsonPath()
                .getList("", AzureAuthor.class);

    }
}
