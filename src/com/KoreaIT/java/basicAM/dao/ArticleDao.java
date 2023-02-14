package com.KoreaIT.java.basicAM.dao;


import java.util.ArrayList;
import java.util.List;

import com.KoreaIT.java.basicAM.dto.Article;

public class ArticleDao {
	public List<Article> articles;

	public ArticleDao() {
		articles = new ArrayList<>();
	}

	public void add(Article article) {
		articles.add(article);
		
	}

	public void remove(int i) {
		articles.remove(i);
		
	}
}
