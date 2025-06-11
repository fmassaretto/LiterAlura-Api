package com.fabio.literalura_api.client;

import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Component
public class GutendexClient {

    private final String URL = "https://gutendex.com";

    public HttpResponse<String> get(String path) throws IOException, InterruptedException {
        var uri = URL + path;
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(uri)).build();

        return client.send(request, HttpResponse.BodyHandlers.ofString());
    }
}
