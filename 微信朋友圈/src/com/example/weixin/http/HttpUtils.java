package com.example.weixin.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class HttpUtils {
	public static String httptext(String url){
		String result = "";
		HttpGet get = new HttpGet(url);
		HttpParams params = new BasicHttpParams();
		HttpConnectionParams.setConnectionTimeout(params, 5000);
		HttpConnectionParams.setSoTimeout(params, 5000);
		HttpClient client = new DefaultHttpClient(params);
		try {
			HttpResponse response = client.execute(get);
			if(response.getStatusLine().getStatusCode()==200){
				InputStream is = response.getEntity().getContent();
				String readLine = "";
				BufferedReader br = new BufferedReader(new InputStreamReader(is, "utf-8"));
				while((readLine = br.readLine())!=null){
					result = result + readLine;
				}
			}
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	public static Bitmap httpimg(String url){
		Bitmap bitmap = null;
		HttpGet get = new HttpGet(url);
		HttpParams params = new BasicHttpParams();
		HttpConnectionParams.setConnectionTimeout(params, 5000);
		HttpConnectionParams.setSoTimeout(params, 5000);
		HttpClient client = new DefaultHttpClient(params);
		try {
			HttpResponse response = client.execute(get);
			if(response.getStatusLine().getStatusCode()==200){
				InputStream is = response.getEntity().getContent();
				bitmap = BitmapFactory.decodeStream(is);
			}
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return bitmap;
	}
}
