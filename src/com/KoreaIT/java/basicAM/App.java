package com.KoreaIT.java.basicAM;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.KoreaIT.java.basicAM.controller.Articlecontroller;
import com.KoreaIT.java.basicAM.controller.Controller;
import com.KoreaIT.java.basicAM.controller.Membercontroller;
import com.KoreaIT.java.basicAM.dto.Article;
import com.KoreaIT.java.basicAM.dto.Member;

public class App extends Controller{
	static List<Article> articles = new ArrayList<>();
	static List<Member> members = new ArrayList<>();

	public void run() {
		System.out.println("========프로그램 시작========");
		Scanner sc = new Scanner(System.in);
		Membercontroller membercontroller = new Membercontroller(members, sc);
		Articlecontroller articlecontroller = new Articlecontroller(sc);

		Articlecontroller.maketestdata();
		Membercontroller.makeadminaccount();
		Membercontroller.maketestdata();
		

		while (true) {
			if(loginedmember !=null) {
				if(loginedmember.name.equals("관리자")) {
					System.out.println("1.로그아웃   2.회원목록   3.회원정보   4.회원추방   5.글쓰기   6.글목록   7.글 정보   8.글 수정   9.글 삭제   10.글 검색   11.프로그램 종료");
					System.out.println("관리자모드입니다.");
					System.out.printf("명령어 )");
					String command = sc.nextLine().trim();

					if (command.length() == 0) {
						System.out.println("명령어를 입력해주세요");
						continue;
					}
					
					if(command.equals("1")) {
						command = "member logout";
					}else if(command.equals("2")) {
						command = "member list";
					}else if(command.equals("3")) {
						System.out.printf("몇번 회원의 정보를 보시겠습니까? )");
						String command1 = sc.nextLine().trim();
						command = "member detail "+command1;
					}else if(command.equals("4")) {
						System.out.printf("몇번 회원을 삭제하시겠습니까? )");
						String command1 = sc.nextLine().trim();
						System.out.println(command1+"번 회원을 삭제하겠습니다.");
						command = "member delete "+command1;
					}else if(command.equals("5")) {
						command = "article write";
					}else if(command.equals("6")) {
						command = "article list";
					}else if(command.equals("7")) {
						System.out.printf("몇번 글을 보시겠습니까? )");
						String command1 = sc.nextLine().trim();
						command = "article detail "+command1;
					}else if(command.equals("8")) {
						System.out.printf("몇번 글을 수정하시겠습니까? )");
						String command1 = sc.nextLine().trim();
						command = "article modify "+command1;
					}else if(command.equals("9")) {
						System.out.printf("몇번 글을 삭제하시겠습니까? )");
						String command1 = sc.nextLine().trim();
						command = "member delete "+command1;
					}else if(command.equals("10")) {
						System.out.println("1.제목   2.내용   3.작성자");
						String command1 = null;
						while(true) {
							System.out.printf("검색할 주제를 정해주세요 )");
							command1 = sc.nextLine().trim();
							if(command1.equals("1")) {
								command1 = "title";
							}else if(command1.equals("2")) {
								command1 = "content";
							}else if(command1.equals("3")) {
								command1 = "writer";
							}else {
								System.out.println("잘못된 접근입니다.");
								continue;
							}
							break;
						}
						System.out.printf("검색어를 입력해주세요 )");
						String command2 = sc.nextLine().trim();
						command = "article search "+command1+" "+command2;
					}else if(command.equals("11")) {
						command = "system exit";
					}else {
						System.out.printf("잘못 된 접근입니다.");
						continue;
					}
					
					String[] commandBits = command.split(" "); // article detail 1 / member join
					
					if (commandBits.length == 1) {
						System.out.println("명령어 확인 후 다시 입력해주세요");
						continue;
					}

					String controllerName = commandBits[0];
					String actionMethodName = commandBits[1];

					Controller controller = null;
					
					if (controllerName.equals("article")) {
						controller = articlecontroller;
					} else if (controllerName.equals("member")) {
						controller = membercontroller;
					} else {
						if (controllerName.equals("system")) {
							if (actionMethodName.equals("exit")) {
								break;
							}

						}

					}
					controller.doAction(command, actionMethodName);
					
				}else {
					System.out.println("1.로그아웃   2.회원정보   3.회원정보수정   4.회원탈퇴   5.글 쓰기   6.글 목록   7.글 정보   8.글 수정   9.글 삭제   10.글 검색   11.프로그램 종료");
					System.out.printf("명령어 )");
					String command = sc.nextLine().trim();

					if (command.length() == 0) {
						System.out.println("명령어를 입력해주세요");
						continue;
					}
					
					if(command.equals("1")) {
						command = "member logout";
					}else if(command.equals("2")) {
						command = "member mypage";
					}else if(command.equals("3")) {
						command = "member modify";
					}else if(command.equals("4")) {
						command = "member withdraw";
					}else if(command.equals("5")) {
						command = "article write";
					}else if(command.equals("6")) {
						command = "article list";
					}else if(command.equals("7")) {
						System.out.printf("몇번 글을 보시겠습니까? )");
						String command1 = sc.nextLine().trim();
						command = "article detail "+command1;
					}else if(command.equals("8")) {
						System.out.printf("몇번 글을 수정하시겠습니까? )");
						String command1 = sc.nextLine().trim();
						command = "article modify "+command1;
					}else if(command.equals("9")) {
						System.out.printf("몇번 글을 삭제하시겠습니까? )");
						String command1 = sc.nextLine().trim();
						command = "member delete "+command1;
					}else if(command.equals("10")) {
						System.out.println("1.제목   2.내용   3.작성자");
						String command1 = null;
						while(true) {
							System.out.printf("검색할 주제를 정해주세요 )");
							command1 = sc.nextLine().trim();
							if(command1.equals("1")) {
								command1 = "title";
							}else if(command1.equals("2")) {
								command1 = "content";
							}else if(command1.equals("3")) {
								command1 = "writer";
							}else {
								System.out.println("잘못된 접근입니다.");
								continue;
							}
							break;
						}
						System.out.printf("검색어를 입력해주세요 )");
						String command2 = sc.nextLine().trim();
						command = "article search "+command1+" "+command2;
					}else if(command.equals("11")) {
						command = "system exit";
					}else {
						System.out.printf("잘못 된 접근입니다.");
						continue;
					}
					String[] commandBits = command.split(" "); // article detail 1 / member join
					
					if (commandBits.length == 1) {
						System.out.println("명령어 확인 후 다시 입력해주세요");
						continue;
					}

					String controllerName = commandBits[0];
					String actionMethodName = commandBits[1];

					Controller controller = null;
					
					if (controllerName.equals("article")) {
						controller = articlecontroller;
					} else if (controllerName.equals("member")) {
						controller = membercontroller;
					} else {
						if (controllerName.equals("system")) {
							if (actionMethodName.equals("exit")) {
								break;
							}else {
								System.out.println("존재하지 않는 명령어 입니다.");
								continue;
							}

						} else {
							System.out.println("존재하지 않는 명령어 입니다.");
							continue;
						}

					}
					controller.doAction(command, actionMethodName);
				}
				
				


				

				


			}else {
				System.out.println("1.회원가입   2.로그인   3. 글목록   4. 글 정보   5.글 검색   6.프로그램 종료");
				System.out.printf("명령어 )");
				String command = sc.nextLine().trim();

				if (command.length() == 0) {
					System.out.println("명령어를 입력해주세요");
					continue;
				}
				
				if(command.equals("1")) {
					command = "member join";
				}else if(command.equals("2")) {
					command = "member login";
				}else if(command.equals("3")) {
					command = "article list";
				}else if(command.equals("4")) {
					System.out.printf("몇번 글을 보시겠습니까? )");
					String command1 = sc.nextLine().trim();
					command = "article detail "+command1;
				}else if(command.equals("5")) {
					System.out.println("1.제목   2.내용   3.작성자");
					String command1 = null;
					while(true) {
						System.out.printf("검색할 주제를 정해주세요 )");
						command1 = sc.nextLine().trim();
						if(command1.equals("1")) {
							command1 = "title";
						}else if(command1.equals("2")) {
							command1 = "content";
						}else if(command1.equals("3")) {
							command1 = "writer";
						}else {
							System.out.println("잘못된 접근입니다.");
							continue;
						}
						break;
					}
					System.out.printf("검색어를 입력해주세요 )");
					String command2 = sc.nextLine().trim();
					command = "article search "+command1+" "+command2;
				}else if(command.equals("6")) {
					command = "system exit";
				}else {
					System.out.println("명령어를 다시 입력해주세요");
					continue;
				}

				String[] commandBits = command.split(" "); // article detail 1 / member join

				

				String controllerName = commandBits[0];
				String actionMethodName = commandBits[1];

				Controller controller = null;

				if (controllerName.equals("article")) {
					controller = articlecontroller;
				} else if (controllerName.equals("member")) {
					controller = membercontroller;
				} else {
					if (controllerName.equals("system")) {
						if (actionMethodName.equals("exit")) {
							break;
						}

					}

				}
				controller.doAction(command, actionMethodName);
			}


		}

		System.out.println("========프로그램 종료========");
		sc.close();
	}

	public void doAction(String command, String actionMethodName) {
		// TODO Auto-generated method stub
		
	}

}
