package com.inetBanking.utillities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {

		public Properties prop;
		public ReadConfig() 
		
		{
		
			try {
				FileInputStream fis = new FileInputStream("./Configurations//config.properties");
				prop = new Properties();
				
		
				try {
					prop.load(fis);	
					
					}
					catch (Exception  e) 
					{
						e.printStackTrace();
					}

			
			} 
			catch (FileNotFoundException e) 
			
			{	
				e.printStackTrace();
			}	
			
		}
		
		public String getUrl()
		
		{
			String url = prop.getProperty("Url");
			return url;
			 
		}
		
		
		public String getUsername()
		
		{
			
			return prop.getProperty("userId");
			 
		}
		
		public String getPassword()
		
		{
			String Password = prop.getProperty("Password");
			return Password;
			 
		}
		
		public String getBrowserName()
		
		{
			return prop.getProperty("browser");

			 
		}
		
		public String getChromePath()
		
		{
			String chromepath = prop.getProperty("chromepath");
			return chromepath;
			 
		}

	}


