package personal.rafaee.tpg.test.core;

import java.util.List;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;
/**
 * Question ‐ 1
 *	Write a class called IPValidationRegex which will use regular expression to validate
 *	input IP addresses according to the following criteria:
 *	- IP address is a string in the form "A.B.C.D", where the value of A, B, C, and D may range
 *	- from 0 to 255. Leading zeros are allowed. The length of A, B, C, or D can't be greater than 3.
 *	- Prepare a text file with a list of IP addresses and have your class read in the file then
 *	- filter out any invalid IP address(es).

 *
 * @Author   Mohammad Rafaee Bin Suhaimi
 * @Email rafaee86@gmail.com
 * @Date 19/5/2017
 */
public class IPValidationRegex {

	private static final Pattern PATTERN = Pattern.compile("^(([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.){3}([01]?\\d\\d?|2[0-4]\\d|25[0-5])$");
	
	private List<String> ipList;
	
	public IPValidationRegex(List<String> ipList){
		this.ipList = ipList;
	}	
	
	public String validateIP(){
		Boolean isValid = null;
		String msg = "The result as below : \n";
		List<String> list = this.ipList;
		if(list != null && list.size() > 0){
			for(String ip : list){
				isValid = PATTERN.matcher(ip).matches();
				if(isValid){
					msg += ip + " is valid.\n";
				}else{
					msg += ip + " is not valid.\n";
				}
			}
		}
		
		return msg;
	}
}
