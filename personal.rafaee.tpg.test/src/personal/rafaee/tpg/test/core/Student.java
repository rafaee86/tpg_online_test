package personal.rafaee.tpg.test.core;

import java.io.Serializable;

/*
* @Author   Mohammad Rafaee Bin Suhaimi
* @Email rafaee86@gmail.com
* @Date 19/5/2017
*/
@SuppressWarnings("serial")
public class Student implements Serializable{
	
	private String id;
	private String name;
	private String grade;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	
	
}
