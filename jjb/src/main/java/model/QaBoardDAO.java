package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import common.ConnectionManager;

public class QaBoardDAO {

	Connection conn;
	PreparedStatement pstmt;

	//###인스턴스###
	static QaBoardDAO instance;
	public static QaBoardDAO getInstance() {
	
		if (instance == null) {
			instance = new QaBoardDAO();
		}
		return instance;

	}//###인스턴스###
	
	
	
		//###전체 조회###
		public ArrayList<QaBoardVO> selectAll(QaBoardVO qaboardVo){
			
			QaBoardVO resultVO = null;
			ResultSet rs = null;
			
			ArrayList<QaBoardVO> list = new ArrayList<QaBoardVO>();
			try {
				
				conn = ConnectionManager.getConnnect();
				String sql = "SELECT QABOARD_ID,QABOARD_CONTENTS,QABOARD_DATE,QABOARD_ANSWER,QABOARD_VIEWS,QABOARD_TYPE,MEMBER_ID FROM QABOARD";
			
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				
				resultVO = new QaBoardVO();
				resultVO.setQaboard_id(rs.getString(1));
				resultVO.setQaboard_contents(rs.getString(2));
				resultVO.setQaboard_date(rs.getString(3));
				resultVO.setQaboard_answer(rs.getString(4));
				resultVO.setQaboard_views(rs.getInt(5));
				resultVO.setQaboard_type(rs.getString(6));
				resultVO.setMember_id(rs.getString(6));
				list.add(resultVO);
				
			}
			}catch(Exception e){	
				e.printStackTrace();	
			}finally{	
				ConnectionManager.close(rs, pstmt, conn); 
			} 
			
			return list;
	 
		}//###전체 조회###
		
		
		//###단건 조회###
		public QaBoardVO selectOne(QaBoardVO qaboardVo) {
			
			QaBoardVO resultVO = null;
			ResultSet rs = null;
			
			try {
				
				conn = ConnectionManager.getConnnect();
				String sql = "SELECT QABOARD_ID,QABOARD_CONTENTS,QABOARD_DATE,QABOARD_ANSWER,QABOARD_VIEWS,QABOARD_TYPE,MEMBER_ID FROM QABOARD WHERE QABOARD_ID = ?";
				
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, qaboardVo.getQaboard_id());
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					
					resultVO = new QaBoardVO();
					resultVO.setQaboard_id(rs.getString("qaboard_id"));
					resultVO.setQaboard_contents(rs.getString("qaboard_contents"));
					resultVO.setQaboard_date(rs.getString("qaboard_date"));
					resultVO.setQaboard_answer(rs.getString("qaboard_answer"));
					resultVO.setQaboard_views(rs.getInt("qaboard_views"));
					resultVO.setQaboard_type(rs.getString("qaboard_type"));
					resultVO.setMember_id(rs.getString("member_id"));
					
				}	
			}catch(Exception e){
				e.printStackTrace();
			}finally {
				ConnectionManager.close(rs,pstmt,conn);
			}
			return resultVO;
		}//###단건 조회###
		
		
		//###입력###
		public QaBoardVO insert(QaBoardVO qaboardVo) {
			
			try {
				conn = ConnectionManager.getConnnect();
				
				String sql = "INSERT INTO BOARD (QABOARD_ID,QABOARD_CONTENTS,QABOARD_DATE,QABOARD_ANSWER,QABOARD_VIEWS,QABOARD_TYPE,MEMBER_ID)"
							 + " VALUES(?,?,?,?,?,?,?)";
				
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, qaboardVo.getQaboard_id());
				pstmt.setString(2, qaboardVo.getQaboard_contents());
				pstmt.setString(3, qaboardVo.getQaboard_date());
				pstmt.setString(4, qaboardVo.getQaboard_answer());
				pstmt.setInt(5, qaboardVo.getQaboard_views());
				pstmt.setString(6, qaboardVo.getQaboard_type());
				pstmt.setString(7, qaboardVo.getMember_id());
				pstmt.executeUpdate();
			
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				ConnectionManager.close(null,pstmt,conn);
			}
			return qaboardVo;
		}//###입력###
		
		
		//###삭제###
		public void delete(QaBoardVO qaboardVo) {
			
			try {
			
				conn = ConnectionManager.getConnnect();
				String sql = "DELETE QABOARD WHERE QABOARD_ID = ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, qaboardVo.getQaboard_id());
				pstmt.executeUpdate();
			
			
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				ConnectionManager.close(null,pstmt,conn);
			}
		}//###삭제###
		
		
		//###수정###
		public void update(QaBoardVO qaboardVo) {
			
			try {
				conn = ConnectionManager.getConnnect();
				String sql = "UPDATE QABOARD SET QABOARD_CONTENTS = ?,QABOARD_DATE = ?,QABOARD_ANSWER = ?,QABOARD_VIEWS = ?,QABOARD_TYPE = ?,MEMBER_ID = ?, WHERE QABOARD_ID=?";
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setString(1, qaboardVo.getQaboard_contents());
				pstmt.setString(2, qaboardVo.getQaboard_date());
				pstmt.setString(3, qaboardVo.getQaboard_answer());
				pstmt.setInt(4, qaboardVo.getQaboard_views());
				pstmt.setString(5, qaboardVo.getQaboard_type());
				pstmt.setString(6, qaboardVo.getMember_id());
				pstmt.setString(7, qaboardVo.getQaboard_id());
				pstmt.executeUpdate();
				
				
				
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				ConnectionManager.close(null, pstmt, conn);
			}
		}//###수정###
		
}

