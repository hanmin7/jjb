package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import common.ConnectionManager;
import model.ProblemVO;
import model.ProblemDAO;

public class ProblemDAO {
	Connection conn;
	PreparedStatement pstmt;
	
	static ProblemDAO instance;
	public static ProblemDAO getInstance() {
		if(instance==null)
			instance = new ProblemDAO();
			return instance;
	}
	public ProblemVO selectOne(ProblemVO problemVO) {
		ProblemVO resultVO = null;
		ResultSet rs = null;
		try {
			conn = ConnectionManager.getConnnect(); // sql문 작성시 다음줄 넘어갔을때 공백 넣어야함 !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
			String sql = "SELECT PROBLEM_ID, SUBJECT, HAESEOL, PROBLEM_TEXT, ANS_1, ANS_2, ANS_3,"
					+ "ANS_4, ANS_CORRECT, PAPERHEAD_ID, PROBLEM_IMAGE" + " FROM PROBLEM"
					+ " WHERE PROBLEM_ID = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, problemVO.getProblem_id());
			rs = pstmt.executeQuery();
			if (rs.next()) {
				resultVO = new ProblemVO();
				resultVO.setProblem_id(rs.getString(1));
				resultVO.setSubject(rs.getString(2));
				resultVO.setHaeseol(rs.getString(3));
				resultVO.setProblem_text(rs.getString(4));
				resultVO.setAns_1(rs.getString(5));
				resultVO.setAns_2(rs.getString(6));
				resultVO.setAns_3(rs.getString(7));
				resultVO.setAns_4(rs.getString(8));
				resultVO.setAns_correct(rs.getString(9));
				resultVO.setProblem_id(rs.getString(10));
				resultVO.setProblem_image(rs.getString(11));
			} else {
				System.out.println("No data");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.close(rs, pstmt, conn);
		}
		return resultVO;
	}
	
	public ArrayList<ProblemVO> selectAll(ProblemVO problemVO) {
		ArrayList<ProblemVO> list = new ArrayList<>();
		ProblemVO resultVO = null;
		ResultSet rs = null;
		try {
			conn = ConnectionManager.getConnnect();
			String sql = "SELECT PROBLEM_ID, SUBJECT, HAESEOL, PROBLEM_TEXT, ANS_1, ANS_2, ANS_3,"
						+ " ANS_4, ANS_CORRECT, PAPERHEAD_ID, PROBLEM_IMAGE"
						+ " FROM MEMBER ORDER BY PAPERHEAD_ID";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				resultVO = new ProblemVO();
				resultVO.setProblem_id(rs.getString(1));
				resultVO.setSubject(rs.getString(2));
				resultVO.setHaeseol(rs.getString(3));
				resultVO.setProblem_text(rs.getString(4));
				resultVO.setAns_1(rs.getString(5));
				resultVO.setAns_2(rs.getString(6));
				resultVO.setAns_3(rs.getString(7));
				resultVO.setAns_4(rs.getString(8));
				resultVO.setAns_correct(rs.getString(9));
				resultVO.setProblem_id(rs.getString(10));
				resultVO.setProblem_image(rs.getString(11));
				list.add(resultVO);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.close(rs, pstmt, conn);
		}
		return list;
	}
	
	public void insert(model.ProblemVO problem) {
		try {
			conn = ConnectionManager.getConnnect();
			String sql = "INSERT INTO PROBLEM (PROBLEM_ID, SUBJECT, HAESEOL, PROBLEM_TEXT, ANS_1, ANS_2, "
					+ "ANS_3, ANS_4, ANS_CORRECT, PAPERHEAD_ID, PROBLEM_IMAGE) "
					+ "VALUES (?,?,?,?,?,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, problem.getProblem_id());
			pstmt.setString(2, problem.getSubject());
			pstmt.setString(3, problem.getHaeseol());
			pstmt.setString(4, problem.getProblem_text());
			pstmt.setString(5, problem.getAns_1());
			pstmt.setString(6, problem.getAns_2());
			pstmt.setString(7, problem.getAns_3());
			pstmt.setString(8, problem.getAns_4());
			pstmt.setString(9, problem.getAns_correct());
			pstmt.setString(10, problem.getPaperhead_id());
			pstmt.setString(11, problem.getProblem_image());
		
			int r = pstmt.executeUpdate();
			System.out.println(r + "건이 입력됨");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.close(conn);
		}
	}
	
	public void update(ProblemVO problemVO) {
		try {
			conn = ConnectionManager.getConnnect();
			String sql = "UPDATE PAPERHEAD SET SUBJECT = ? WHERE PROBLEM_ID = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, problemVO.getSubject());
			pstmt.setString(2, problemVO.getProblem_id());
			int r = pstmt.executeUpdate();
			System.out.println(r + "건 수정됨");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.close(null, pstmt, conn);
		}
	}
	
	public void delete(ProblemVO problemVO) {
		try {
			conn = ConnectionManager.getConnnect();
			String sql = "DELETE PROBLEM WHERE PROBLEM_ID = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, problemVO.getProblem_id());
			int r = pstmt.executeUpdate();
			System.out.println(r + "건 삭제됨");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.close(null, pstmt, conn);
		}
	}
}
