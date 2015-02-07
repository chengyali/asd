package com.example.weixin.utils;

import com.example.weixin.http.HttpUtils;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;

public class ImageLoader {
	String imgUrl;
	ImageInterface imageinterface;
	
	public ImageLoader(String imgUrl, 
			ImageInterface imageinterface) {
		super();
		this.imgUrl = imgUrl;
		this.imageinterface = imageinterface;
		new MyThread().start();
	}
	class MyThread extends Thread{
		@Override
		public void run() {
			// TODO Auto-generated method stub
			super.run();
			Bitmap bitmap=HttpUtils.httpimg(imgUrl);
			Message msg = hand.obtainMessage(1, bitmap);
			hand.sendMessage(msg);
		}
	}
	Handler hand = new Handler(){
		public void handleMessage(android.os.Message msg) {
			if(msg.what==1){
				Bitmap bitmap = (Bitmap) msg.obj;
				imageinterface.imageInterface(bitmap);
			}
		}
	};
	
}
