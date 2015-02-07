package com.example.chengyali_texta.http;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Xml;

import com.example.chengyali_texta.vo.Student;

public class HttpUtils {
	public static InputStream httpurl(String strurl){
		InputStream is = null;
		HttpURLConnection httpurlConnection;
		try {
			URL url = new URL(strurl);
			httpurlConnection = (HttpURLConnection) url.openConnection();
			httpurlConnection.setConnectTimeout(5000);
			httpurlConnection.setReadTimeout(5000);
			if(httpurlConnection.getResponseCode()==200){
				is = httpurlConnection.getInputStream();
			}
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return is;
	}
	public static Bitmap imgUrl(String Url){
		Bitmap bitmap = null;
		HttpURLConnection httpurl;
		try {
			URL url = new URL(Url);
			httpurl = (HttpURLConnection) url.openConnection();
			httpurl.setConnectTimeout(5000);
			httpurl.setReadTimeout(5000);
			if(httpurl.getResponseCode()==200){
				InputStream is = httpurl.getInputStream();
				bitmap = BitmapFactory.decodeStream(is);
			}
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return bitmap ;
	}
}
