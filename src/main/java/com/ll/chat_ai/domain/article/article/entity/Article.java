package com.ll.chat_ai.domain.article.article.entity;

import com.ll.chat_ai.domain.article.article.articleComment.entity.ArticleComment;
import com.ll.chat_ai.domain.article.article.articleTag.entity.ArticleTag;
import com.ll.chat_ai.domain.member.member.entity.Member;
import com.ll.chat_ai.global.jpa.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static jakarta.persistence.CascadeType.ALL;

@Setter
@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Article extends BaseEntity {
    private String title;
    private String content;

    @ManyToOne
    private Member author;

    @OneToMany(mappedBy = "article", cascade = ALL /*CascadeType.ALL*/, orphanRemoval = true)
    @Builder.Default
    // Bilder로 생성하게 되면 해당 생성자를 무시하게 된다.
    // 빌드할 때 강제 디폴트 값을 가지게한다.
    private List<ArticleComment> comments = new ArrayList<>();

    @OneToMany(mappedBy = "article", cascade = ALL /*CascadeType.ALL*/, orphanRemoval = true)
    @Builder.Default
    private List<ArticleTag> tags = new ArrayList<>();

    public void addComment(Member author, String content) {
        ArticleComment comment = ArticleComment.builder().article(this).author(author).body(content).build();
        comments.add(comment);
    }

    public void removeComment(ArticleComment comment) {
        comments.remove(comment);
    }

    public void addTag(String content) {
            ArticleTag articleTag = ArticleTag.builder().article(this).content(content).build();
            tags.add(articleTag);
        }

    public void addTags(String... contents) {
        for (String content : contents) {
            ArticleTag articleTag = ArticleTag.builder().article(this).content(content).build();
            tags.add(articleTag);
        }
    }

    public String getTagsStr() {
        return tags.stream().map(tag -> "#" + tag.getContent())
                .collect(Collectors.joining(" "));
    }
}
