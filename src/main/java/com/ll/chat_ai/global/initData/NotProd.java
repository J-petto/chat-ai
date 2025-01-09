package com.ll.chat_ai.global.initData;

import com.ll.chat_ai.domain.article.article.entity.Article;
import com.ll.chat_ai.domain.article.article.repository.ArticleRepository;
import com.ll.chat_ai.domain.article.article.service.ArticleService;
import com.ll.chat_ai.domain.chat.chatMessage.service.ChatMessageService;
import com.ll.chat_ai.domain.chat.chatRoom.dto.request.RequestCreateRoom;
import com.ll.chat_ai.domain.chat.chatRoom.entity.ChatRoom;
import com.ll.chat_ai.domain.chat.chatRoom.service.ChatRoomService;
import com.ll.chat_ai.domain.member.member.entity.Member;
import com.ll.chat_ai.domain.member.member.service.MemberService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.transaction.annotation.Transactional;

@Configuration
@Profile("!prod")
public class NotProd {

    @Bean
    public ApplicationRunner initNotProd(ChatRoomService chatRoomService,
                                         ChatMessageService chatMessageService,
                                         MemberService memberService,
                                         ArticleService articleService,
                                         ArticleRepository articleRepository) {
        return new ApplicationRunner() {
            @Transactional
            @Override
            public void run(ApplicationArguments args) throws Exception {
                ChatRoom chatRoom1 = chatRoomService.create(new RequestCreateRoom("공부"));
//            ChatRoom chatRoom2 = chatRoomService.create(new RequestCreateRoom("식사"));
//            ChatRoom chatRoom3 = chatRoomService.create(new RequestCreateRoom("휴식"));
//
//            IntStream.rangeClosed(1, 30).forEach(num -> {
//                chatMessageService.make(1, "황민지", "공부 메시지" + num);
//            });

                Member member1 = memberService.join("user1", "1234").getData();
                Member member2 = memberService.join("user2", "1234").getData();
                Member member3 = memberService.join("user3", "1234").getData();

                Article article1 = articleService.write(member1.getId(), "제목1", "내용1").getData();
                System.out.println("article1= " + article1.toString());
                Article article2 = articleService.write(member1.getId(), "제목2", "내용2").getData();

                Article article3 = articleService.write(member2.getId(), "제목3", "내용3").getData();
                Article article4 = articleService.write(member2.getId(), "제목4", "내용4").getData();

                article1.addComment(member1, "댓글1");
                article1.addComment(member1, "댓글2");

                article2.addComment(member1, "댓글3");
                article2.addComment(member1, "댓글4");
                article2.addComment(member1, "댓글5");

                article3.addComment(member1, "댓글5");
                article3.addComment(member1, "댓글6");
                article3.addComment(member1, "댓글7");
                article3.addComment(member1, "댓글8");
                article3.addComment(member1, "댓글9");
                article3.addComment(member1, "댓글10");
                article3.addComment(member1, "댓글11");
                article3.addComment(member1, "댓글12");

                article1.addTag("자바");
                article1.addTag("백엔드");
                article2.addTags("프레임워크", "스프링부트");
                article4.addTags("자바", "스프링부트");
            }
        };
//        return args -> {
////            ChatRoom chatRoom1 = chatRoomService.create(new RequestCreateRoom("공부"));
////            ChatRoom chatRoom2 = chatRoomService.create(new RequestCreateRoom("식사"));
////            ChatRoom chatRoom3 = chatRoomService.create(new RequestCreateRoom("휴식"));
////
////            IntStream.rangeClosed(1, 30).forEach(num -> {
////                chatMessageService.make(1, "황민지", "공부 메시지" + num);
////            });
//
//            Member member1 = memberService.join("user1", "1234").getData();
//            Member member2 = memberService.join("user2", "1234").getData();
//            Member member3 = memberService.join("user3", "1234").getData();
//
//            Article article1 = articleService.write(member1.getId(), "제목1", "내용1").getData();
//            System.out.println("article1= " + article1.toString());
//            Article article2 = articleService.write(member1.getId(), "제목2", "내용2").getData();
//
//            Article article3 = articleService.write(member2.getId(), "제목3", "내용3").getData();
//            Article article4 = articleService.write(member2.getId(), "제목4", "내용4").getData();
//
//            article1.addComment(member1, "댓글1");
//            article1.addComment(member1, "댓글2");
//
//            article2.addComment(member1, "댓글3");
//            article2.addComment(member1, "댓글4");
//            article2.addComment(member1, "댓글5");
//
//            article3.addComment(member1, "댓글5");
//            article3.addComment(member1, "댓글6");
//            article3.addComment(member1, "댓글7");
//            article3.addComment(member1, "댓글8");
//            article3.addComment(member1, "댓글9");
//            article3.addComment(member1, "댓글10");
//            article3.addComment(member1, "댓글11");
//            article3.addComment(member1, "댓글12");
//
//            articleRepository.save(article1);
//            articleRepository.save(article2);
//            articleRepository.save(article3);
//        };
    }
}
