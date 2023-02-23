package com.koreaIT.java.BAM.contoller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.koreaIT.java.BAM.dto.Member;
import com.koreaIT.java.BAM.util.util;

public class Membercontroller extends Controller {

	private int lastmemberid;
	private List<Member> members;
	private Scanner sc;
	private String loginid;
	private Member loginedMember;

	public Membercontroller(Scanner sc) {
		this.sc = sc;
		this.members = new ArrayList<>();
		lastmemberid = 3;
		this.loginedMember= null;
	}

	public void doAction(String cmd, String methodName) {
		
		switch (methodName) {
		case "join":
			dojoin();
			break;

		case "login":
			dologin();
			break;
		
		case "logout":
			dologout();
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
		String loginId = null;
		while (true) {
			System.out.printf("로그인 아이디 : ");
			loginId = sc.nextLine();
			if (lginidchk(loginId) == false) {
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
		while (pw.equals(pwchk) == false) {
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

	private void dologin() {
		if(loginedMember != null) {
			System.out.println("이미 로그인한 상태입니다.");
			return;
		}
		System.out.printf("로그인 아이디 : ");
		String loginId = sc.nextLine();
		System.out.printf("로그인 비밀번호 : ");
		String loginPw = sc.nextLine();

		Member member = getloginId(loginId);
		if (member == null) {
			System.out.println("존재하지않는 아이디입니다.");
			return;
		}
		if (member.pw.equals(loginPw)==false) {
			System.out.println("비밀번호가 틀렸습니다.");
			return;
		}
		
		loginedMember = member;
		
		System.out.printf("%s회원님 환영합니다.\n", member.memberName);
	}
	
	private void dologout() {
		if(loginedMember == null) {
			System.out.println("로그인 상태가 아닙니다.");
			return;
		}
		loginedMember = null;
		System.out.println("로그아웃 되었습니다.");
	}
	

	private Member getloginId(String loginId) {
		for(Member member : members) {
			if(member.loginId.equals(loginId)) {
				return member;
			}
		}
		return null;
	}

	private boolean lginidchk(String loginId) {
		Member member = getloginId(loginId);
		if(member!=null) {
			return false;			
			}
		return true;
	}

	public void memkeTestData() {
		System.out.println("멤버 테스트 데이터를 생성합니다.");
		members.add(new Member(1, "test", "test", "test1" ,util.getDate()));
		members.add(new Member(2, "test1", "test1", "test2" ,util.getDate()));
		members.add(new Member(3, "test2", "test2", "test3" ,util.getDate()));
		
	}

}
