package com.rest.app;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

public class JonPlaceHolderLayer {


    public static List<BookDTO> getListOfPost (){
        List<BookDTO> postList = new ArrayList<>();

        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest
                .newBuilder(
                    URI.create(ExampleUtils.USER_API)
                )
                .GET()
                .build();

        try {
            HttpResponse<InputStream> response = httpClient.send(
                    request,
                    HttpResponse.BodyHandlers.ofInputStream()
            );

            int statusCode = response.statusCode();

            if (statusCode == 200) {
                postList = ExampleUtils.toList(response.body());
            }
//            response.headers().map().forEach((header, value) -> System.out.println(header + " = " + String.join(", ", value)));
        }
        catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
        return postList;
    }
}
