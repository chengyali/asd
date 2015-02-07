package com.example.chengyali_texta;

import java.io.InputStream;
import java.util.List;

import com.example.chengyali_texta.adapter.StudentAdapter;
import com.example.chengyali_texta.http.HttpUtils;
import com.example.chengyali_texta.parser.Xmlparser;
import com.example.chengyali_texta.vo.Student;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.app.Activity;
import android.view.Menu;
import android.widget.ListView;

public class MainActivity extends Activity {
	ListView lv;
	StudentAdapter adapter;
	List<Student> list;
	private static final String LOGIN_URL = "http://192.68.1.8:8080/q/Student.xml";
	private static final int URL = 1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		lv=(ListView) findViewById(R.id.listView1);
		new MyThread().start();
	}
	public class MyThread extends Thread{
		@Override
		public void run() {
			// TODO Auto-generated method stub
			super.run();
			InputStream result = HttpUtils.httpurl(LOGIN_URL);
			list = Xmlparser.xmlparser(result);
			Message msg= hand.obtainMessage(URL, list);
			hand.sendMessage(msg);
		}
	}
	public Handler hand = new Handler(){

		@Override
		public void handleMessage(Message msg) {
			// TODO Auto-generated method stub
			super.handleMessage(msg);
			if(msg.what==URL){
				adapter = new StudentAdapter(MainActivity.this, list);
				lv.setAdapter(adapter);
			}
		}
		
	};
}
