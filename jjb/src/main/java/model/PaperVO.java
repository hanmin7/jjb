package model;

import lombok.Data;

@Data
public class PaperVO {
	private String paper_id;
	private String is_correct;
	private String check_num;
	private String is_favorite;
	private String ans_order;
}
