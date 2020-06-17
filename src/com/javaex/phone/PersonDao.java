package com.javaex.phone;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PersonDao {

//	DB와 연결할 Connection을 가져온다.
//	어떤 DB를 사용할 것이며, 어떤 드라이브와 로그인 정보를 사용할 것인가.
//	작업이 끝나면 사용한 리소스를 시스템에 돌려준다.
	// 0. import java.sql.*;
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	// 필드
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String id = "phonedb";
	private String pw = "phonedb";

	// 생성자
	public PersonDao() {
	}

	// g/s

	// 일반 메소드

	
	
	// connect
	private void getConnect() {
		try {
			// 1. JDBC 드라이버 (Oracle) 로딩
			Class.forName(driver);

			// 2. Connection 얻어오기
			conn = DriverManager.getConnection(url, id, pw);
			System.out.println("접속 성공");

		} catch (ClassNotFoundException e) {
			System.out.println("error: 드라이버 로딩 실패 - " + e);
		} catch (SQLException e) {
			System.out.println("error:" + e);
		}

	}
	
	public void close() {
		// 5. 자원정리
		try {
			if (pstmt != null) {
				pstmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			System.out.println("error:" + e);
		}

	}

	// person 등록 << 추가 >>
	public void personInsert(PersonVo personVo) {

		getConnect();

		try {

			// 3. SQL문 준비 / 바인딩 / 실행
			String query = "INSERT INTO person VALUES (seq_person_id.nextval, ?, ?, ? )"; // 쿼리문 문자열 만들기 ___어떤게 들어올지 모르니 ?
																						// 로 표시한다.
			pstmt = conn.prepareStatement(query); // 쿼리로 만들기

			pstmt.setString(1, personVo.getPersonName()); // ?(물음표)중 1번째, 순서 중요
			pstmt.setString(2, personVo.getPersonHp()); // ?(물음표)중 2번째, 순서 중요
			pstmt.setString(3, personVo.getPersonCompany()); // ?(물음표)중 3번째, 순서 중요
			
			int count = pstmt.executeUpdate();

			// 4.결과처리
			System.out.println(count + "건 처리되었습니다.");

		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {
			close();
		}

	}

	// person 수정
	public void personUpdate(PersonVo vo) {

		getConnect();

		try {

			// 3. SQL문 준비 / 바인딩 / 실행
			String query = ""; // 쿼리문 문자열만들기, ? 주의
			query += " update person ";
			query += " set name = ? ";
			query += " , hp = ? ";
			query += " , company = ? ";
			query += " where person_id = ? ";

			pstmt = conn.prepareStatement(query); // 쿼리로 만들기

			pstmt.setString(1, vo.getPersonName());
			pstmt.setString(2, vo.getPersonHp());
			pstmt.setString(3, vo.getPersonCompany());
			pstmt.setInt(4, vo.getPersonId());

			int count = pstmt.executeUpdate(); // 쿼리문 실행

			// 4.결과처리
			System.out.println(count + "건 처리되었습니다.");

		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {

			// 5. 자원정리
			close();
		}

	}

	// person 삭제
	public void personDelete(int personId) {

		getConnect();

		try {

			// 3. SQL문 준비 / 바인딩 / 실행
			String query = ""; // 쿼리문 문자열만들기, ? 주의
			query += " delete from person ";
			query += " where person_id = ? ";
			pstmt = conn.prepareStatement(query); // 쿼리로 만들기

			pstmt.setInt(1, personId);// ?(물음표) 중 1번째, 순서중요

			int count = pstmt.executeUpdate(); // 쿼리문 실행

			// 4.결과처리
			System.out.println(count + "건 처리되었습니다.");

		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {
			close();
		}

	}

	// 전화부 리스트
	public List<PersonVo> getPersonList() {
		List<PersonVo> list = new ArrayList<PersonVo>();

		getConnect();

		try {

			// 3. SQL문 준비 / 바인딩 / 실행 --> 완성된 sql문을 가져와서 작성할 것
			String query = "";
			query += " select  person_id, ";
			query += "         name, ";
			query += "         hp, ";
			query += "         company ";
			query += " from person";

			pstmt = conn.prepareStatement(query);

			rs = pstmt.executeQuery(); // select

			// 4.결과처리
			while (rs.next()) {
				int personId = rs.getInt("person_id");
				String personName = rs.getString("name");
				String personHp = rs.getString("hp");
				String personCompany = rs.getString("company");

				PersonVo personVo = new PersonVo(personId, personName, personHp, personCompany);

				list.add(personVo);
			}

		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {

			// 5. 자원정리
			close();
		}

		return list;

	}

}