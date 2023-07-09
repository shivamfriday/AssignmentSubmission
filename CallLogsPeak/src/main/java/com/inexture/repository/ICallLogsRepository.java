package com.inexture.repository;



import java.util.List;

import com.inexture.model.CallLogs;

public interface ICallLogsRepository {
     public List<CallLogs> getCallLogsList();
}
