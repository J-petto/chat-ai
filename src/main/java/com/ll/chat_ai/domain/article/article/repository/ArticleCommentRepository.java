package com.ll.chat_ai.domain.article.article.repository;

import com.ll.chat_ai.domain.article.article.entity.ArticleComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleCommentRepository extends JpaRepository<ArticleComment, Long> {

    List<ArticleComment> findByAuthorId(Long authorId);
}
