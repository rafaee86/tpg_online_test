package personal.rafaee.tpg.test.core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* 
 * Question ‐ 2
 * You are given a list of student information: ID, FirstName, and GPA. Your task is to
 * rearrange them according to their GPA in descending order. If two students have the
 * same GPA, then arrange them according to their first name in alphabetical order. If those
 * two students also have the same first name, then sort them in ascending order according
 * to their IDs. No two students have the same ID.
 * Hint: You can use comparators to sort a list of objects.
 * 
 * @Author   Mohammad Rafaee Bin Suhaimi
 * @Email rafaee86@gmail.com
 * @Date 19/5/2017
 */
public class StudentNameComparator {

	private List<Student> studentList;
	
	public void addStudentList(Student student){
		if(student != null){
			if(this.studentList == null)this.studentList = new ArrayList<Student>();
			this.studentList.add(student);
		}
	}
	
	public List<Student> getStudentList() {
		return studentList;
	}
	
	public void setStudentList(List<Student> studentList) {
		this.studentList = studentList;
	}
	
	public List<Student> sort(){
		
		List<Student> sourceList = new ArrayList<Student>();
				
		if(this.studentList != null && this.studentList.size() > 0){

			sourceList.addAll(this.studentList);
			
			Collections.sort(sourceList, new Comparator<Student>() {
				@Override
				public int compare(Student lhs, Student rhs) {
					int status = -1;
					if (lhs != null && rhs != null) {
						status = lhs.getId().compareToIgnoreCase(rhs.getId());
					}				
					return status;
				}
			});
			
			Collections.sort(sourceList, new Comparator<Student>() {
				@Override
				public int compare(Student lhs, Student rhs) {
					int status = -1;
					if (lhs != null && rhs != null) {
						status = lhs.getName().compareToIgnoreCase(rhs.getName());
					}				
					return status;
				}
			});
			
			Collections.sort(sourceList, new Comparator<Student>() {
				@Override
				public int compare(Student lhs, Student rhs) {
					int status = -1;
					if (lhs != null && rhs != null) {
						status = rhs.getGrade().compareToIgnoreCase(lhs.getGrade());
					}				
					return status;
				}
			});
		}
		
		return sourceList;
	}
}
