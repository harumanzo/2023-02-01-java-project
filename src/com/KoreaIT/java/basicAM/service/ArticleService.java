package com.KoreaIT.java.basicAM.service;

import com.KoreaIT.java.basicAM.container.Container;
import com.KoreaIT.java.basicAM.dao.ArticleDao;
import com.KoreaIT.java.basicAM.dto.Article;

public class ArticleService  {
	private ArticleDao articleDao;
	public ArticleService() {
		this.articleDao = Container.articleDao;
	}
public void add(Article article) {
		articleDao.add(article);
	}

public void remove(int i) {
	articleDao.remove(i);
}
}
