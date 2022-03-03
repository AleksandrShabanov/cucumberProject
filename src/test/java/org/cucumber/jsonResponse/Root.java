package org.cucumber.jsonResponse;

import io.cucumber.messages.internal.com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Objects;

public class Root {
    public Category category = new Category();
    public String description;
    public String title;
    public int numberOfDownloads;
    @JsonIgnore
    public Object iconData;
    public Author author = new Author();
    @JsonIgnore
    public Object imageData;
    @JsonIgnore
    public long uploadedTimeStamp;

    @Override
    public String toString() {
        return "{" +
                "title=" + title +
                "," + description +
                "," + category.title +
                "," + author.name +
                ",# of downloads: " + numberOfDownloads +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Root root = (Root) o;
        return numberOfDownloads == root.numberOfDownloads && Objects.equals(category.title, root.category.title) && Objects.equals(description, root.description) && Objects.equals(title, root.title) && Objects.equals(author.name, root.author.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(category.title, description, title, numberOfDownloads, author.name);
    }

}

