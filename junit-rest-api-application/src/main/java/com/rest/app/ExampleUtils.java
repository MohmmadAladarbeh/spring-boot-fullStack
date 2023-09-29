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

    public static List<BookDTO> toList(InputStream inputStream) {
        try {
            return OBJECT_MAPPER.readValue(inputStream, new TypeReference<>() {});
        }
        catch (IOException exc) {
            throw new UncheckedIOException(exc);
        }
    }

    public static BookDTO toObject(InputStream inputStream) {
        try {
            return OBJECT_MAPPER.readValue(inputStream, BookDTO.class);
        }
        catch (IOException exc) {
            throw new UncheckedIOException(exc);
        }
    }

    public static String toJson(BookDTO book) {
        try {
            return OBJECT_MAPPER.writeValueAsString(book);
        }
        catch (JsonProcessingException exc) {
            throw new UncheckedIOException(exc);
        }
    }

    public static BookDTO buildPost () {

        BookDTO post = new BookDTO(
                (long) random.nextInt(24),
                (long) random.nextInt(24),
                "Post",
                "body"
        );
        return post;
    }

}
