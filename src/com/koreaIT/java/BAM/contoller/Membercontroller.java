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
	private String cmd;
	private String loginid;

	public Membercontroller(Scanner sc) {
		this.sc = sc;
		this.members = new ArrayList<>();
		lastmemberid = 0;
	}

	public void doAction(String cmd, String methodName) {
		this.cmd = cmd;

		switch (methodName) {
		case "join":
			dojoin();
			break;

		case "login":
			dologin();
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
			if (lginidchk(loginid) == false) {
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
		System.out.printf("로그인 아이디 : ");
		String loginId = sc.nextLine();
		System.out.printf("로그인 비밀번호 : ");
		String loginPw = sc.nextLine();

		Member member = getloginId(loginId);
		if (member == null) {
			System.out.println("존재하지않는 아이디입니다.");
			return;
		}
		if (member.pw.equals(loginPw)) {
			System.out.println("비밀번호가 틀렸습니다.");
			return;
		}
		System.out.printf("%s회원님 환영합니다.\n", member.memberName);
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

}
