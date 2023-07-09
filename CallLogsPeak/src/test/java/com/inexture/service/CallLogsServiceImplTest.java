package com.inexture.service;


import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Test;






public class CallLogsServiceImplTest {
	
	
	
	@Test
	public void testSerachSimultaneousCallPeak() {
		 CallLogsServiceImpl callService = mock(CallLogsServiceImpl.class);
			/*
			 * I tried this but not able to do as I am not good in this extreamly sorry for
			 * this one
			 */
		//doNothing().when(callService).serachSimultaneousCallPeak();
		//callService.serachSimultaneousCallPeak();
		//verify(callService,times(1)).serachSimultaneousCallPeak();
	}

}
