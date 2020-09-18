package teacher;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;

import controller.Controller;
import model.TeacherDAO;
import model.TeacherVO;

public class ProfInsertCtrl implements Controller {

	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("교사회원등록");
		
		TeacherVO teacher = new TeacherVO();
		
		try {
			BeanUtils.copyProperties(teacher, request.getParameterMap());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		int r = TeacherDAO.getInstance().insert(teacher);
		
		
		
		String page = "";
		if (r == 1) { //1건 수정됨
			request.setAttribute("errormsg", "가입을 축하합니다");
			request.setAttribute("errorcode", "1");
			page = "/member/login.jsp";
			request.getRequestDispatcher(page).forward(request, response);
		} else {
			request.setAttribute("errormsg", "가입에 실패했습니다.");
			request.setAttribute("errorcode", "2");
			page = "/member/profInsert.jsp";
			request.getRequestDispatcher(page).forward(request, response);
			
		};
		

		//request.getRequestDispatcher("/member/login.jsp").forward(request, response);
		
	}

}
