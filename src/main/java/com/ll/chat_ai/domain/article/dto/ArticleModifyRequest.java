package com.ll.chat_ai.domain.article.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ArticleModifyRequest {
    @NotBlank
    private final String title;

    @NotBlank
    private final String content;

    public ArticleModifyRequest(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
