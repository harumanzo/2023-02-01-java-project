package com.KoreaIT.java.basicAM;

import java.util.Date;

class Article extends Dto {

	int 조회수;
	String command2;
	String command3;

	public Article(int id, Date now, Date update, int 조회수, String command2, String command3) {
		this.id = id;
		this.now = now;
		this.update = update;
		this.조회수 = 조회수;
		this.command2 = command2;
		this.command3 = command3;

	}

}