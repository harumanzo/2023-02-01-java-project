package com.KoreaIT.java.basicAM.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.KoreaIT.java.basicAM.dto.Id;
import com.KoreaIT.java.basicAM.dto.Member;

public class Membercontroller {
	static List<Id> ids = new ArrayList<>();
	private List<Member> members;
	private Scanner sc;

	public Membercontroller(List<Member> members, Scanner sc) {
		this.members = members;
		this.sc = sc;
	}

	public void dojoin(Scanner sc) {
		int memberid = members.size() + 1;
		Scanner scv = new Scanner(System.in);
		String nickname = null;

		String password = null;

		String password다시 = null;
		while (true) {
			while (true) {
				System.out.printf("아이디 )");
				nickname = scv.nextLine().trim();
				Id id1 = null;
				if (ids.size() == 0) {
					if (nickname.length() < 5) {
						System.out.println("아이디는 다섯글자 이상이어야 합니다.");
						continue;
					} else {
						break;
					}
				} else if (ids.size() != 0) {
					for (int p = 0; p < ids.size(); p++) {
						Id id3 = ids.get(p);
						if ((id3.nickname).equals(nickname)) {
							id1 = id3;
							break;
						}
					}
					if (id1 == null) {
						if (nickname.length() < 5) {
							System.out.println("아이디는 다섯글자 이상이어야 합니다.");
							continue;
						} else {
							break;
						}
					} else {
						System.out.println("중복되는 아이디입니다.");
						continue;
					}
				}

			}
			while (true) {
				System.out.printf("비번 )");
				password = scv.nextLine();
				System.out.printf("비번확인 )");
				password다시 = scv.nextLine();
				if (password.equals(password다시) == false) {
					System.out.println("비밀번호가 일치하지 않습니다.");
					continue;
				} else {
					break;
				}

			}
			break;
		}

		System.out.printf("이름 )");
		String name = scv.nextLine();
		Date now = new Date();
		Date update = new Date();
		Member member = new Member(memberid, now, update, name, nickname, password);
		members.add(member);
		Id id = new Id(nickname);
		ids.add(id);
		System.out.println("회원가입이 완료되었습니다.");
		memberid++;
	}
}
