package com.ll.chat_ai.domain.article.service;

import com.ll.chat_ai.domain.article.article.entity.Article;
import com.ll.chat_ai.domain.article.article.entity.ArticleComment;
import com.ll.chat_ai.domain.article.article.entity.ArticleTag;
import com.ll.chat_ai.domain.article.article.service.ArticleCommentService;
import com.ll.chat_ai.domain.article.article.service.ArticleService;
import com.ll.chat_ai.domain.article.article.service.ArticleTagService;
import com.ll.chat_ai.domain.member.member.entity.Member;
import com.ll.chat_ai.domain.member.member.service.MemberService;
import com.ll.chat_ai.global.RsData.RsData;
import com.ll.chat_ai.global.util.Ut;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
@ActiveProfiles("test")
@Transactional
public class ArticleServiceTest {
    @Autowired
    private ArticleService articleService;
    @Autowired
    private MemberService memberService;
    @Autowired
    private ArticleCommentService articleCommentService;
    @Autowired
    private ArticleTagService articleTagService;

    @DisplayName("글 쓰기")
    @Test
    void t1() {
        RsData<Article> writeRs = articleService.write(1, "제목", "내용");
        RsData<Article> writeRs2 = articleService.write(1, "제목1", "내용");
        Article article = writeRs.getData();

        assertThat(article.getId()).isGreaterThan(0L);
    }

    @DisplayName("1번 글을 가져온다.")
    @Test
    void t2() {
        Article article = articleService.findById(1L).get();
        assertThat(article.getTitle()).isEqualTo("제목1");
    }

    @DisplayName("1번 글의 작성자의 username 은 user1 이다.")
    @Test
    void t3() {
        Article article = articleService.findById(1L).get();
        Member author = article.getAuthor();

        assertThat(author.getAuthor()).isEqualTo("user1");
    }

    @DisplayName("1번 글의 제목을 수정한다.")
    @Test
    void t4() {
        Article article = articleService.findById(1L).get();

        Ut.thread.sleep(1000);

        articleService.modify(article, "수정된 제목", "수정된 내용");

        Article article_ = articleService.findById(1L).get();

        assertThat(article_.getTitle()).isEqualTo("수정된 제목");
    }

    @DisplayName("1번 글의 제목을 수정한다.")
    @Test
    void t4_1() {
        Article article = articleService.findById(1L).get();
        System.out.println(article);
//        articleService.modify(article, "수정된 제목", "수정된 내용");

        Article article_ = articleService.findById(1L).get();
        System.out.println(article_);
//        assertThat(article_.getTitle()).isEqualTo("수정된 제목");
    }

    @DisplayName("2번 글에 댓글들을 추가한다.")
    @Test
    @Rollback(false)
    void t5() {
        Member member1 = memberService.findById(1L).get();
        Article article2 = articleService.findById(1L).get();

        article2.addComment(member1, "댓글 입니다.");
    }

    @DisplayName("1번 글의 댓글들을 수정한다.")
    @Test
    void t6() {
        Article article = articleService.findById(1L).get();

        article.getComments().forEach(comment -> {
            articleService.modifyComment(comment, comment.getBody() + "!!");
        });
    }

    @DisplayName("1번 글의 댓글 중 마지막 것을 삭제한다.")
    @Test
    void t7() {
        Article article = articleService.findById(1L).get();

        ArticleComment lastComment = article.getComments().getLast();

        article.removeComment(lastComment);
    }

    @DisplayName("게시물 별 댓글 수 출력")
    @Test
    void t8() {
        List<Article> articles = articleService.findAll();
        articles.forEach(article -> {
            System.out.println("게시물 번호: " + article.getId());
            System.out.println("댓글 수: " + article.getComments().size());
        });
    }

//    @DisplayName("태그 존재 확인")
//    @Test
//    void t8_1() {
//        Article article = articleService.findById(1L).get();
//
//        System.out.println(article.getTags());
//    }

    @DisplayName("1번 게시물의 태그(String)를 반환한다.")
    @Test
    void t9() {
        Article article1 = articleService.findById(1L).get();

        String tagsStr = article1.getTagsStr();
        assertThat(tagsStr).isEqualTo("#자바 #백엔드");
    }

    @DisplayName("1번 게시물 toString")
    @Test
    void t10() {
        Article article1 = articleService.findById(1L).get();

        System.out.println(article1);
    }

    @DisplayName("1번 회원이 작성한 댓글들")
    @Test
    void t11() {
        List<ArticleComment> articleComments = articleCommentService.findByAuthorId(1L);

        assertThat(articleComments.size()).isGreaterThan(0);
    }

    @DisplayName("1번 회원이 작성한 태그들")
    @Test
    void t12() {
        List<ArticleTag> articleTags = articleTagService.findByAuthorId(1L);

        assertThat(articleTags.size()).isGreaterThan(0);
    }

    @DisplayName("아이디가 user1 인 회원이 작성한 태그들")
    @Test
    void t13() {
        List<ArticleTag> articleTags = articleTagService.findByAuthorUsername("user1");

        assertThat(articleTags.size()).isGreaterThan(0);
    }
}
