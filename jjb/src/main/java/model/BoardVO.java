package model;

import lombok.Data;

@Data
public class BoardVO {
	private Integer board_id;
	private String title;
	private String contents;
	private String member_id;
	private String board_date;
	private Integer views;
}
