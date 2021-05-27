package com.icia.board.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data  //getter, setter , toString 생성자를 자동으로 만들어줌

@Getter
@Setter
@ToString

public class BoardDTO {

	private int bnumber;
	private String bwriter;
	private String bpassword;	
	private String btitle;
	private String bcontents;
	private String bdate;
	private int bhits;
	
//	public String getBtitle() {
//		return btitle;
//	}
//	public void setBtitle(String btitle) {
//		this.btitle = btitle;
//	}
//	public String getBpassword() {
//		return bpassword;
//	}
//	public void setBpassword(String bpassword) {
//		this.bpassword = bpassword;
//	}
//	public String getBwriter() {
//		return bwriter;
//	}
//	public void setBwriter(String bwriter) {
//		this.bwriter = bwriter;
//	}
//	public String getBcontents() {
//		return bcontents;
//	}
//	public void setBcontents(String bcontents) {
//		this.bcontents = bcontents;
//	}
//	
//	@Override
//	public String toString() {
//		return "BoardDTO [btitle=" + btitle + ", bpassword=" + bpassword + ", bwriter=" + bwriter + ", bcontents="
//				+ bcontents + "]";
//	}


	
}
