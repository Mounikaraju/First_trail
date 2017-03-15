package com.eb.entity;


public class Commerical extends Connection {
	float[] slabs={5.2f,6.8f,8.3f};
	float billAmt=0.0f;
	float finalAmt;
	public Commerical(int currentReading, int previousReading)
	{
	 super(currentReading, previousReading);
	 this.currentReading=currentReading;
	 this.previousReading=previousReading;
	}
	public float computeBill(){
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
		if(billAmt>=10000)
		{
			finalAmt=(billAmt*00.9f)+billAmt;
		}
		else if(billAmt>=5000)
		{
			finalAmt=(billAmt*0.06f)+billAmt;
		}
		else if(billAmt<5000)
		{
			finalAmt=(billAmt*0.02f)+billAmt;
		}
		return finalAmt;
	}
}

