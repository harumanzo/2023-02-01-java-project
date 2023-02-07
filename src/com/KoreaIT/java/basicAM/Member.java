package com.KoreaIT.java.basicAM;
import java.util.Date;

public class Member extends Dto {

	String membername;
	String memberpassword;
	String name;
	
	
	public Member(int id, Date now, Date update, String name, String membername, String memberpassword){
		this.id = id;
		this.now = now;
		this.update = update;
		this.name = name;
		this.membername = membername;
		this.memberpassword = memberpassword;
		
	}

}
