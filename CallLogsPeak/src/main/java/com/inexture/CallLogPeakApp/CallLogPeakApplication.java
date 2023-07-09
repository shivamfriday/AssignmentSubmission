package com.inexture.CallLogPeakApp;

import com.inexture.service.CallLogsServiceImpl;
import com.inexture.service.ICallLogsService;



public class CallLogPeakApplication {
	public static void main(String args[]) {
		  ICallLogsService callService = new CallLogsServiceImpl();
	      callService.serachSimultaneousCallPeak();
	}
	
}
