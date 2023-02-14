package com.KoreaIT.java.basicAM.container;

import com.KoreaIT.java.basicAM.dao.ArticleDao;
import com.KoreaIT.java.basicAM.dao.MemberDao;
import com.KoreaIT.java.basicAM.service.ArticleService;

public class Container {
	public static ArticleDao articleDao;
	public static MemberDao memberDao;
	public static ArticleService articleService;

	static {
		articleDao = new ArticleDao();
		memberDao = new MemberDao();
		articleService = new ArticleService();
	}
}
