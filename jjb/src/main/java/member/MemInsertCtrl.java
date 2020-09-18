package member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.MemberDAO;
import model.MemberVo;

public class MemInsertCtrl implements Controller {

	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("회원등록");
		
		String member_id = request.getParameter("member_id");
		String member_pw = request.getParameter("member_pw");
		String member_name = request.getParameter("member_name");
		String member_age1 = request.getParameter("member_age1");
		String member_age2 = request.getParameter("member_age2");
		String member_age3 = request.getParameter("member_age3");
		String member_job = request.getParameter("member_job");
		String study_term = request.getParameter("study_term");
		String phone_number = request.getParameter("phone_number");
		String is_major = request.getParameter("is_major");
		String tested_num = request.getParameter("tested_num");
		
		String member_age = (member_age1 + member_age2 + member_age3);
		
		
		MemberVo memberVo = new MemberVo();
		memberVo.setMember_id(member_id);
		memberVo.setMember_pw(member_pw);
		memberVo.setMember_name(member_name);
		memberVo.setMember_age(member_age);
		memberVo.setMember_job(member_job);
		memberVo.setStudy_term(study_term);
		memberVo.setPhone_number(phone_number);
		memberVo.setIs_major(is_major);
		memberVo.setTested_num(tested_num);
		
		int r = MemberDAO.getInstance().insert(memberVo);
		
		request.setAttribute("cnt", r);
		
		request.getRequestDispatcher("/member/login.jsp").forward(request, response);
		
	}

}
