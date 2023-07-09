package com.inexture.repository;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mock;

import com.inexture.model.CallLogs;



public class CallLogsRepositoryImplTest {

	@Mock
	ICallLogsRepository repository = new CallLogsRepositoryImpl();

	@Test
	public void test() {
		

		List<CallLogs> callLogsTest = new ArrayList<CallLogs>();
		callLogsTest.add(new CallLogs(1385718405, 1385718491));
		callLogsTest.add(new CallLogs(1385718407, 1385718409));
		callLogsTest.add(new CallLogs(1385718408, 1385718452));
		callLogsTest.add(new CallLogs(1385718408, 1385718464));
		callLogsTest.add(new CallLogs(1385718413, 1385718452));
		

		List<CallLogs> callLogs = repository.getCallLogsList();

		Assert.assertTrue(callLogs.equals(callLogsTest));
	}

}
