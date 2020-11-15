package com.jsystems.qa.qaapi.model.azure.book;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Book {

    @JsonProperty(value = "id", required = true)
    public long id;

    @JsonProperty(value = "title", required = true)
    public String title;

    @JsonProperty(value = "description", required = true)
    public String description;

    @JsonProperty(value = "pageCount", required = true)
    public int pageCount;

    @JsonProperty(value = "excerpt", required = true)
    public String excerpt;

    @JsonProperty(value = "publishDate", required = true)
    public String publishDate;

    public Book(long id, String title, String description, int pageCount, String excerpt, String publishDate) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.pageCount = pageCount;
        this.excerpt = excerpt;
        this.publishDate = publishDate;
    }

    public Book() {
    }
}
