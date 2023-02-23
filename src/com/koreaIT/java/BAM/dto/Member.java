package com.koreaIT.java.BAM.dto;

public class Member extends dto{
	public int id;
	public String loginId;
	public String pw;
	public String memberName;

	public Member(int id, String loginId, String pw, String memberName, String regDate) {
		this.loginId = loginId;
		this.id = id;
		this.pw = pw;
		this.memberName = memberName;
		this.regDate = regDate;;
	}

}
