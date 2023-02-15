package com.koreaIT.java.BAM;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		System.out.println("==프로그램 시작==");

		Scanner sc = new Scanner(System.in);

		int lastArticleId = 0;
		List<Article> articles = new ArrayList<>();

		while (true) {

			String cmd = sc.nextLine().trim();

			if (cmd.length() == 0) {
				System.out.println("명령어를 입력해주세요");
				continue;
			}

			System.out.println("입력된 명령어 : " + cmd);

			if (cmd.equals("exit")) {
				System.out.println("==프로그램 끝==");
				break;
			} else if (cmd.equals("article write")) {
				int id = lastArticleId + 1;
				lastArticleId = id;
				System.out.println("제목:");
				String tittle = sc.nextLine();
				System.out.println("내용:");
				String body = sc.nextLine();

				Article article = new Article(id, tittle, body);

				articles.add(article);

				System.out.println(id + "번글이 생성되었습니다.");

			} else if (cmd.equals("article list")) {
				if (articles.size() == 0) {
					System.out.println("게시글이 없습니다");
				}
					System.out.println("번호    | 제목");
					for (int i = articles.size() - 1; i <= 0; i--) {
						Article article = articles.get(i);
						System.out.println(article.id + "    | " + article.tittle);
					}
			} else if (cmd.startsWith("article detail ")) {
				String[] cmdbits = cmd.split(" ");
				int id = Integer.parseInt(cmdbits[2]);

				Article foundArticle = null;

				for (int i = 0; i < articles.size(); i++) {
					Article article = articles.get(i);

					if (article.id == id) {
						foundArticle = article;
						continue;
					}
				}

				if (foundArticle == null) {
					System.out.println(id + "번 게시글이 없습니다");
			}
				System.out.println("번호 : " + foundArticle.id);
				System.out.println("제목 : " + foundArticle.tittle);
				System.out.println("날짜 : " + foundArticle.id);
				System.out.println("내용 : " + foundArticle.body);
			}else if (cmd.startsWith("article delete")) {
				
			}else {
				System.out.println("존재하지 않는 명령어 입니다");
			}
			sc.close();
	}
	}
class Article{
	int id;
	String tittle;
	String body;
	
	Article(int id, String tittle, String body){
		this.id=id;
		this.tittle=tittle;
		this.body=body;
	}
}
