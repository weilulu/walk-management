package com.walk.management.article.mapper.provider;

import org.apache.ibatis.jdbc.SQL;

import com.walk.article.entity.ArticleContent;
import com.walk.article.entity.ArticleInfo;

public class ArticleProvider {

	public String addArticleInfo(final ArticleInfo info){
		SQL sql = new SQL(){{
			INSERT_INTO("article_info");
			VALUES("title","'"+info.getTitle()+"'");
			VALUES("type","'"+info.getType()+"'");
			VALUES("author","'"+info.getAuthor()+"'");
			VALUES("summary","'"+info.getSummary()+"'");
			VALUES("post_time","'"+info.getPostTime()+"'");
		}};
		return sql.toString();
	}
	
	public String addArticleConent(final ArticleContent content){
		SQL sql = new SQL(){{

			INSERT_INTO("article_content");
			VALUES("article_id","'"+content.getArticleId()+"'");
			VALUES("title","'"+content.getTitle()+"'");
			VALUES("content","'"+content.getContent()+"'");
		}};
		return sql.toString();
	}
}
