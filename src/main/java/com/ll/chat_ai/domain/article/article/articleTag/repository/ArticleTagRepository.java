package com.ll.chat_ai.domain.article.article.articleTag.repository;

import com.ll.chat_ai.domain.article.article.articleTag.entity.ArticleTag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleTagRepository extends JpaRepository<ArticleTag, Long> {
    List<ArticleTag> findArticleTagByArticleAuthorId(long id);

    List<ArticleTag> findArticleTagByArticleAuthorUsername(String author);
}