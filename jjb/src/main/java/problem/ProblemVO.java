package problem;

import lombok.Data;

@Data
public class ProblemVO {
	private String problem_id;
	private String subject;
	private String haeseol;
	private String problem_text;
	private String ans_1;
	private String ans_2;
	private String ans_3;
	private String ans_4;
	private Integer ans_correct;
	private String paperhead_id;
	private String problem_image;
}
