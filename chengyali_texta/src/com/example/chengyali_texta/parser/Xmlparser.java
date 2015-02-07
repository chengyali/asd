package com.example.chengyali_texta.parser;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import android.util.Xml;

import com.example.chengyali_texta.vo.Student;

public class Xmlparser {
	public static List<Student> xmlparser(InputStream is){
		List<Student> list = null;
		Student student = null;
		String gradeName = "";
		String className = "";
		String tag = "";
		XmlPullParser xpp = Xml.newPullParser();
		try {
			xpp.setInput(is, "utf-8");
			int eventType = xpp.getEventType();
			while(eventType!=XmlPullParser.END_DOCUMENT){
				switch (eventType) {
				case XmlPullParser.START_DOCUMENT:
					list = new ArrayList<Student>();
					break;
				case XmlPullParser.START_TAG:
					tag = xpp.getName();
					if(tag.equals("grade")){
						gradeName = xpp.getAttributeValue(0);
					}else if(tag.equals("class")){
						className = xpp.getAttributeValue(0);
					}else if(tag.equals("student")){
						student = new Student();
						student.setGradename(gradeName);
						student.setClassname(className);
					}else if(tag.equals("name")){
						student.setName(xpp.nextText());
					}else if(tag.equals("pic")){
						student.setPic(xpp.nextText());
					}
					break;
				case XmlPullParser.END_TAG:
					if(xpp.getName().equals("student")){
						list.add(student);
						student = null;
					}
					tag = "";
					break; 

				default:
					break;
				}
				eventType = xpp.nextTag();
			}
		} catch (XmlPullParserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
}
