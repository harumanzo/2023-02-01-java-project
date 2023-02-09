package com.KoreaIT.java.basicAM.controller;

import com.KoreaIT.java.basicAM.dto.Member;

public abstract class Controller {
	public static Member loginedmember;
	public abstract void doAction(String command, String actionMethodName);

}
