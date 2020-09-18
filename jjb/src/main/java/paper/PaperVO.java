package paper;

import lombok.Data;

@Data
public class PaperVO {
	private String paper_id;
	private String is_correct;
	private String check_num;
	private String is_pavorite;
	private String ans_order;
	private String solve_id;
	private String problem_id;
}
