package com.fabio.literalura_api.service;

import com.fabio.literalura_api.client.GutendexClient;
import com.fabio.literalura_api.model.Book;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class BookService {

    @Autowired
    private GutendexClient client;

    private final ObjectMapper mapper = new ObjectMapper();

    public List<Book> getBooks() throws IOException, InterruptedException {
        String json = client.get("/books/").body();

        return mapper.readValue(mapper.readTree(json).get("results").toString(), new TypeReference<>(){});
    }

    public Book getBookByTitle(String title) throws IOException, InterruptedException {
        return getBooks().stream().filter(book -> book.title().contains(title)).findFirst().orElse(null);
    }
}
