package com.ll.chat_ai.domain.article.entity;

import com.ll.chat_ai.domain.member.entity.Member;
import com.ll.chat_ai.global.baseEntity.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Setter
@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class ArticleComment extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    private Article article;

    @ManyToOne(fetch = FetchType.LAZY)
    private Member author;

    private String body;
}
