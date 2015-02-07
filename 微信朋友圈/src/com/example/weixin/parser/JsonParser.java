package com.example.weixin.parser;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.example.weixin.vo.Person;
import com.google.gson.JsonArray;

public class JsonParser {
	public static List<Person> jsonParser(String result){
		List<Person> list = new ArrayList<Person>();
		Person person = null;
		try {
			JSONObject obj = new JSONObject(result);
			String total = obj.getString("total");
			String per_page = obj.getString("per_page");
			String current_page = obj.getString("current_page");
			String last_page = obj.getString("last_page");
			JSONArray array = obj.getJSONArray("data");
			for(int i = 0;i<array.length();i++){
				JSONObject obj2 = array.getJSONObject(i);
				person = new Person();
				person.setTotal(total);
				person.setPer_page(per_page);
				person.setCurrent_page(current_page);
				person.setContent(obj2.getString("content"));
				person.setGroup_id(obj2.getString("group_id"));
				person.setStickied(obj2.getString("stickied"));
				person.setCreated_at(obj2.getString("created_at"));
				person.setId(obj2.getString("id"));
				person.setUp(obj2.getString("up"));
				person.setTotal_replies(obj2.getString("total_replies"));
				person.setVisits(obj2.getString("visits"));
				
				JSONObject obj3 = obj2.getJSONObject("author");
				person.setA_id(obj3.getString("id"));
				person.setUsername(obj3.getString("username"));
				person.setAvatar(obj3.getString("avatar"));
				person.setMedal_id(obj3.getString("medal_id"));
				person.setMedal_desc(obj3.getString("medal_desc"));
				
				JSONObject obj4 = obj2.getJSONObject("group");
				person.setG_id(obj4.getString("id"));
				person.setTitle(obj4.getString("title"));
				person.setReplies(obj2.getString("replies"));
				
				JSONArray array2 = obj2.getJSONArray("attachments");
				for(int j = 0;j<array2.length();j++){
					JSONObject obj5 = array2.getJSONObject(j);
					person.setUrl(obj5.getString("url"));
					person.setMime(obj5.getString("mime"));
					person.setWidth(obj5.getString("width"));
					person.setHieght(obj5.getString("height"));
					person.setThumb(obj5.getString("thumb"));
				}
				
				JSONArray array3 = obj2.getJSONArray("last_up_users");
				for(int m = 0;m<array3.length();m++){
					JSONObject obj6 = array3.getJSONObject(m);
					person.setLast_id(obj6.getString("id"));
					person.setLast_username(obj6.getString("username"));
					person.setLast_avatar(obj6.getString("avatar"));
					person.setLast_medal_id(obj6.getString("medal_id"));
					person.setLast_medal_desc(obj6.getString("medal_desc"));
				}
				list.add(person);
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
}
