package model;

import lombok.Data;

@Data
public class CommentVO {

	private String comment_id;
	private String board_id;
	private String comment_date;
	private String comment_contents;
	private String poster;
	
}
