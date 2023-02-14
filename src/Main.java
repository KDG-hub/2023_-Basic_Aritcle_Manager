import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		System.out.println("==프로그램 시작==");

		Scanner sc = new Scanner(System.in);

		int lastArticleId =0;

		while (true) {
			
			String cmd = sc.nextLine();
			
			if(cmd.length()==0) {
				System.out.println("명령어를 입력해주세요");
				continue;
			}

			System.out.println("입력된 명령어 : " + cmd);
			
			if (cmd.equals("exit")) {
				System.out.println("==프로그램 끝==");
				break;
			}else if(cmd.equals("article write")) {
				int id = lastArticleId +1;
				lastArticleId = id;
				System.out.println("제목:");
				String tittle = sc.nextLine();
				System.out.println("내용:");
				String body = sc.nextLine();
				System.out.println(id+"번글이 생성되었습니다.");
				
				
				System.out.println();
				
			}
			else if(cmd.equals("article list")) {
				System.out.println("게시글이 없습니다");
			}else {
				System.out.println("존재하지 않는 명령어 입니다");
			}
			
		}

		sc.close();
	}
}
