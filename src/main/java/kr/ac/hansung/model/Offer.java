package kr.ac.hansung.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString

public class Offer {
	private int id;
	private String semester;
	private String name;
	private String classify;
	private String code;
	private String credit;
	private String year;

}
