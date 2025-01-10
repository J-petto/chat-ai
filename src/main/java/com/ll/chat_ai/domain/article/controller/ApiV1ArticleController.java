package com.ll.chat_ai.domain.article.controller;

import com.ll.chat_ai.domain.article.dto.ArticleDto;
import com.ll.chat_ai.domain.article.dto.ArticleModifyRequest;
import com.ll.chat_ai.domain.article.dto.ArticleWriteRequest;
import com.ll.chat_ai.domain.article.entity.Article;
import com.ll.chat_ai.domain.article.service.ArticleService;
import com.ll.chat_ai.global.RsData.RsData;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/articles")
@RequiredArgsConstructor
public class ApiV1ArticleController {

    private final ArticleService articleService;

    @GetMapping
    public List<ArticleDto> getArticles() {
        List<Article> articleList = articleService.findAll();

        return articleList.stream().map(ArticleDto::new).toList();
    }

    @GetMapping("/{id}")
    public ArticleDto getArticle(@PathVariable("id") Long id) {

        Article article = articleService.findById(id).orElse(null);

        return new ArticleDto(article);
    }

    @PostMapping
    public RsData<ArticleDto> writeArticle(@RequestBody ArticleWriteRequest articleWriteDto) {
        Article article = articleService.write(articleWriteDto.getTitle(), articleWriteDto.getContent());

        return new RsData<>("200", "게시글이 작성되었습니다", new ArticleDto(article));
    }

    @PatchMapping("/{id}")
    public RsData<ArticleDto> updateArticle(@PathVariable("id") Long id, @Valid @RequestBody ArticleModifyRequest articleModifyRequest) {
        Article article = this.articleService.findById(id).orElse(null);
        Article modifiedArticle = articleService.modify(article, articleModifyRequest.getTitle(), articleModifyRequest.getContent());

        return new RsData<>("200", "게시글이 수정되었습니다.", new ArticleDto(modifiedArticle));
    }

    @DeleteMapping("/{id}")
    public RsData<Void> deleteArticle(@PathVariable("id") Long id){
        articleService.delete(id);

        return new RsData<>("200", "게시글이 수정되었습니다.", null);
    }
}
