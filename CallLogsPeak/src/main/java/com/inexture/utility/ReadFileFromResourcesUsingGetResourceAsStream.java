package com.inexture.utility;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import com.inexture.model.CallLogs;



public class ReadFileFromResourcesUsingGetResourceAsStream 
{
    public static List<CallLogs> getCallsData(String fileName) throws IOException 
    {
        //Creating instance to avoid static member methods
        ReadFileFromResourcesUsingGetResourceAsStream instance 
            = new ReadFileFromResourcesUsingGetResourceAsStream();

        InputStream is = instance.getFileAsIOStream(fileName);
        return instance.printFileContent(is);
        
     
    }

    private InputStream getFileAsIOStream(final String fileName) 
    {
        InputStream ioStream = this.getClass()
            .getClassLoader()
            .getResourceAsStream(fileName);
        
        if (ioStream == null) {
            throw new IllegalArgumentException(fileName + " is not found");
        }
        return ioStream;
    }

    private List<CallLogs> printFileContent(InputStream is) throws IOException 
    {
    	List<CallLogs> callLogs = new ArrayList<CallLogs>();
        try (InputStreamReader isr = new InputStreamReader(is); 
                BufferedReader br = new BufferedReader(isr);) 
        {
            String line;
            while ((line = br.readLine()) != null) {
            	String[] call = line.split(":");
            	CallLogs callObj = new CallLogs(Long.valueOf(call[0]), Long.valueOf(call[1]));
            	callLogs.add(callObj);
            	
                //System.out.println(call[0]);
            }
            is.close();
        }
        
        return callLogs;
    }
}