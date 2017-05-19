package personal.rafaee.tpg.test.core;

import java.text.NumberFormat;

/*
 * Question – 3
 * Design a comprehensive timing measure tool, which can be used to measure time
 * consumed for any independent method in other class.
 * 
 * @Author   Mohammad Rafaee Bin Suhaimi
 * @Email rafaee86@gmail.com
 * @Date 19/5/2017
 */
public class TimingMeasureTool {
	
	private final static Double NANO_FACTORIAL =    1000000000.0;
	private final static Double MINUTE_FACTORIAL = 60000000000.0;

	private String name; 
	private Long start ;
	private Long end;
	
	public TimingMeasureTool(String name){
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public Long getStart() {
		return start;
	}

	public Long getEnd() {
		return end;
	}

	public void start(){
		start = System.nanoTime();
	}
	
	public void end(){
		end = System.nanoTime();
	}
	
	public String process(){
		NumberFormat nf = NumberFormat.getIntegerInstance();
		nf.setMaximumFractionDigits(0);
		Long st = getStart() != null ? getStart() : 0;
		Long en = getEnd() != null ? getEnd() : 0;
		Long elapsedTime = en - st;
		if(elapsedTime < 0) throw new RuntimeException("Elapsed time error");
		
		String message = "Process "+getName()+" take "+ nf.format(elapsedTime/MINUTE_FACTORIAL) +" minute and "+nf.format((elapsedTime%MINUTE_FACTORIAL)/NANO_FACTORIAL)+" seconds to be completed. (elapsed on "+elapsedTime+" nanoseconds)";
		return message;
	}
}
