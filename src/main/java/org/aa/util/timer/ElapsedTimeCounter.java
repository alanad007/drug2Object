package org.aa.util.timer;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.aa.util.Misc;

public class ElapsedTimeCounter {
	
	private static Map<String,ElapsedTimeCounter> timeCounters=new HashMap<String,ElapsedTimeCounter>();
	
	/**
	 * initiate Timer
	 * 	@param name
	 */
	public static  void setTimer(String name)
	{
		createInstance(name);
	}
	
    /**
     * returns time to process in seconds
     * @param name
     * @return
     */
	public static  long getTimeEllapsedInSec(String name)
    {
		ElapsedTimeCounter timer= getInstance(name);
		long endTime = System.nanoTime();
    	long elapsedTimeInSec = TimeUnit.SECONDS.convert((endTime - timer.startTime), TimeUnit.NANOSECONDS);
    	print(name+ " takes: " +elapsedTimeInSec+" sec");
    	return elapsedTimeInSec;
    }

	/**
	 * returns time to process in Milliseconds
	 * @param name
	 * @return
	 */
	public static  long getTimeEllapsedInMilliSec(String name)
    {
		ElapsedTimeCounter timer= getInstance(name);
		long endTime = System.nanoTime();
    	long elapsedTimeInMillis = TimeUnit.MILLISECONDS.convert((endTime - timer.startTime), TimeUnit.NANOSECONDS);
    	print(name+ " takes: " +elapsedTimeInMillis+" millisec");
    	return elapsedTimeInMillis;
    }
	
	/**
	 * removes timer by the specific name
	 * @param name
	 */
	public static  void FlushTimer(String name)
	{
		timeCounters.remove(name);
	}
    
	/**
	 * Clears all timers 
	 */
	public static void FlushAll()
	{
		try {
			TimeUnit.MILLISECONDS.sleep(2);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		timeCounters=new HashMap<String,ElapsedTimeCounter>();
	}
	
	
	
	
	
	
	private static ElapsedTimeCounter getInstance(String name)
	{
		ElapsedTimeCounter timer=timeCounters.get(name)!=null?timeCounters.get(name):createInstance(name);
		return timer;
	}
	
	
	
	/**
	 * 
	 * @param name
	 * @return
	 */
	private static ElapsedTimeCounter createInstance(String name)
	{
		timeCounters.put(name, new ElapsedTimeCounter(name));
		return timeCounters.get(name);
	}
	
	long startTime = System.nanoTime();
	String name="";
     
	/**
	 * 
	 * @param name
	 */
    private ElapsedTimeCounter(String name) {
		super();
		this.name = name;
		startTime = System.nanoTime();
	}


    
    
    private static void print(Object msg) {
		Misc.print(msg);
	
}
}
