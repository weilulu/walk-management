package com.walk.management.article.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.walk.article.entity.ArticleContent;
import com.walk.article.entity.ArticleInfo;
import com.walk.management.article.mapper.ArticleMapper;

@Service
public class ArticleService {

	@Autowired
	private ArticleMapper articleMapper;
	
	public int addArticleInfo(ArticleInfo info){
		int articleId = articleMapper.addArticleInfo(info);
		return articleId;
	}
	public int addArticle(ArticleContent article){
		int result = articleMapper.addArticleConent(article);
		return result;
	}
}
