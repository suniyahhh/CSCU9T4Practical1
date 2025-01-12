/**
 * 
 */
package com.stir.cscu9t4practical1;

/**
 * @author suniy
 *
 */
public class CycleEntry extends Entry {
	
	private String terrain;
	private String tempo;
	
	/**
	 * Constructor
	 */
	public CycleEntry(String n, int d, int m, int y, int h, int min, int s, float dist, String ter, String tem) {
		super(n, d, m, y, h, min, s, dist);
		this.terrain = ter;
		this.tempo = tem;
	}

	/**
	 * @return the terrain
	 */
	public String getTerrain() {
		return terrain;
	}

	/**
	 * @param terrain the terrain to set
	 */
	public void setTerrain(String terrain) {
		this.terrain = terrain;
	}

	/**
	 * @return the tempo
	 */
	public String getTempo() {
		return tempo;
	}

	/**
	 * @param tempo the tempo to set
	 */
	public void setTempo(String tempo) {
		this.tempo = tempo;
	}
	
	
	public String getEntry () {
		   String result = getName()+" cycled " + getDistance() + " km in "
		             +getHour()+":"+getMin()+":"+ getSec() + " on "
		             +getDay()+"/"+getMonth()+"/"+getYear()+ " on " + 
		             getTerrain() + " at " +getTempo() +" tempo\n" ;
		   return result;
	} //getEntry
	

	
	

}
