package com.inexture.model;

import java.util.Objects;

public class CallLogs {
	public long callStart;
	public long callEnd;

	public CallLogs(long start, long callEnd) {
		this.callStart = start;
		this.callEnd = callEnd;
	}

	public long getCallStart() {
		return callStart;
	}

	public void setCallStart(long callStart) {
		this.callStart = callStart;
	}

	public long getCallEnd() {
		return callEnd;
	}

	public void setCallEnd(long callEnd) {
		this.callEnd = callEnd;
	}
	
	

	@Override
	public int hashCode() {
		return Objects.hash(callEnd, callStart);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CallLogs other = (CallLogs) obj;
		
		
		
		return callEnd == other.callEnd && callStart == other.callStart;
	}

	@Override
	public String toString() {
		return "CallLogs [callStart=" + callStart + ", callEnd=" + callEnd + "]";
	}
	
	
}


