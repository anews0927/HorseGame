package com.horse;

import java.io.Serializable;

public class GambleVO implements Serializable {

	private String name;
	private String id;
	private String pw1;
	private String pw2;
	private String gender;
	private String jumin;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw1() {
		return pw1;
	}
	public void setPw1(String pw1) {
		this.pw1 = pw1;
	}
	public String getPw2() {
		return pw2;
	}
	public void setPw2(String pw2) {
		this.pw2 = pw2;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getJumin() {
		return jumin;
	}
	public void setJumin(String jumin) {
		this.jumin = jumin;
	}
	
	@Override
		
		public String toString(){
		
			String str =null;
			
			str = String.format("아이디 : %s, 비밀번호 : %s\n이름 : %s,성별 : %s 주민번호 : %s\n"
				,getId(),getPw1(),getName(),getGender(),getJumin());
	
			return str;
	}
	
}