package com.fabio.literalura_api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Book(Long id, String title, List<Author> authors, String isbn, List<String> languages, int download_count) {

    @Override
    public String toString() {
        return """
                
                -------- LIVRO --------
                Titulo: %s
                Authors: %s
                Languages: %s
                Download Count: %s
                -----------------------
                """.formatted(title, authors.getFirst().name(), languages, download_count);
    }
}
