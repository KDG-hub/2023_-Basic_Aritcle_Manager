package com.koreaIT.java.BAM;

import java.util.Scanner;

import com.koreaIT.java.BAM.contoller.Articlecontroller;
import com.koreaIT.java.BAM.contoller.Controller;
import com.koreaIT.java.BAM.contoller.Membercontroller;

public class App {

	public void run() {
		System.out.println("== 프로그램 시작 ==");

		Scanner sc = new Scanner(System.in);
		
		Membercontroller membercontroller = new Membercontroller(sc);
		Articlecontroller articlecontroller = new Articlecontroller(sc);
		
		articlecontroller.makeTestData();
		membercontroller.memkeTestData();

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
	
}