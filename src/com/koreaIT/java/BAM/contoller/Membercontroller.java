package com.koreaIT.java.BAM.contoller;

import java.util.List;
import java.util.Scanner;

import com.koreaIT.java.BAM.dto.Member;
import com.koreaIT.java.BAM.util.util;

public class Membercontroller extends Controller{
	
	private int lastmemberid;
	private List<Member> members;
	private Scanner sc;
	
	private Membercontroller(List<Member> members, Scanner sc) {
		this.members = members;
		this.sc = sc;
		lastmemberid = 0;
	}
	
	public void doAction(String cmd, String methodName) {
		
		switch(methodName) {
		case "join":
			dojoin();
			break;
		default:
			System.out.println("존재하지않는 명령어 입니다.");
			break;
		}
	}
	
	private void dojoin() {
		int id = lastmemberid + 1;
		lastmemberid = id;
		String regDate = util.getDate();
		String loginid = null;
		while(true) {
			System.out.printf("로그인 아이디 : ");
			loginid = sc.nextLine();
			if(lginidchk(loginid)== false) {
				System.out.println("중복된 아이디 입니다.");
				continue;
			}
			System.out.println("사용가능한 아이디입니다.");
			break;
		}
		System.out.printf("로그인 비밀번호 : ");
		String pw = sc.nextLine();
		System.out.printf("로그인 비밀번호 확인 : ");
		String pwchk = sc.nextLine();
		while (pw.equals(pwchk)== false) {
			System.out.println("비밀번호를 다시 입력해주세요.");
			System.out.printf("로그인 비밀번호 확인 : ");
			pwchk = sc.nextLine();
		}
		System.out.printf("이름 : ");
		String memberName = sc.nextLine();

		Member member = new Member(id, loginid, pw, memberName, regDate);

		members.add(member);

		System.out.printf("%s님 가입을 환영합니다.\n", memberName);
		
	}
	
	private boolean lginidchk(String loginid) {
		for (Member member : members) {
			if(member.loginid.equals(loginid)) {
				return false;
			}
	}
		return true;
}
}
