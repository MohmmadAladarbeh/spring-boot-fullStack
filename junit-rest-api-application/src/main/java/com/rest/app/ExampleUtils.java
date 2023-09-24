package com.rest.app;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;

import java.io.IOException;
import java.io.InputStream;
import java.io.UncheckedIOException;
import java.util.List;
import java.util.Random;

public class ExampleUtils {
    static Random random = new Random();

    public static final String USER_API = "https://jsonplaceholder.typicode.com/posts";
    public static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    public static List<Book> toList(InputStream inputStream) {
        try {
            return OBJECT_MAPPER.readValue(inputStream, new TypeReference<>() {});
        }
        catch (IOException exc) {
            throw new UncheckedIOException(exc);
        }
    }

    public static Post toObject(InputStream inputStream) {
        try {
            return OBJECT_MAPPER.readValue(inputStream, Post.class);
        }
        catch (IOException exc) {
            throw new UncheckedIOException(exc);
        }
    }

    public static String toJson(Post post) {
        try {
            return OBJECT_MAPPER.writeValueAsString(post);
        }
        catch (JsonProcessingException exc) {
            throw new UncheckedIOException(exc);
        }
    }

    public static Post buildPost () {

        Post post = new Post(
                random.nextInt(24),
                random.nextInt(24),
                "Post",
                "body"
        );
        return post;
    }

}
