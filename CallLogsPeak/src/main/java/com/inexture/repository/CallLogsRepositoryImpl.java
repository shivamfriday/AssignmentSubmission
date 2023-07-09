package com.inexture.repository;


import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

import com.inexture.model.CallLogs;
import com.inexture.utility.ReadFileFromResourcesUsingGetResourceAsStream;

public class CallLogsRepositoryImpl implements ICallLogsRepository {

	@Override
	public List<CallLogs> getCallLogsList() {
		// TODO Auto-generated method stub

		String fileName = null;
		//FileInputStream fis = null;
		
		// Getting the file name from properties file to avoid -
		//hardcoding file name
		InputStream ioStream = this.getClass().getClassLoader().getResourceAsStream("application.properties");

		if (ioStream == null) {
			throw new IllegalArgumentException(fileName + " is not found");
		}
		
		Properties prop = new Properties();
		try {
			prop.load(ioStream);
			fileName = prop.getProperty("fileName");
			
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}

		
		//adding txt extension 
		fileName = fileName+".txt";
		List<CallLogs> callLogs = null;
		try {
			//getting all calllogs from utility classes
			callLogs = ReadFileFromResourcesUsingGetResourceAsStream.getCallsData(fileName);
		} catch (IOException e) {
			
			e.printStackTrace();
		}

		return callLogs;
	}

}
