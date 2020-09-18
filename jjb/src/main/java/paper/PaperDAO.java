package paper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import common.ConnectionManager;
import paper.PaperDAO;
import paper.PaperVO;
import problem.ProblemVO;

public class PaperDAO {
	Connection conn;
	PreparedStatement pstmt;
	
	static PaperDAO instance;
	public static PaperDAO getInstance() {
		if(instance==null)
			instance = new PaperDAO();
			return instance;
	}
	
	public PaperVO selectOne(PaperVO paperVO) {
		PaperVO resultVO = null;
		ResultSet rs = null;
		try {
			conn = ConnectionManager.getConnnect(); // sql문 작성시 다음줄 넘어갔을때 공백 넣어야함 !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
			String sql = "SELECT PAPER_ID, IS_CORRECT, CHECK_NUM, IS_PAVOITE, ANS_ORDER, SOLVE_ID, PROBLEM_ID"
					+ " FROM PAPER"
					+ " WHERE PROBLEM_ID = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, paperVO.getProblem_id());
			rs = pstmt.executeQuery();
			if (rs.next()) {
				resultVO = new PaperVO();
				resultVO.setPaper_id(rs.getString(1));
				resultVO.setIs_correct(rs.getString(2));
				resultVO.setCheck_num(rs.getString(3));
				resultVO.setIs_pavorite(rs.getString(4));
				resultVO.setAns_order(rs.getString(5));
				resultVO.setSolve_id(rs.getString(6));
				resultVO.setProblem_id(rs.getString(7));
				
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
	
	public ArrayList<PaperVO> selectAll(PaperVO paperVO) {
		ArrayList<PaperVO> list = new ArrayList<>();
		PaperVO resultVO = null;
		ResultSet rs = null;
		try {
			conn = ConnectionManager.getConnnect();
			String sql = "SELECT PAPER_ID, IS_CORRECT, CHECK_NUM, IS_PAVOITE, ANS_ORDER, SOLVE_ID, PROBLEM_ID"
						 +" FROM MEMBER ORDER BY PAPERHEAD_ID";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				resultVO = new PaperVO();
				resultVO.setPaper_id(rs.getString(1));
				resultVO.setIs_correct(rs.getString(2));
				resultVO.setCheck_num(rs.getString(3));
				resultVO.setIs_pavorite(rs.getString(4));
				resultVO.setAns_order(rs.getString(5));
				resultVO.setSolve_id(rs.getString(6));
				resultVO.setProblem_id(rs.getString(7));
				list.add(resultVO);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.close(rs, pstmt, conn);
		}
		return list;
	}
	
	public void insert(PaperVO paperVO) {
		try {
			conn = ConnectionManager.getConnnect();
			String sql = "INSERT INTO paper PAPER_ID, IS_CORRECT, CHECK_NUM, IS_PAVOITE, ANS_ORDER, SOLVE_ID, PROBLEM_ID"
						+ "VALUES (?,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, paperVO.getPaper_id());
			pstmt.setString(2, paperVO.getIs_correct());
			pstmt.setString(3, paperVO.getCheck_num());
			pstmt.setString(4, paperVO.getIs_pavorite());
			pstmt.setString(5, paperVO.getAns_order());
			pstmt.setString(6, paperVO.getSolve_id());
			pstmt.setString(7, paperVO.getProblem_id());
			
			int r = pstmt.executeUpdate();
			System.out.println(r + "건이 입력됨");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.close(conn);
		}
	}
	
	public void update(PaperVO paperVO) {
		try {
			conn = ConnectionManager.getConnnect();
			String sql = "UPDATE PAPERHEAD SET IS_PAVOITE = ? WHERE PAPER_ID = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, paperVO.getIs_pavorite());
			pstmt.setString(2, paperVO.getPaper_id());
			int r = pstmt.executeUpdate();
			System.out.println(r + "건 수정됨");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.close(null, pstmt, conn);
		}
	}
	
	public void delete(PaperVO paperVO) {
		try {
			conn = ConnectionManager.getConnnect();
			String sql = "DELETE PROBLEM WHERE PAPER_ID = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, paperVO.getPaper_id());
			int r = pstmt.executeUpdate();
			System.out.println(r + "건 삭제됨");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.close(null, pstmt, conn);
		}
	}
}
