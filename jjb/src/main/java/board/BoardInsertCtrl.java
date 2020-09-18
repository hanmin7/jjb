package board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.BoardDAO;
import model.BoardVO;


public class BoardInsertCtrl implements Controller {

	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String title = request.getParameter("title");
		String contents = request.getParameter("contents");
		String member_id = request.getParameter("member_id");
	
		//String views = request.getParameter("views");
		
		  
		
		BoardVO board = new BoardVO();
	
		board.setTitle(title);
		board.setContents(contents);
		board.setMember_id(member_id);

	//	board.setViews(Integer.parseInt(views));
		
		
		
		BoardDAO dao = new BoardDAO();
		dao.insert(board);
		
		request.getRequestDispatcher("/board/board.jsp")
		.forward(request, response);
	
	}
}
