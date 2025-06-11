package com.fabio.literalura_api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record BookPaged(int count, String next, String previous, List<String> results) {
}
