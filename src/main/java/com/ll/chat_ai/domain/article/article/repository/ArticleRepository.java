package com.ll.chat_ai.domain.article.article.repository;

import com.ll.chat_ai.domain.article.article.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long>, ArticleRepositoryCustom {
//    List<Article> findByOrderByIdDesc();
}
