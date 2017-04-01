package com.walk.management.article.mapper;

import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectKey;

import com.walk.article.entity.ArticleContent;
import com.walk.article.entity.ArticleInfo;
import com.walk.management.article.mapper.provider.ArticleProvider;

@Mapper
public interface ArticleMapper {

	@InsertProvider(type=ArticleProvider.class,method="addArticleInfo")
	@SelectKey(statement="call last_id_in_article_info()", keyProperty="id", before=false, resultType=int.class)
	int addArticleInfo(ArticleInfo info);
	
	@InsertProvider(type=ArticleProvider.class,method="addArticleConent")
	int addArticleConent(ArticleContent content);
}
