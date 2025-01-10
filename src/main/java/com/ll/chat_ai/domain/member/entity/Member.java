package com.ll.chat_ai.domain.member.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ll.chat_ai.domain.article.entity.Article;
import com.ll.chat_ai.global.baseEntity.BaseEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Getter @Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class Member extends BaseEntity {
    @Column(unique = true)
    private String username;

    private String password;

    @OneToMany(mappedBy = "author", cascade = CascadeType.REMOVE)
    private List<Article> articleList;

    @JsonIgnore
    private String refreshToken;
}
