package model;

import lombok.Data;

@Data
public class SolveVO {
	private String solve_id;
	private String solve_score;
	private String solve_date;
	private String solve_time;
	private String solve_type_cd;
	private String solve_cnt;
}
