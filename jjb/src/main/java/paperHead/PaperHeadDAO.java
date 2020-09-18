package paperHead;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import paperHead.PaperHeadDAO;
import paperHead.PaperHeadVO;
import common.ConnectionManager;

public class PaperHeadDAO {
	Connection conn;
	PreparedStatement pstmt;
	
	static PaperHeadDAO instance;
	public static PaperHeadDAO getInstance() {
		if(instance==null)
			instance = new PaperHeadDAO();
			return instance;
	}
	public PaperHeadVO selectOne(PaperHeadVO paperHeadVO) {
		PaperHeadVO resultVO = null;
		ResultSet rs = null;
		try {
			conn = ConnectionManager.getConnnect(); // sql문 작성시 다음줄 넘어갔을때 공백 넣어야함 !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
			String sql = "SELECT PAPERHEAD_ID, PAPER_TYPE_CD, PAPER_ROUND" + " FROM PAPERHEAD"
					+ " WHERE PAPERHEAD_ID = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, paperHeadVO.getPaperhead_id());
			rs = pstmt.executeQuery();
			if (rs.next()) {
				resultVO = new PaperHeadVO();
				resultVO.setPaperhead_id(rs.getString(1));
				resultVO.setPaper_type_cd(rs.getString(2));
				resultVO.setPaper_round(rs.getString(3));
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
	
	public ArrayList<PaperHeadVO> selectAll(PaperHeadVO paperHeadVO) {
		ArrayList<PaperHeadVO> list = new ArrayList<>();
		PaperHeadVO resultVO = null;
		ResultSet rs = null;
		try {
			conn = ConnectionManager.getConnnect();
			String sql = "SELECT PAPERHEAD_ID, PAPER_TYPE_CD, PAPER_ROUND" + " FROM MEMBER ORDER BY PAPERHEAD_ID";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				resultVO = new PaperHeadVO();
				resultVO.setPaperhead_id(rs.getString(1));
				resultVO.setPaper_type_cd(rs.getString(2));
				resultVO.setPaper_round(rs.getString(3));
				list.add(resultVO);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.close(rs, pstmt, conn);
		}
		return list;
	}
	
	public void insert(PaperHeadVO paperHeadVO) {
		try {
			conn = ConnectionManager.getConnnect();
			String sql = "INSERT INTO paperhead (PAPERHEAD_ID, PAPER_TYPE_CD, PAPER_ROUND) "
					+ "VALUES (?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, paperHeadVO.getPaperhead_id());
			pstmt.setString(2, paperHeadVO.getPaper_type_cd());
			pstmt.setString(3, paperHeadVO.getPaper_round());
			
			int r = pstmt.executeUpdate();
			System.out.println(r + "건이 입력됨");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.close(conn);
		}
	}
	
	public void update(PaperHeadVO paperHeadVO) {
		try {
			conn = ConnectionManager.getConnnect();
			String sql = "UPDATE PAPERHEAD SET PAPER_TYPE_CD = ? WHERE PAPERHEAD_ID = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, paperHeadVO.getPaper_type_cd());
			pstmt.setString(2, paperHeadVO.getPaperhead_id());
			int r = pstmt.executeUpdate();
			System.out.println(r + "건 수정됨");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.close(null, pstmt, conn);
		}
	}
	
	public void delete(PaperHeadVO paperHeadVO) {
		try {
			conn = ConnectionManager.getConnnect();
			String sql = "DELETE PAPERHEAD WHERE PAPERHEAD_ID = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, paperHeadVO.getPaperhead_id());
			int r = pstmt.executeUpdate();
			System.out.println(r + "건 삭제됨");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.close(null, pstmt, conn);
		}
	}
}