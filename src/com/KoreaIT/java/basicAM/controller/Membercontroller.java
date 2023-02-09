package com.KoreaIT.java.basicAM.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;


import com.KoreaIT.java.basicAM.dto.Member;

public class Membercontroller extends Controller {
	private static List<Member> members;
	private Scanner sc;
	private String command;
	private String actionMethodName;
	

	public Membercontroller(List<Member> members, Scanner sc) {
		this.members = members;
		this.sc = sc;
	}

	public static void maketestdata() {
		members.add(new Member(1, new Date(), new Date(), "홍길동", "action", "1234"));
		members.add(new Member(2, new Date(), new Date(), "홍길순", "method", "1234"));
		members.add(new Member(3, new Date(), new Date(), "홍학범", "naming", "1234"));
		System.out.println("테스트 회원 만들어짐.");
	}
	
	public static void makeadminaccount() {
		members.add(new Member(0, new Date(), new Date(), "관리자", "admin", "admin1234"));
	}

	public void doAction(String command, String actionMethodName) {
		this.command = command;
		this.actionMethodName = actionMethodName;

		switch (actionMethodName) {
		case "join":
			dojoin();
			break;

		case "login":
			dologin();
			break;

		case "logout":
			dologout();
			break;
			
		case "delete":
			domemberdelete();
			break;
		}

	}

	public void dojoin() {
		int memberid = members.size() + 1;
		Scanner scv = new Scanner(System.in);
		String nickname = null;

		String password = null;

		String password다시 = null;
		String name = null;
		while (true) {
			while (true) {
				System.out.printf("아이디 )");
				nickname = scv.nextLine().trim();
				Member member1 = null;
				if (members.size() == 0) {
					if (nickname.length() < 5) {
						System.out.println("아이디는 다섯글자 이상이어야 합니다.");
						continue;
					} else {
						break;
					}
				} else if (members.size() != 0) {
					for (int p = 0; p < members.size(); p++) {
						Member member2 = members.get(p);
						if ((member2.membername).equals(nickname)) {
							member1 = member2;
							break;
						}
					}
					if (member1 == null) {
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

		
		
		while (true) {
			System.out.printf("이름 )");
			name = scv.nextLine();
			if(name.equals("관리자")) {
				System.out.println("사용 할 수 없는 이름입니다.");
				continue;
			}else {
				break;
			}	
		}
		Date now = new Date();
		Date update = new Date();
		Member member = new Member(memberid, now, update, name, nickname, password);
		members.add(member);
		System.out.println("회원가입이 완료되었습니다.");
		memberid++;
	}

	public void dologin() {
		Scanner scv = new Scanner(System.in);
		String nickname = null;

		String password = null;

		while (true) {

			while (true) {
				System.out.printf("아이디 )");
				nickname = scv.nextLine().trim();
				Member member1 = null;
				if (members.size() == 0) {
					System.out.println("유효하지 않은 아이디입니다.");
					break;
				} else {
					for (int p = 0; p < members.size(); p++) {
						Member members3 = members.get(p);
						if ((members3.membername).equals(nickname)) {
							member1 = members3;
							break;
						}

					}
				}
				if (member1 == null) {
					System.out.println("유호하지 않은 아이디입니다.");
					continue;
				} else {
					break;
				}
			}
			while (true) {
				if (members.size() == 0) {
					break;
				}
				System.out.printf("비밀번호 )");
				password = scv.nextLine().trim();
				Member member1 = null;
				if (members.size() != 0) {
					for (int p = 0; p < members.size(); p++) {
						Member members3 = members.get(p);
						if ((members3.membername).equals(nickname)) {
							member1 = members3;
							break;
						}

					}
				}
				if (loginedmember != null) {
					if (loginedmember.membername.equals(nickname)) {
						System.out.println("이미 로그인된 아이디입니다");
						break;
					} else if (member1.memberpassword.equals(password)) {
						System.out.println("로그인이 완료되었습니다.");
						loginedmember = member1;
						System.out.printf("%s님 환영합니다.\n", loginedmember.name);
						break;
					} else {
						System.out.println("잘못된 비밀번호입니다.");
						continue;
					}
				} else {
					if (member1.memberpassword.equals(password)) {
						System.out.println("로그인이 완료되었습니다.");
						loginedmember = member1;
						System.out.printf("%s님 환영합니다.\n", loginedmember.name);
						break;
					} else {
						System.out.println("잘못된 비밀번호입니다.");
						continue;
					}
				}

			}
			break;
		}
	}

	public void dologout() {
		if (loginedmember != null) {
			System.out.printf("%s님 잘가십시오.\n", loginedmember.name);
			loginedmember = null;
			return;
		} else {
			System.out.println("로그인을 해주십시오");
		}

	}
	
	public void domemberdelete() {
		if(loginedmember == null) {
			System.out.println("권한이 없습니다!!!");
			return;
		}else if(loginedmember.name.equals("admin")) {
			System.out.println("권한이 있습니다!!!");
		}else {
			System.out.println("권한이 없습니다!!!");
		}
	}
	
	

}
