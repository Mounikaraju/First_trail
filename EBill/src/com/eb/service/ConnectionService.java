package com.eb.service;

import com.eb.entity.Commerical;
import com.eb.entity.Domestic;
import com.eb.exception.InvalidConnectionType;
import com.eb.exception.InvalidReadingException;

public class ConnectionService {
	int flag=3;
	public boolean validate(int currentReading, int previousReading, String type) 
	{ 
		if(type.equals("Commerical")||type.equals("Domestic"))
			{
			 if((currentReading>previousReading&&(currentReading>0&&previousReading>0)))
					 {
				       return true;
					 }
			 else 
			 {  flag=2;
				 return false;
			 }
			 
			}
		else
		{
			flag=1;
			return false;
			
		}
          
	}

	public float calculateBillAmt(int currentReading, int previousReading, String type)  
	// TODO Auto-generated method stub
	{float billAmount=0.0f;
	if(validate(currentReading,previousReading,type)&&flag==3)
	{   
		if(type.equals("Commerical"))
			{Commerical comer=new Commerical(currentReading,previousReading);
			billAmount=comer.computeBill();
			}
		else
			{Domestic des =new Domestic(currentReading,previousReading);
			billAmount=des.computeBill();
			return billAmount;}
	}
	else if(flag==1)
		{billAmount=-1.0f;
		}
	else if(flag==2)
		{billAmount=-2.0f;
		}return billAmount;}
	public String generateBill(int currentReading, int previousReading, String type)
	{float check;
	String str1=null;
		try{ check=calculateBillAmt(currentReading,previousReading,type);
              if(check>0)
            	  str1= "Amount to be paid"+check;
              else if(check==-1.0f)
            	  throw new InvalidConnectionType();
              else if(check==-2.0f)
            	  throw new InvalidReadingException();
		}
		catch(InvalidConnectionType ect)
		{
			str1=ect.toString();
			//System.out.println(str1);
			
		}
		catch(InvalidReadingException er)
		{
			 str1=er.toString();
			//System.out.println(str2);
			
		}
		return str1;
	}
	
	
}

	