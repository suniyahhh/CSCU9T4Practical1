/**
 * 
 */
package com.stir.cscu9t4practical1;

/**
 * @author suniy
 *
 */
public class SwimEntry extends Entry{
	
	private String where;

	public SwimEntry(String n, int d, int m, int y, int h, int min, int s, float dist, String w) {
		super(n, d, m, y, h, min, s, dist);
		this.where=w;

	}

	/**
	 * @return the where
	 */
	public String getWhere() {
		return where;
	}

	/**
	 * @param where the where to set
	 */
	public void setWhere(String where) {
		this.where = where;
	}
	
	
	public String getEntry () {
		   String result = getName()+" swam " + getDistance() + " km "
		             + getWhere()+ " in " +getHour()+":"+getMin()+":"+ getSec() + " on "
		             +getDay()+"/"+getMonth()+"/"+getYear()+"\n";
		   return result;
		  } //getEntry
	

}
