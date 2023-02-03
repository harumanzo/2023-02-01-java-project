package com.KoreaIT.java.basicAM;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		System.out.println("========프로그램 시작========");
		Scanner sc = new Scanner(System.in);
		int i = 1;
		List<Article> articles = new ArrayList<>();

		while (true) {
			System.out.printf("명령어 )");
			String command = sc.nextLine().trim();

			if (command.equals("article list")) {
				if (articles.size() == 0) {
					System.out.println("게시글이 없습니다.");
				} else {
					System.out.println("번호 / 제목");
					for (int i2 = articles.size() - 1; i2 >= 0; i2--) {
						Article articles2 = articles.get(i2);
						System.out.println(articles2.i + "   / " + articles2.command2);
					}
				}
			}

			else if (command.equals("article write")) {
				System.out.printf("제목 )");
				Scanner scv = new Scanner(System.in);
				String command2 = scv.nextLine();
				System.out.printf("내용 )");
				String command3 = scv.nextLine();
				LocalDate now = LocalDate.now();

				Article article = new Article(i, now, command2, command3);
				articles.add(article);
				System.out.println(i + "번글이 생성되었습니다");
				i++;
			}

			else if (command.startsWith("article detail")) {
				String[] arr = command.split(" ");
				int n = Integer.parseInt(arr[2]);
				boolean a = false;

				if (articles.size() == 0) {
					System.out.println(n + "번 게시물은 존재하지 않습니다.");
				} else {
					for (int p = 1; p <= articles.size(); p++) {
						Article article = articles.get(p - 1);
						if (n == article.i) {
							a = true;
							break;
						} else {
							a = false;
						}
					}
				}
				if (a = true) {
					for (int p = 1; p <= articles.size(); p++) {
						Article article = articles.get(p - 1);
						if (n == article.i) {
							System.out.println("번호 : " + article.i);
							System.out.println("날짜 : " + article.now);
							System.out.println("제목 : " + article.command2);
							System.out.println("내용 : " + article.command3);
							break;
						}
					}

				} else {
					System.out.println(n + "번 게시물은 존재하지 않습니다.");
				}
			}

			else if (command.startsWith("article delete")) {
				String[] arr = command.split(" ");
				int n = Integer.parseInt(arr[2]);
				boolean b = false;
				if (articles.size() == 0) {
					System.out.println(n + "번 게시물은 존재하지 않습니다.");
				} else {
					for (int p = 1; p <= articles.size(); p++) {
						Article article3 = articles.get(p - 1);
						if (n == article3.i) {
							b = true;
							break;
						} else {
							b = false;

						}
					}
				}
				if (b = true) {
					for (int p = 1; p <= articles.size(); p++) {
						Article article3 = articles.get(p - 1);
						if (n == article3.i) {
							articles.remove(p - 1);
							System.out.println(n + "번 게시물이 삭제되었습니다.");
							break;
						}
					}
				} else {
					System.out.println(n + "번 게시물은 존재하지 않습니다.");

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
}

class Article {
	int i;
	LocalDate now;
	String command2;
	String command3;

	public Article(int i, LocalDate now, String command2, String command3) {
		this.i = i;
		this.now = now;
		this.command2 = command2;
		this.command3 = command3;

	}

}