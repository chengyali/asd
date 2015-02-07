package com.example.weixin;

import java.util.List;

import com.example.weixin.adapter.PersonAdapter;
import com.example.weixin.http.HttpUtils;
import com.example.weixin.parser.JsonParser;
import com.example.weixin.vo.Person;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.app.Activity;
import android.view.Menu;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends Activity {
	TextView text;
	List<Person> list;
	ListView lv;
	PersonAdapter adapter;
	private static final String URL = "http://www.yasite.net/rss.php";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		lv = (ListView) findViewById(R.id.listView1);
		new MyThread().start();
	}
	class MyThread extends Thread{
		@Override
		public void run() {
			// TODO Auto-generated method stub
			super.run();
			String result = HttpUtils.httptext(URL);
			list =  JsonParser.jsonParser(result);
			System.out.println(list);
			Message msg = hand.obtainMessage(1, list);
			hand.sendMessage(msg);
		}
	}
	Handler hand = new Handler(){
		public void handleMessage(android.os.Message msg) {
			if(msg.what==1){
				adapter = new PersonAdapter(MainActivity.this, list);
				lv.setAdapter(adapter);
			}
		}
	};
}
