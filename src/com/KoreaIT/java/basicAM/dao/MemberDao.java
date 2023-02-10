package com.KoreaIT.java.basicAM.dao;

import java.util.ArrayList;
import java.util.List;

import com.KoreaIT.java.basicAM.dto.Member;

public class MemberDao {
	public List<Member> members;

	public MemberDao() {
		members = new ArrayList<>();
	}
}
