package kr.ac.hansung.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString

public class FinishClass {
	
	private int id;
	
	private String year;

	private String semester;

	private String code;

	private String classname;

	private String classify;

	private String credit;

}
