package com.example.chengyali_texta.adapter;

import java.util.List;

import com.example.chengyali_texta.R;
import com.example.chengyali_texta.vo.Student;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class StudentAdapter extends BaseAdapter {
	Context context;
	List<Student> list;
	
	public StudentAdapter(Context context, List<Student> list) {
		super();
		this.context = context;
		this.list = list;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return list.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}
	class Handler{
		ImageView image;
		TextView grade,classes,name;
	}
	@Override
	public View getView(int position, View view, ViewGroup parent) {
		// TODO Auto-generated method stub
		Handler h;
		 if(view == null){
			 h = new Handler();
			 view = LayoutInflater.from(context).inflate(R.layout.list_item, null);
			 h.image = (ImageView) view.findViewById(R.id.list_image);
			 h.grade = (TextView) view.findViewById(R.id.list_grade);
			 h.classes = (TextView) view.findViewById(R.id.list_class);
			 h.name = (TextView) view.findViewById(R.id.list_name);
			 view.setTag(h);
		 }
		 else{
			 h = (Handler) view.getTag();
		 }
		 h.grade.setText(list.get(position).getGradename());
		 h.classes.setText(list.get(position).getClassname());
		 h.name.setText(list.get(position).getName());
		return view;
	}

}
