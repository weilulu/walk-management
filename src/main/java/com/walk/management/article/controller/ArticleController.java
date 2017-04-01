package com.walk.management.article.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.walk.article.entity.ArticleContent;
import com.walk.article.entity.ArticleInfo;
import com.walk.management.article.service.ArticleService;
import com.walk.management.common.utils.StringUtil;
import com.walk.management.common.utils.TimeUtils;

@RestController
@RequestMapping("article")
public class ArticleController {

	@Autowired
	private ArticleService articleService;
	
	@RequestMapping("startWrite")
	public ModelAndView startWrite(Model model){
		return new ModelAndView("article/article_write");
	}
	
	@RequestMapping("writeArticle")
	public ModelAndView writeArticle(Model model,HttpServletRequest request){
		String title = request.getParameter("title");
		String author = request.getParameter("author");
		String type = request.getParameter("type");
		String content = request.getParameter("content");
		String postTime = TimeUtils.getNowTimeString("yyyy-MM-dd HH:mm:ss");
		
		
		
		String summary = StringUtil.getSummary(content,50);
		ArticleInfo info = new ArticleInfo();
		info.setTitle(title);
		info.setAuthor(author);
		info.setType(type);
		info.setSummary(summary);
		info.setPostTime(postTime);
		int articleId = articleService.addArticleInfo(info);
		if(articleId == 0){
			return  new ModelAndView("article/post_fail");
		}
		ArticleContent articleContent = new ArticleContent();
		articleContent.setArticleId(articleId);
		articleContent.setTitle(title);
		articleContent.setContent(content);
		int result = articleService.addArticle(articleContent);
		
		model.addAttribute("result",result);
		return  new ModelAndView("article/post_success");
	}
	
}
