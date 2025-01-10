package com.ll.chat_ai.domain.article.service;

import com.ll.chat_ai.domain.article.entity.Article;
import com.ll.chat_ai.domain.article.entity.ArticleComment;
import com.ll.chat_ai.domain.article.repository.ArticleRepository;
import com.ll.chat_ai.domain.member.entity.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional(readOnly = true)
@Service
@RequiredArgsConstructor
public class ArticleService {
    private final ArticleRepository articleRepository;

    @Transactional
    public Article write(String title, String content) {
        Article article = Article.builder()
                .author(Member.builder().id(1L).build())
                .title(title)
                .content(content)
                .build();

        return articleRepository.save(article);
    }

    public Optional<Article> findById(long no) {
        return articleRepository.findById(no);
    }

    @Transactional
    public Article modify(Article article, String title, String content) {
        article.setTitle(title);
        article.setContent(content);

        return article;
    }

    @Transactional
    public void modifyComment(ArticleComment articleComment, String content) {
        articleComment.setBody(content);
    }

    public List<Article> findAll() {
        return articleRepository.findAll();
    }

    @Transactional
    public void delete(Long id) {
        articleRepository.deleteById(id);
    }
}
