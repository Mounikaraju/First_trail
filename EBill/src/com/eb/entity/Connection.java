package com.eb.entity;

public abstract class Connection {
  int previousReading;
  int currentReading;
 // float[] slabs;
  public Connection(int currentReading, int previousReading)
  {
	  this.currentReading= currentReading;
	  this.previousReading=previousReading;
	  
  }
  public abstract  float computeBill();
public int getPreviousReading() {
	return previousReading;
}
public void setPreviousReading(int previousReading) {
	this.previousReading = previousReading;
}
public int getCurrentReading() {
	return currentReading;
}
public void setCurrentReading(int currentReading) {
	this.currentReading = currentReading;
}

}
