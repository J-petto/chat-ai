package com.ll.chat_ai.domain.member.member.entity;

import com.ll.chat_ai.domain.article.article.entity.Article;
import com.ll.chat_ai.global.baseEntity.BaseEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Getter @Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class Member extends BaseEntity {
    private String username;
    private String password;

    @OneToMany(mappedBy = "author", cascade = CascadeType.REMOVE)
    private List<Article> articleList;
}
