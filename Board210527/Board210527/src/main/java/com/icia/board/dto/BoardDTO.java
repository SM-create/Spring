package com.icia.board.dto;

import org.springframework.web.multipart.MultipartFile;

public class BoardDTO {

	private int bnumber;
	private String bwriter;
	private String bpassword;	
	private String btitle;
	private String bcontents;
	private String bdate;
	private int bhits;
	
	public int getBnumber() {
		return bnumber;
	}
	public void setBnumber(int bnumber) {
		this.bnumber = bnumber;
	}
	public String getBwriter() {
		return bwriter;
	}
	public void setBwriter(String bwriter) {
		this.bwriter = bwriter;
	}
	public String getBpassword() {
		return bpassword;
	}
	public void setBpassword(String bpassword) {
		this.bpassword = bpassword;
	}
	public String getBtitle() {
		return btitle;
	}
	public void setBtitle(String btitle) {
		this.btitle = btitle;
	}
	public String getBcontents() {
		return bcontents;
	}
	public void setBcontents(String bcontents) {
		this.bcontents = bcontents;
	}
	public String getBdate() {
		return bdate;
	}
	public void setBdate(String bdate) {
		this.bdate = bdate;
	}
	public int getBhits() {
		return bhits;
	}
	public void setBhits(int bhits) {
		this.bhits = bhits;
	}
	
	
	@Override
	public String toString() {
		return "BoardDTO [bnumber=" + bnumber + ", bwriter=" + bwriter + ", bpassword=" + bpassword + ", btitle="
				+ btitle + ", bcontents=" + bcontents + ", bdate=" + bdate + ", bhits=" + bhits + "]";
	}
	
	//파일을 담기 위한 필드 boardwrite.jsp에서 controller
	private MultipartFile Bfile;
	//파일명을 담기위한 필드
	private String bfilename;

	public MultipartFile getBfile() {
		// TODO Auto-generated method stub
		return null;
	}

	
	

	
	
	
	
	
	
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
