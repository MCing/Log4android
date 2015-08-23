package com.example.log4android;

import java.io.File;
import java.io.IOException;
import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;

public class MainActivity extends Activity {

	//1 定义LogWriter对象
	private LogWriter mLogWriter;
	//2.初始化
	public void initLog(){
		File logf = new File(Environment.getExternalStorageDirectory()
        		+ File.separator + "DemoLog.txt");
        try {
			mLogWriter = LogWriter.open(logf.getAbsolutePath());
		} catch (IOException e) {
		}
	}
	//3. 包装
	public void log(String msg) {
    	try {
			mLogWriter.print(MainActivity.class, msg);
		} catch (IOException e) {
			// TODO Auto-generated catch block
		}
    }
	
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);   
        setContentView(R.layout.activity_main);
        
        
        //4. 使用
        log("onCreate()");
    }
    
}
