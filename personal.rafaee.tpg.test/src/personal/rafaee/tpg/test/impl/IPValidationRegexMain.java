package personal.rafaee.tpg.test.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import personal.rafaee.tpg.test.core.IPValidationRegex;
import personal.rafaee.tpg.test.core.TimingMeasureTool;

/*
* @Author   Mohammad Rafaee Bin Suhaimi
* @Email rafaee86@gmail.com
* @Date 19/5/2017
*/
public class IPValidationRegexMain {

	public static void main(String[] args){
		
		JFileChooser chooser = new JFileChooser();
		
		chooser.setAcceptAllFileFilterUsed(false);
		FileNameExtensionFilter extFilter = new FileNameExtensionFilter("text files (*.txt)", "txt");
		chooser.addChoosableFileFilter(extFilter);
		chooser.setDialogTitle("Open IP File");
		
		File file = null;
		if(chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION){     
		  file = chooser.getSelectedFile();    
		  if(file != null){
		  	BufferedReader in;
			try {
				in = new BufferedReader(new FileReader(file));
			
				List<String> ipList = new ArrayList<String>();
				String line = in.readLine();
				while(line != null){
					if(line != null && !line.isEmpty()){
						ipList.add(line);
					}
					line = in.readLine();
				}
				
				TimingMeasureTool timing = new TimingMeasureTool("IPValidationRegexMain");
				timing.start();
				
				IPValidationRegex validationObj = new IPValidationRegex(ipList);
				String message = validationObj.validateIP();	
								
				in.close();
				timing.end();
				message += "\n" + timing.process();
				JOptionPane.showMessageDialog(null, message);
			} catch (IOException e) {
				System.out.println("Error in reading file.");
			}
		  }
			
		}		
	}
}
