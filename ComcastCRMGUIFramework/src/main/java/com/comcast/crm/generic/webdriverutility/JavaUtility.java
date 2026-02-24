package com.comcast.crm.generic.webdriverutility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtility {
	
	public int getRandomeNumber() {
		Random random=new Random();
		int randomNumber=random.nextInt(10000);
		return randomNumber;
		
	}
	
	public String getSystemDateYYYYDDMM() {
		Date date=new Date();
		
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		String datef=sdf.format(date);
		return datef;
	}
	
	public String getRequiredDateYYYYDDMM(int days) {
		   Date date=new Date();
		   
		   SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		   String startDate=sdf.format(date);
		   Calendar cal=sdf.getCalendar();
		   cal.add(Calendar.DAY_OF_MONTH,days);
		   String requiredDate=sdf.format(cal.getTime());
		   return requiredDate;
	}

}
