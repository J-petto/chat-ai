package com.ll.chat_ai.domain.article.service;

import com.ll.chat_ai.domain.article.entity.ArticleTag;
import com.ll.chat_ai.domain.article.repository.ArticleTagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ArticleTagService {
    private final ArticleTagRepository articleTagRepository;

    public List<ArticleTag> findByAuthorId(long id) {
        return articleTagRepository.findArticleTagByArticleAuthorId(id);
    }

    public List<ArticleTag> findByAuthorUsername(String username) {
        return articleTagRepository.findArticleTagByArticleAuthorUsername(username);
    }
}