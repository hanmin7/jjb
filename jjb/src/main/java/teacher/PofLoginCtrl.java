package teacher;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.TeacherDAO;
import model.TeacherVO;

public class PofLoginCtrl implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TeacherVO teacherVO = new TeacherVO();
		teacherVO.setTeacher_id(request.getParameter("teacher_id"));
		teacherVO.setTeacher_password(request.getParameter("teacher_password"));
		
		TeacherVO resultVo = TeacherDAO.getInstance().selectOne(teacherVO);
		
		String page = "";
		if (resultVo == null) { // id가 없음
			/*
			request.setAttribute("errormsg", "해당 ID가 없습니다.");
			page = "/member/login.jsp";
			*/
			page = "/member/login.jsp";
			System.out.println(page);
			request.getRequestDispatcher(page).forward(request, response);
		} else { // 있으면 패스워드 일치 확인
			if (teacherVO.getTeacher_password().equals(resultVo.getTeacher_password())) { // 로그인성공
				request.getSession().setAttribute("login", resultVo);
				request.getSession().setAttribute("name", resultVo.getTeacher_name());
				response.sendRedirect("main.jsp");
			} else { // 패스워드 불일치
				request.setAttribute("errormsg", "아이디나 패스워드가 일치하지 않습니다.");
				request.setAttribute("errorcode", "3");
				page = "/member/login.jsp";
				request.getRequestDispatcher(page).forward(request, response);
			}
		}
		
		
	}

}
