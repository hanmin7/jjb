package model;

import lombok.Data;

@Data
public class QaBoardVO {

	private String qaboard_id;
	private String qaboard_contents;
	private String qaboard_date;
	private String qaboard_answer;
	private Integer qaboard_views;
	private String qaboard_type;
	private String member_id;
}
