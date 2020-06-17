package com.javaex.phone;

import java.util.List;
import java.util.Scanner;

public class PersonVo {

	// VO 는 로직이 없는 순수한 데이터 객체
	// 속성과 속성에 접근하기 위한 GETTER, SETTER, 메소드만 가지고있음

	
	// 필드
	private int personId;
	private String personName;
	private String personHp;
	private String personCompany;

	// 생성자
	public PersonVo() {}
	// APP 등록 형식 String형 3개
	public PersonVo(String personName, String personHp, String personCompany) {
		this.personName = personName;
		this.personHp = personHp;
		this.personCompany = personCompany;
	}

	// APP 등록 형식 String형 4개
	public PersonVo(int personId, String personName, String personHp, String personCompany) {
		this.personId = personId;
		this.personName = personName;
		this.personHp = personHp;
		this.personCompany = personCompany;
	}

	// g/s

	public int getPersonId() {
		return personId;
	}

	public void setPersonId(int personId) {
		this.personId = personId;
	}

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

	public String getPersonHp() {
		return personHp;
	}

	public void setPersonHp(String personHp) {
		this.personHp = personHp;
	}

	public String getPersonCompany() {
		return personCompany;
	}

	public void setPersonCompany(String personCompany) {
		this.personCompany = personCompany;
	}

	// 메소드
	public String writeDB() {
		return personName + ","+ personHp + "," + personCompany;
	}
	
	public void showInfo () {
		System.out.println(personName + ","+ personHp + "," + personCompany);
	}

	@Override
	public String toString() {
		return "PersonVo [personId=" + personId + ", personName=" + personName + ", personHp=" + personHp
				+ ", personCompany=" + personCompany + "]";
	}

}
