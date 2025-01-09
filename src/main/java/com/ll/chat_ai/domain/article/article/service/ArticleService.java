package com.ll.chat_ai.domain.article.article.service;

import com.ll.chat_ai.domain.article.article.entity.Article;
import com.ll.chat_ai.domain.article.article.entity.ArticleComment;
import com.ll.chat_ai.domain.article.article.repository.ArticleRepository;
import com.ll.chat_ai.domain.member.member.entity.Member;
import com.ll.chat_ai.global.RsData.RsData;
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
    public RsData<Article> write(long no, String title, String content) {
        Article article = Article.builder()
                .author(Member.builder().id(no).build())
                .title(title)
                .content(content)
                .build();
        articleRepository.save(article);

        return RsData.of("200", String.format("%s 게시글 등록", title), article);
    }

    public Optional<Article> findById(long no) {
        return articleRepository.findById(no);
    }

    @Transactional
    public void modify(Article article, String title, String content) {
        article.setTitle(title);
        article.setContent(content);
    }

    @Transactional
    public void modifyComment(ArticleComment articleComment, String content) {
        articleComment.setBody(content);
    }

    public List<Article> findAll() {
        return articleRepository.findAll();
    }
}
