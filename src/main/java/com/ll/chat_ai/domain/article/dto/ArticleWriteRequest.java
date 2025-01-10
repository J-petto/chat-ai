package com.ll.chat_ai.domain.article.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ArticleWriteRequest {
    @NotBlank
    private final String title;
    @NotBlank
    private final String content;

    public ArticleWriteRequest(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
