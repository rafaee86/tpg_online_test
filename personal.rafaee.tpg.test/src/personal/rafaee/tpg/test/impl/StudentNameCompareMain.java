package personal.rafaee.tpg.test.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import personal.rafaee.tpg.test.core.Student;
import personal.rafaee.tpg.test.core.StudentNameComparator;
import personal.rafaee.tpg.test.core.TimingMeasureTool;

/*
* @Author   Mohammad Rafaee Bin Suhaimi
* @Email rafaee86@gmail.com
* @Date 19/5/2017
*/
public class StudentNameCompareMain {

	public static void main(String[] args) {
		
		JFileChooser chooser = new JFileChooser();
		
		chooser.setAcceptAllFileFilterUsed(false);
		FileNameExtensionFilter extFilter = new FileNameExtensionFilter("text files (*.txt)", "txt");
		chooser.addChoosableFileFilter(extFilter);
		chooser.setDialogTitle("Open Student File");
		
		File file = null;
		if(chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION){     
		  file = chooser.getSelectedFile();    
		  if(file != null){
		  	BufferedReader in;
		  	Student student = null;
		  	StudentNameComparator comparator = new StudentNameComparator();
		  	TimingMeasureTool timing = new TimingMeasureTool("StudentNameCompareMain");
			timing.start();
			
			try {
				in = new BufferedReader(new FileReader(file));
				
				String line = in.readLine();
				while(line != null){
					if(line != null && !line.isEmpty()){
						String strArr[] =line.split(" "); 	
						if(strArr != null && strArr.length >= 3){
							student = new Student();
							student.setId(strArr[0]);
							student.setName(strArr[1]);
							student.setGrade(strArr[2]);
							comparator.addStudentList(student);
						}
					}
					line = in.readLine();
				}
				
				List<Student> studentList = comparator.sort();
				String message = "New List Arrangement is : \n";
				if(studentList != null && !studentList.isEmpty()){
					for(Student stud : studentList){
						message += stud.getId() + " " + stud.getName() + " " + stud.getGrade() + "\n";
					}
					
					message += "\nOld List Arrangement is : \n";
					
					for(Student stud : comparator.getStudentList()){
						message += stud.getId() + " " + stud.getName() + " " + stud.getGrade() + "\n";
					}
										
				}

				in.close();
				timing.end();

				message += "\n"+timing.process();
				JOptionPane.showMessageDialog(null, message);
			} catch (IOException e) {
				System.out.println("Error in reading file..");
			}
		  }
			
		}		
	}

}
