package com.KoreaIT.java.basicAM.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.KoreaIT.java.basicAM.dto.Article;
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
		members.add(new Member(1, new Date(), new Date(), "홍길동", "action", "1234",1));
		members.add(new Member(2, new Date(), new Date(), "홍길순", "method", "1234",1));
		members.add(new Member(3, new Date(), new Date(), "홍학범", "naming", "1234",1));
		System.out.println("테스트 회원 만들어짐.");
	}

	public static void makeadminaccount() {
		members.add(new Member(0, new Date(), new Date(), "관리자", "admin", "admin1234",0));
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
			doadminsomething(command);
			break;

		case "detail":
			doadminsomething(command);
			break;
			
		case "list":
			doadminsomething(command);
			break;

		case "modify":
			dosomething(command);
			break;
		
		case "withdraw":
			dosomething(command);
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
			if (name.equals("관리자")) {
				System.out.println("사용 할 수 없는 이름입니다.");
				continue;
			} else {
				break;
			}
		}
		Date now = new Date();
		Date update = new Date();
		Member member = new Member(memberid, now, update, name, nickname, password, 0);
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

	public void doadminsomething(String command) {

		if (loginedmember == null) {
			System.out.println("권한이 없습니다!!!");
			return;
		} else if (loginedmember.membername.equals("admin")) {
			System.out.println("멤버 관리모드입니다.");
		} else {
			System.out.println("권한이 없습니다!!!");
			return;
		}
		String[] arr = command.split(" ");

		if (arr.length < 3) {
			if (arr[1].equals("list")) {
				if (members.size() == 0) {
					System.out.println("회원이 없습니다.");
				} else {
					System.out.println("회원번호 /  이름  /  아이디  /  게시글수");
					for (int i2 = members.size() - 1; i2 >= 0; i2--) {
						Member members2 = members.get(i2);
						System.out.println(members2.id + "   / " + members2.name + "  /  " + members2.membername +"  /  " +members2.memberwrite);
					}
				}
			}else {
				System.out.println("존재하지 않는 명령어입니다");
				return;
			}			
		} else {
			int n = Integer.parseInt(arr[2]);
			Member foundMember = null;

			if (members.size() == 0) {
				System.out.println(n + "번 회원은 존재하지 않습니다.");
			} else {
				for (int p = 0; p <= members.size(); p++) {
					Member member1 = members.get(p);
					if (n == member1.id) {
						foundMember = member1;
						break;
					}

				}
			}
			if (foundMember == null) {
				System.out.println(n + "번 회원은 존재하지 않습니다.");
			} else {
				if (arr[1].equals("detail")) {
					SimpleDateFormat formatter = new SimpleDateFormat("YYYY-dd-MM HH:mm:ss");
					System.out.println("회원번호 : " + foundMember.id);
					System.out.println("가입날짜 : " + formatter.format(foundMember.now));
					System.out.println("정보 수정날짜 : " + formatter.format(foundMember.update));
					System.out.println("회원이름 : " + foundMember.name);
					System.out.println("회원 아이디 : " + foundMember.membername);
					System.out.println("회원 비밀번호 : " + foundMember.memberpassword);
					System.out.println("작성 게시글 수 : " + foundMember.memberwrite);

				} else if (arr[1].equals("delete")) {
					for (int p = 0; p <= members.size(); p++) {
						Member member3 = members.get(p);
						if (n == member3.id) {
							members.remove(p);
							System.out.println(n + "번 회원이 삭제되었습니다.");
							break;
						}

					}
				}
			}

		}

	}

	public void dosomething(String command) {
		String[] arr = command.split(" ");
		if (members.size() == 0) {
			System.out.println("유효한 계정이 존재하지 않습니다!!");
			return;
		}

		if (loginedmember == null) {
			System.out.println("로그인을 먼저 해주십시오!!!");
		} else {
			Member foundMember = null;
			for (int p = 0; p <= members.size(); p++) {
				Member member1 = members.get(p);
				if (loginedmember.membername.equals(member1.membername)) {
					foundMember = member1;
					break;
				}

			}

			if (foundMember == null) {
				System.out.println("잘못된 접근입니다");

			} else if (arr[1].equals("modify")) {
				System.out.printf("바꾸실 이름 )");
				Scanner scv = new Scanner(System.in);
				String newname = scv.nextLine();
				String newpassword = null;
				String newpasswordconfirm = null;
				while(true) {
					System.out.printf("바꾸실 비밀번호 )");
					newpassword = scv.nextLine();
					System.out.printf("바꾸실 비밀번호 확인 )");
					newpasswordconfirm = scv.nextLine();
					if (newpassword.equals(newpasswordconfirm)) {
						System.out.println("비밀번호가 일치하지 않습니다.");
						continue;
					}
					break;
				}
				Date update = new Date();

				foundMember.name = newname;
				foundMember.memberpassword = newpassword;
				foundMember.update = update;
				System.out.println("회원님의 정보가 수정되었습니다.");
			}
			
			if (arr[1].equals("mypage")) {
				SimpleDateFormat formatter = new SimpleDateFormat("YYYY-dd-MM HH:mm:ss");
				System.out.println("회원번호 : " + foundMember.id);
				System.out.println("가입날짜 : " + formatter.format(foundMember.now));
				System.out.println("정보 수정날짜 : " + formatter.format(foundMember.update));
				System.out.println("회원이름 : " + foundMember.name);
				System.out.println("회원 아이디 : " + foundMember.membername);
				System.out.println("회원 비밀번호 : " + foundMember.memberpassword);
				System.out.println("작성 게시글 수 : " + foundMember.memberwrite);

			} else if (arr[1].equals("withdraw")) {
				for (int p = 0; p <= members.size(); p++) {
					Member member3 = members.get(p);
					if (loginedmember.membername.equals(member3.membername)) {
						members.remove(p);
						System.out.println("회원이 삭제되었습니다.");
						break;
					}

				}
			}

		}
	}
}