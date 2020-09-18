package common;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import problem.ProblemDAO;
import problem.ProblemVO;

public class ProblemInsertController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String problem_id = request.getParameter("problem_id");

		ProblemVO problem = new ProblemVO();
		problem.setProblem_id(problem_id);

		ProblemDAO.getInstance().delete(problem);
		
		request.getRequestDispatcher("/admin/problemInsertOutput.jsp").forward(request, response);	
	}

}
