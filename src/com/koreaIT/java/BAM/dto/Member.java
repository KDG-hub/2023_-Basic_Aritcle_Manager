package com.koreaIT.java.BAM.dto;

public class Member extends dto{
	public int id;
	public String loginid;
	public String pw;
	public String memberName;

	public Member(int id, String loginid, String pw, String memberName, String regDate) {
		this.loginid = loginid;
		this.id = id;
		this.pw = pw;
		this.memberName = memberName;
		this.regDate = regDate;;
	}

}
