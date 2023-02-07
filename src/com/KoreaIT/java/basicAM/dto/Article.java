package com.KoreaIT.java.basicAM.dto;

import java.util.Date;

public class Article extends Dto {

	public int 조회수;
	public String command2;
	public String command3;

	public Article(int id, Date now, Date update, int 조회수, String command2, String command3) {
		this.id = id;
		this.now = now;
		this.update = update;
		this.조회수 = 조회수;
		this.command2 = command2;
		this.command3 = command3;

	}

}