package com.inexture.dto;



import java.util.Comparator;

/*we are creating DTO object here because we sent this object over network 
or hiding real pojo classes from the client, network, or user to avoid exposing 
real entity*/

public class TimeInterval {
    private long startTime;
    private long endTime;
    private boolean isStartTime;
    private int intersect;

    public TimeInterval(long startTime, boolean isStartTime) {
        this.startTime = startTime;
        this.isStartTime = isStartTime;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public boolean isStartTime() {
        return isStartTime;
    }

    public void setStartTimeEvent(boolean isStartTime) {
        this.isStartTime = isStartTime;
    }

    public int getIntersect() {
        return intersect;
    }

    public void setIntersect(int intersect) {
        this.intersect = intersect;
    }

    public long getEndTime() {
        return endTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }
    
    


    @Override
	public String toString() {
		return "TimeEvent [startTime=" + startTime + ", endTime=" + endTime + ", isStartTime=" + isStartTime
				+ ", intersect=" + intersect + "]";
	}


	public static final Comparator<TimeInterval> sortCallLogs = new Comparator<TimeInterval>() {
        //@Override
        public int compare(TimeInterval timeInterval1, TimeInterval timeInterval2) {
            return (int) (timeInterval1.getStartTime() -  timeInterval2.getStartTime());
        }
    };


 
}




