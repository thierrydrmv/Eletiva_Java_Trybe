package com.betrybe.alexandria.controllers.dto;

import com.betrybe.alexandria.models.entities.BookDetail;
import com.fasterxml.jackson.annotation.JsonProperty;

public record BookDetailDto(
        Long id,
        String summary,
        // Se o Json que recebermos estiver em snakecase precisa transformar em camelCase
        @JsonProperty("page_count")
        Integer pageCount,
        String year,
        String isbn) {

        public BookDetail toBookDetail() {
                return new BookDetail(id, summary, pageCount, year, isbn, null);
        }
}
