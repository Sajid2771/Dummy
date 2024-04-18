package com.shopperStack.generalUtility;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Random;

public class JavaUtility {
	
		public int randomNo() {
			
			Random r= new Random();
			int num= r.nextInt(1000);
			return num;
		}
		
		public String date() {
			String date=LocalDate.now().toString().replaceAll("[^0-9]","");
			return date;
		}
		
		public String dateTime() {
			String dateTime=LocalDateTime.now().toString().replaceAll("[^0-9]","");
			return dateTime;
		}
}
