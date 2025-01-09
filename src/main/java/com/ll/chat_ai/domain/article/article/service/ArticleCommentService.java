package com.ll.chat_ai.domain.article.article.service;

import com.ll.chat_ai.domain.article.article.entity.ArticleComment;
import com.ll.chat_ai.domain.article.article.repository.ArticleCommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ArticleCommentService {

    private final ArticleCommentRepository articleCommentRepository;

    public List<ArticleComment> findByAuthorId(Long id) {
        return articleCommentRepository.findByAuthorId(id);
    }

}
