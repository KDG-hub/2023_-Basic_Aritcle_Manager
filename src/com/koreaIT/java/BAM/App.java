package com.koreaIT.java.BAM;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.koreaIT.java.BAM.contoller.Articlecontroller;
import com.koreaIT.java.BAM.contoller.Controller;
import com.koreaIT.java.BAM.contoller.Membercontroller;
import com.koreaIT.java.BAM.dto.Article;
import com.koreaIT.java.BAM.dto.Member;
import com.koreaIT.java.BAM.util.util;

public class App {
	List<Member> members = new ArrayList<>();
	List<Article>articles = new ArrayList<>();

	 
	public void run() {
		System.out.println("== 프로그램 시작 ==");

		Scanner sc = new Scanner(System.in);

		int lastArticleId = 3;
		
		makeTestData();
		
		Membercontroller membercontroller = new Membercontroller(members , sc);
		Articlecontroller articlecontroller = new Articlecontroller(articles, sc);

		while (true) {
			System.out.printf("명령어) ");
			
			String cmd = sc.nextLine().trim();
			
			if (cmd.length() == 0) {
				System.out.println("명령어를 입력해주세요");
				continue;
			}

			if (cmd.equals("exit")) {
				break;
			}
			
			String [] cmdBits = cmd.split(" ");
			
			if(cmdBits.length == 1) {
				System.out.println("명령어를 확인해주세요.");
				continue;
			}
			
			String controllerName = cmdBits[0];
			
			String methodName = cmdBits[1];
			
			Controller controller = null;
			
			if(controllerName.equals("member")) {
				controller = membercontroller;
			}				
			else if(controllerName.equals("article")) {
				controller = articlecontroller;
			}
			else {
				System.out.println("존재하지 않는 명령어 입니다");
				continue;
			}
			controller.doAction(cmd, methodName);
		}
		System.out.println("== 프로그램 끝 ==");
		sc.close();

	}
	private void makeTestData() {
		System.out.println("게시물 테스트 데이터를 생성합니다.");
		articles.add(new Article(1, "제목1", "내용1", util.getDate(), 10));
		articles.add(new Article(2, "제목2", "내용1", util.getDate(), 20));
		articles.add(new Article(3, "제목3", "내용1", util.getDate(), 30));
	}
}