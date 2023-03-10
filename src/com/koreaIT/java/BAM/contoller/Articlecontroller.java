package com.koreaIT.java.BAM.contoller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.koreaIT.java.BAM.dto.Article;
import com.koreaIT.java.BAM.util.util;

public class Articlecontroller extends Controller {
	private Scanner sc;
	private List<Article> articles;
	private int lastArticleId;
	private String cmd;

	public Articlecontroller(Scanner sc) {
		this.articles = new ArrayList<>();
		this.sc = sc;
		this.lastArticleId = 3;
	}
	
	public void doAction(String cmd, String methodName) {
		this.cmd = cmd;
		
		switch (methodName) {
		case "write":
			doWrite();
			break;

		case "list":
			showList();
			break;
			
		case "detail":
			showDetail();
			break;
			
		case "delete":
			doDelete();
			break;
			
		case "modify":
			doModify();
			break;
			
			
		default:
			System.out.println("존재하지않는 명령어 입니다.");
			break;
		}
	}


	private void doWrite() {
		int id = lastArticleId + 1;
		lastArticleId = id;
		String regDate = util.getDate();
		System.out.printf("제목 : ");
		String title = sc.nextLine();
		System.out.printf("내용 : ");
		String body = sc.nextLine();

		Article article = new Article(id, title, body, regDate);

		articles.add(article);

		System.out.printf("%d번 글이 생성되었습니다\n", id);
	}

	private void showList() {

		if (articles.size() == 0) {
			System.out.println("게시글이 없습니다");
			return;
		}

		String searchKeyword = cmd.substring("article list".length()).trim();

		List<Article> printArticles = articles;

		if (searchKeyword.length() > 0) {
			System.out.println("검색어 : " + searchKeyword);

			printArticles = new ArrayList<>();
			for (Article article : articles) {
				if (article.title.contains(searchKeyword)) {
					printArticles.add(article);
				}
			}
			if (printArticles.size() == 0) {
				System.out.println("검색결과가 없습니다");
				return;
			}
		}

		System.out.println("번호	|	제목	:	날짜		:	조회수");
		for (int i = printArticles.size() - 1; i >= 0; i--) {
			Article article = printArticles.get(i);
			System.out.printf("%d	|	%s	|%s		 %d\n", article.id, article.title, article.regDate,
					article.views);
		}
	}

	private void showDetail() {

		String[] cmdBits = cmd.split(" ");
		
		if(cmdBits.length == 2) {
			System.out.println("명령어를 확인해주세요.");
			return;
		}
		int id = Integer.parseInt(cmdBits[2]);

		Article foundArticle = getArticleId(id);

		if (foundArticle == null) {
			System.out.printf("%d번 게시물은 존재하지 않습니다\n", id);
			return;
		}

		foundArticle.addviews();

		System.out.printf("번호 : %d\n", foundArticle.id);
		System.out.printf("날짜 : %s\n", foundArticle.regDate);
		System.out.printf("제목 : %s\n", foundArticle.title);
		System.out.printf("내용 : %s\n", foundArticle.body);
		System.out.printf("조회수 : %d\n", foundArticle.views);

	}

	private void doDelete() {
		String[] cmdBits = cmd.split(" ");
		int id = Integer.parseInt(cmdBits[2]);
		if(cmdBits.length == 2) {
			System.out.println("명령어를 확인해주세요.");
			return;
		}

		int foundIndex = getarticleIndex(id);

		if (foundIndex == -1) {
			System.out.printf("%d번 게시물은 존재하지 않습니다\n", id);
			return;
		}
		articles.remove(foundIndex);
		lastArticleId = lastArticleId - 1;
		System.out.printf("%d번 게시글이 삭제되었습니다\n", id);

	}

	private void doModify() {
		String[] cmdBits = cmd.split(" ");
		int id = Integer.parseInt(cmdBits[2]);
		if(cmdBits.length == 2) {
			System.out.println("명령어를 확인해주세요.");
			return;
		}

		Article foundArticle = getArticleId(id);

		if (foundArticle == null) {
			System.out.printf("%d번 게시물은 존재하지 않습니다\n", id);
			return;
		}

		System.out.printf("수정할 제목 : ");
		String title = sc.nextLine();
		System.out.printf("수정할 내용 : ");
		String body = sc.nextLine();
		foundArticle.title = title;
		foundArticle.body = body;
		System.out.printf("%d번 게시글이 수정되었습니다\n", id);

	}

	private int getarticleIndex(int id) {
		for (int i = 0; i < articles.size(); i++) {
			Article article = articles.get(i);

			if (article.id == id) {
				return i;
			}
		}
		return -1;
	}

	private Article getArticleId(int id) {
		for (int i = 0; i < articles.size(); i++) {
			Article article = articles.get(i);

			if (article.id == id) {
				return article;
			}
		}
		return null;
	}
	
	public void makeTestData() {
		System.out.println("게시물 테스트 데이터를 생성합니다.");
		articles.add(new Article(1, "제목1", "내용1", util.getDate(), 10));
		articles.add(new Article(2, "제목2", "내용1", util.getDate(), 20));
		articles.add(new Article(3, "제목3", "내용1", util.getDate(), 30));
	}
}
