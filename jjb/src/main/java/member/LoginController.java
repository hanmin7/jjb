package member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import controller.Controller;
import model.MemberDAO;
import model.MemberVo;

public class LoginController implements Controller {

	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 파라미터 VO
		MemberVo memberVo = new MemberVo();
		memberVo.setMember_id(request.getParameter("member_id"));
		memberVo.setMember_pw(request.getParameter("member_pw"));

		// 2. 서비스 처리(DB)
		MemberVo resultVo = MemberDAO.getInstance().selectOne(memberVo);

		// 3. 결과 저장
		String page = "";
		if (resultVo == null) { // id가 없음
			/*
			 * request.setAttribute("errormsg", "해당 ID가 없습니다.");
			 * request.setAttribute("errorcode", "3");
			 */
			page = "/member/login.jsp";
			System.out.println(page);
			request.getRequestDispatcher(page).forward(request, response);
		} else { // 있으면 패스워드 일치 확인
			if (memberVo.getMember_pw().equals(resultVo.getMember_pw())) { // 로그인성공
				request.getSession().setAttribute("login", resultVo);
				request.getSession().setAttribute("name", resultVo.getMember_name());
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
