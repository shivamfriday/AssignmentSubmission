package com.inexture.service;

import java.util.ArrayList;
import java.util.Collections;

import com.inexture.dto.TimeInterval;
import com.inexture.model.CallLogs;
import com.inexture.repository.CallLogsRepositoryImpl;
import com.inexture.repository.ICallLogsRepository;

public class CallLogsServiceImpl implements ICallLogsService {

	ICallLogsRepository callRepository = new CallLogsRepositoryImpl();
	

	@Override
	public void serachSimultaneousCallPeak() {
		
		// TODO Auto-generated method stub

		int count = 0;
		int max = Integer.MIN_VALUE;

		ArrayList<TimeInterval> timeIntervals = new ArrayList<TimeInterval>();
		
		//Iterating over the call logs that we are getting from the text file
		for (CallLogs call : callRepository.getCallLogsList()) {
			timeIntervals.add(new TimeInterval(call.callStart, true));
			timeIntervals.add(new TimeInterval(call.callEnd, false));
		}
		
		/*
		 * Sorting the all call logs Sorting because we want to know that which call
		 * intersect other we can say that which call is simultenous to others
		 */

		Collections.sort(timeIntervals, TimeInterval.sortCallLogs);
		
		
		for (int i = 0; i < timeIntervals.size(); i++) {
			if (timeIntervals.get(i).isStartTime()) {
				/*Setting each call end time to with his successor call-
				 * because we want exact interval at where we have 
				 * the max number of peek that's why we are also doing 
				 * count++ the
				 * 
				 * */
			
				timeIntervals.get(i).setEndTime(timeIntervals.get(i + 1).getStartTime());
				timeIntervals.get(i).setIntersect(++count);
				max = Math.max(count, max);
			} else {
				/* decresing the call because if the call ends
				 * that means our server load is decreasing  
				 * 
				 * 
				 * */
				timeIntervals.get(i).setIntersect(--count);
				max = Math.max(count, max);
			}
			
			

		}
		System.out.println(timeIntervals);

		for (TimeInterval timeEvent : timeIntervals) {
			/*
			 * we are itrating here because it can be posiblity that there can be many
			 * iterval time where we could have the peek call in a given call logs
			 */
			if (timeEvent.getIntersect() == max) {
				System.out.println("The peak for this call log is " + timeEvent.getIntersect() + " simultaneous calls,"
						+ " that occurred between " + timeEvent.getStartTime() + " and " + timeEvent.getEndTime());
			}
		}

	}

}
