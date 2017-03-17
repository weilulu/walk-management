package com.walk.management.article.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("article")
public class ArticleController {

	@RequestMapping("writeArticle")
	public ModelAndView writeArticle(Model model){
		return new ModelAndView("article/article_write");
	}
}
