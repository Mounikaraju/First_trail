package com.eb.entity;

public  class Domestic extends Connection {
	float[] slabs={2.3f,4.2f,5.5f};
	float billAmt=0.0f;
	public Domestic(int currentReading, int previousReading)
	{
		super(currentReading, previousReading);
	}
	public float computeBill()
	{ 
		if(currentReading>100)
		{ 
			billAmt=billAmt+(50*slabs[0]);
			billAmt=billAmt+(50*slabs[1]);
			currentReading=currentReading-100;
            billAmt=billAmt+(currentReading*slabs[2]);
		}
		else if(currentReading<=100&&currentReading>=50)
		{
			billAmt=billAmt+(50*slabs[0]);
			currentReading=currentReading-50;
			billAmt=billAmt+(currentReading*slabs[1]);
		}
		else if(currentReading<=50)
		{
			billAmt=billAmt+(currentReading*slabs[0]);
		}
		return billAmt;
	}
}
