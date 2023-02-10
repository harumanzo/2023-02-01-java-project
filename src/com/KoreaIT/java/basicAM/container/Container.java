package com.KoreaIT.java.basicAM.container;

import com.KoreaIT.java.basicAM.dao.ArticleDao;
import com.KoreaIT.java.basicAM.dao.MemberDao;

public class Container {
	public static ArticleDao articleDao;
	public static MemberDao memberDao;

	static {
		articleDao = new ArticleDao();
		memberDao = new MemberDao();
	}
}
