package com.KoreaIT.java.basicAM;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import com.KoreaIT.java.basicAM.dto.Article;
import com.KoreaIT.java.basicAM.dto.Id;
import com.KoreaIT.java.basicAM.dto.Member;

public class App {
	static List<Article> articles = new ArrayList<>();
	static List<Member> members = new ArrayList<>();
	static List<Id> ids = new ArrayList<>();

	public void run() {
		System.out.println("========프로그램 시작========");
		Scanner sc = new Scanner(System.in);

		maketestdata();

		while (true) {

			System.out.printf("명령어 )");
			String command = sc.nextLine().trim();

			if (command.equals("article list")) {
				if (articles.size() == 0) {
					System.out.println("게시글이 없습니다.");
				} else {
					System.out.println("번호 /  제목  /  조회수");
					for (int i2 = articles.size() - 1; i2 >= 0; i2--) {
						Article articles2 = articles.get(i2);
						System.out.println(articles2.id + "   / " + articles2.command2 + "  /  " + articles2.조회수);
					}
				}
			}

			else if (command.equals("New member")) {
				int memberid = members.size() + 1;
				Scanner scv = new Scanner(System.in);
				String nickname = null;

				String password = null;

				String password다시 = null;
				while (true) {
					while (true) {
						System.out.printf("아이디 )");
						nickname = scv.nextLine();
						if (ids.size() == 0) {
							break;
						} else {
							for (int p = 0; p < ids.size(); p++) {
								Id id3 = ids.get(p);
								if ((id3.nickname).equals(nickname)) {
									System.out.println("중복되는 아이디입니다.");
									break;

								}

							}
							continue;

						}
					}

					System.out.printf("비번 )");
					password = scv.nextLine();
					System.out.printf("비번확인 )");
					password다시 = scv.nextLine();
					if (password.equals(password다시) == false) {
						System.out.println("비밀번호가 일치하지 않습니다.");
						continue;
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

			else if (command.equals("article write")) {
				int i = articles.size() + 1;
				System.out.printf("제목 )");
				Scanner scv = new Scanner(System.in);
				String command2 = scv.nextLine();
				System.out.printf("내용 )");
				String command3 = scv.nextLine();
				Date now = new Date();
				Date update = new Date();
				int 조회수 = 0;

				Article article = new Article(i, now, update, 조회수, command2, command3);
				articles.add(article);
				System.out.println(i + "번글이 생성되었습니다");
				i++;
			}

			else if (command.startsWith("article")) {
				String[] arr = command.split(" ");
				if (arr.length < 3) {
					System.out.println("존재하지 않는 명령어입니다");
					continue;
				} else {
					int n = Integer.parseInt(arr[2]);
					Article foundArticle = null;

					if (articles.size() == 0) {
						System.out.println(n + "번 게시물은 존재하지 않습니다.");
					} else {
						for (int p = 1; p <= articles.size(); p++) {
							Article article3 = articles.get(p - 1);
							if (n == article3.id) {
								foundArticle = article3;
								break;
							}

						}
					}
					if (foundArticle == null) {
						System.out.println(n + "번 게시물은 존재하지 않습니다.");
						continue;

					} else {
						if (arr[1].equals("detail")) {
							foundArticle.조회수++;
							SimpleDateFormat formatter = new SimpleDateFormat("YYYY-dd-MM HH:mm:ss");
							System.out.println("번호 : " + foundArticle.id);
							System.out.println("날짜 : " + formatter.format(foundArticle.now));
							System.out.println("날짜 : " + formatter.format(foundArticle.update));
							System.out.println("조회수 : " + foundArticle.조회수);
							System.out.println("제목 : " + foundArticle.command2);
							System.out.println("내용 : " + foundArticle.command3);

						} else if (arr[1].equals("delete")) {
							for (int p = 1; p <= articles.size(); p++) {
								Article article3 = articles.get(p - 1);
								if (n == article3.id) {
									articles.remove(p - 1);
									System.out.println(n + "번 게시물이 삭제되었습니다.");
									break;
								}

							}
						} else if (arr[1].equals("modify")) {
							System.out.printf("제목 )");
							Scanner scv = new Scanner(System.in);
							String command2 = scv.nextLine();
							System.out.printf("내용 )");
							String command3 = scv.nextLine();
							Date update = new Date();

							foundArticle.command2 = command2;
							foundArticle.command3 = command3;
							foundArticle.update = update;
							System.out.println(n + "번 게시물이 수정되었습니다.");
						}

					}

				}

			}

			else if (command.equals("system exit")) {
				break;
			}

			else {
				System.out.println("존재하지 않는 명령어입니다");
			}

		}

		System.out.println("========프로그램 종료========");
		sc.close();
	}

	public static void maketestdata() {
		articles.add(new Article(1, new Date(), new Date(), 0, "테스트", "테스트"));
		articles.add(new Article(2, new Date(), new Date(), 0, "테스트", "테스트"));
		articles.add(new Article(3, new Date(), new Date(), 0, "테스트", "테스트"));
		System.out.println("테스트 자료 만들어짐.");

	}
}
