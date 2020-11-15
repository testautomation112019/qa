package com.jsystems.qa.qaapi;

import com.jsystems.qa.qaapi.model.azure.author.AzureAuthor;
import com.jsystems.qa.qaapi.model.azure.book.Book;
import com.jsystems.qa.qaapi.model.user.UserAzure;
import com.jsystems.qa.qaapi.service.azure.AuthorService;
import com.jsystems.qa.qaapi.service.azure.BookService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Tags({@Tag("ApiTest"), @Tag("AzureTest")})
@DisplayName("Api test")
public class AzureTest {

    @Test
    public void azureUser(){

        UserAzure userAzure = AuthorService.getUserAzureById(1);

        assertThat(userAzure.id).isEqualTo(1);
        assertThat(userAzure.userName).isEqualTo("User 1");
        assertThat(userAzure.password).isEqualTo("Password1");
    }

    @Test
    @DisplayName("Get azure authors")
    public void shouldReturnsAllAzureAuthorsList() {

        List<AzureAuthor> azureAuthors = AuthorService.getAzureAuthors();

        assertThat(azureAuthors.size()).isGreaterThan(0);

        for (AzureAuthor azureAuthor : azureAuthors) {
            int firstNameId = Integer.parseInt(azureAuthor.firstName.replace("First Name ", ""));
            assertThat(azureAuthor.firstName).contains("First Name ");
            assertThat(azureAuthor.firstName).matches("First Name \\d*");
            assertTrue(azureAuthor.id == firstNameId);

        }

    }

    @Test
    @DisplayName("Post Book test")
    public void postBookTest() {
        Book book = new Book(1, "Jsystems", "Szkolenia", 382, "en", "2019-11-22T09:41:54.400Z");
        BookService.postBook(book, 200);
    }

}
