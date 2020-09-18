package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import common.ConnectionManager;

public class MemberDAO {
	Connection conn;
	PreparedStatement pstmt;
	
	//싱글톤
	static MemberDAO instance;
	public static MemberDAO getInstance() {
		if(instance==null)
			instance=new MemberDAO();
			return instance;
	}
	//매번 서블릿에서 
	//2. 서비스 처리(DB)
			//MemberDAO dao = new MemberDAO();
	//이렇게 처리하는게 번거로우니까 static으로 만들어서 쓸 수 있음.
	//서블릿에서는  MemberDAO.getInstance().selectOne(memberVo); 이렇게 씀.
	
	
	//전체조회
	public ArrayList<MemberVo> selectAll(MemberVo MemberVo) {
		MemberVo resultVo = null;
		ResultSet rs = null;
		ArrayList<MemberVo> list = new ArrayList<MemberVo>();
		try {
			conn = ConnectionManager.getConnnect();
			String sql = "SELECT MEMBER_ID, MEMBER_PW, MEMBER_NAME, MEMBER_AGE, MEMBER_JOB, STUDY_TERM, PHONE_NUMBER, IS_MAJOR, TESTED_NUM, IS_PAY, PAY_ENDDATE"
						+ " FROM MEMBER "
						+ " ORDER BY MEMBER_ID";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) { //list니까 while문 사용
				resultVo = new MemberVo();
				resultVo.setMember_id((rs.getString("member_id")));
				resultVo.setMember_pw(rs.getString("member_pw"));
				resultVo.setMember_name(rs.getString("member_name"));
				resultVo.setMember_age(rs.getString("member_age"));
				resultVo.setMember_job(rs.getString("member_job"));
				resultVo.setStudy_term(rs.getString("study_term"));
				resultVo.setPhone_number(rs.getString("phone_number"));
				resultVo.setIs_major(rs.getString("is_major"));
				resultVo.setTested_num(rs.getString("tested_num"));
				resultVo.setIs_pay(rs.getString("is_pay"));
				resultVo.setPay_enddate(rs.getString("pay_enddate"));
				list.add(resultVo); //resultVo를 list에 담음
			} 
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.close(rs, pstmt, conn);
		}
		return list;  //담은 list를 리턴.
	} //selectAll
	
	
	//단건조회
	public MemberVo selectOne(MemberVo memberVo) {
		MemberVo resultVo = null;
		ResultSet rs = null;
		try {
			conn = ConnectionManager.getConnnect();
			String sql = "SELECT MEMBER_ID, MEMBER_PW, MEMBER_NAME, MEMBER_AGE, MEMBER_JOB, STUDY_TERM, PHONE_NUMBER, IS_MAJOR, TESTED_NUM, IS_PAY, PAY_ENDDATE"
						+ " FROM MEMBER "
						+ "WHERE MEMBER_ID=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberVo.getMember_id());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				resultVo = new MemberVo();
				resultVo.setMember_id((rs.getString("member_id")));
				resultVo.setMember_pw(rs.getString("member_pw"));
				resultVo.setMember_name(rs.getString("member_name"));
				resultVo.setMember_age(rs.getString("member_age"));
				resultVo.setMember_job(rs.getString("member_job"));
				resultVo.setStudy_term(rs.getString("study_term"));
				resultVo.setPhone_number(rs.getString("phone_number"));
				resultVo.setIs_major(rs.getString("is_major"));
				resultVo.setTested_num(rs.getString("tested_num"));
				resultVo.setIs_pay(rs.getString("is_pay"));
				resultVo.setPay_enddate(rs.getString("pay_enddate"));
			} else {
				System.out.println("no data");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.close(rs, pstmt, conn);
		}
		return resultVo; // 리턴값 필요!
	} //selectOne
	
	
	
	
	
	public int delete(MemberVo memberVo) {
		int r=0;
		try {
			conn = ConnectionManager.getConnnect();
			String sql = "DELETE MEMBER WHERE MEMBER_ID=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberVo.getMember_id());
			r = pstmt.executeUpdate();
			System.out.println(r + "건이 수정됨");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.close(null, pstmt, conn);
		}
		return r;
	} //삭제
	
	

	public int update(MemberVo memberVo) {
		int r=0;
		try {
			conn = ConnectionManager.getConnnect();
			String sql = "UPDATE MEMBER SET MEMBER_PW = ?, MEMBER_NAME = ?, MEMBER_AGE = ?, MEMBER_JOB = ?, "
					+ " STUDY_TERM = ?, PHONE_NUMBER = ?, IS_MAJOR = ?, TESTED_NUM = ?, IS_PAY = ?, PAY_ENDDATE = ? WHERE MEMBER_ID=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberVo.getMember_pw()); //? 첫번째 자리 값
			pstmt.setString(2, memberVo.getMember_name());
			pstmt.setString(3, memberVo.getMember_age());
			pstmt.setString(4, memberVo.getMember_job());
			pstmt.setString(5, memberVo.getStudy_term());
			pstmt.setString(6, memberVo.getPhone_number());
			pstmt.setString(7, memberVo.getIs_major());
			pstmt.setString(8, memberVo.getTested_num());
			pstmt.setString(9, memberVo.getIs_pay());
			pstmt.setString(10, memberVo.getPay_enddate());
			r = pstmt.executeUpdate(); // 이때는 executeUpdate()에 sql안들어감.
			System.out.println(r + "건이 수정됨");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.close(conn);
		}
		return r;
	} //업뎃

	
	public int insert(MemberVo memberVo) {
		int r =0;
		try {
			// 1. DB연결
			conn = ConnectionManager.getConnnect();
			
			// 2. sql 구문 실행
			String sql = "insert into member(member_id, member_pw, member_name, member_age, member_job, study_term, phone_number, is_major, tested_num, IS_PAY, PAY_ENDDATE)"
					 	+ "values (?,?,?,?,?,?,?,?,?,null,null)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberVo.getMember_id());		
			pstmt.setString(2, memberVo.getMember_pw());		
			pstmt.setString(3, memberVo.getMember_name());		
			pstmt.setString(4, memberVo.getMember_age());		
			pstmt.setString(5, memberVo.getMember_job());		
			pstmt.setString(6, memberVo.getStudy_term());		
			pstmt.setString(7, memberVo.getPhone_number());
			pstmt.setString(8, memberVo.getIs_major());
			pstmt.setString(9, memberVo.getTested_num());
					
			r = pstmt.executeUpdate();

			// 3. 결과 처리
			if (r == 1) {
				System.out.println(r + "건이 처리됨");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 4. 연결 해제 (연결횟수제한으로인해 해제까지 해줘야함)
			ConnectionManager.close(conn);
		}
		return r;
	} //인서트
	
	
	
	
}
