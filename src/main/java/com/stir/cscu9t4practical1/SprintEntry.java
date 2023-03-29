/**
 * 
 */
package com.stir.cscu9t4practical1;

/**
 * @author suniy
 *
 */
public class SprintEntry extends Entry {
	
	private int repetitions;
	private int recovery;

	/**
	 * Constructor
	 */
	public SprintEntry(String n, int d, int m, int y, int h, int min, int s, float dist, int rep, int rec) {
		super(n, d, m, y, h, min, s, dist);
		this.repetitions = rep;
		this.recovery = rec;
	}

	/**
	 * @return the repetitions
	 */
	public int getRepetitions() {
		return repetitions;
	}

	/**
	 * @param repetitions the repetitions to set
	 */
	public void setRepetitions(int repetitions) {
		this.repetitions = repetitions;
	}

	/**
	 * @return the recovery
	 */
	public int getRecovery() {
		return recovery;
	}

	/**
	 * @param recovery the recovery to set
	 */
	public void setRecovery(int recovery) {
		this.recovery = recovery;
	}
	
	
	
	  public String getEntry () {
		   String result = getName()+" sprinted " + getRepetitions() + "x" + (int)getDistance()+ "m in " 
				   	 +getHour()+":"+getMin()+":"+ getSec()
		             + " with " +getRecovery()+ " minutes recovery on "
		             +getDay()+"/"+getMonth()+"/"+getYear()+"\n";
		   return result;
	} //getEntry
}
