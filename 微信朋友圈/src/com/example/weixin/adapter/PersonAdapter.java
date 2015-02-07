package com.example.weixin.adapter;

import java.util.List;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.ScaleAnimation;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.weixin.R;
import com.example.weixin.utils.ImageInterface;
import com.example.weixin.utils.ImageLoader;
import com.example.weixin.vo.Person;

public class PersonAdapter extends BaseAdapter {
	Context context;
	List<Person> list;

	public PersonAdapter(Context context, List<Person> list) {
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
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	class Handler {
		ImageView user_image, content_image, pinglun;
		TextView username, content, content_time;
		LinearLayout ll;

	}

	@Override
	public View getView(int arg0, View view, final ViewGroup arg2) {
		// TODO Auto-generated method stub
		final Handler h;
		if (view == null) {
			h = new Handler();
			view = LayoutInflater.from(context).inflate(R.layout.list_item,
					null);
			h.ll=(LinearLayout) view.findViewById(R.id.linerallayout);
			h.user_image = (ImageView) view.findViewById(R.id.username_image);
			h.username = (TextView) view.findViewById(R.id.username);
			h.content = (TextView) view.findViewById(R.id.content);
			h.content_image = (ImageView) view.findViewById(R.id.content_image);
			h.content_time = (TextView) view.findViewById(R.id.content_time);
			h.pinglun = (ImageView) view.findViewById(R.id.pinglun);
			view.setTag(h);
		} else {
			h = (Handler) view.getTag();
		}
		h.username.setText(list.get(arg0).getUsername());
		h.content.setText(list.get(arg0).getContent());
		h.content_time.setText(list.get(arg0).getCreated_at());

		final String imgUrl = list.get(arg0).getAvatar();
		h.user_image.setTag(imgUrl);

		final String imgUrl2 = list.get(arg0).getUrl();
		h.content_image.setTag(imgUrl2);
		if (imgUrl2 == null) {
			h.content_image.setVisibility(View.GONE);
		} else {
			h.content_image.setVisibility(View.VISIBLE);
			new ImageLoader(imgUrl2, new ImageInterface() {

				@Override
				public void imageInterface(Bitmap bitmap) {
					// TODO Auto-generated method stub
					ImageView imageview2 = (ImageView) arg2
							.findViewWithTag(imgUrl2);
					if (imageview2 != null) {
						h.content_image.setImageBitmap(bitmap);
					}

				}
			});
		}

		new ImageLoader(imgUrl, new ImageInterface() {

			@Override
			public void imageInterface(Bitmap bitmap) {
				// TODO Auto-generated method stub
				ImageView imageview = (ImageView) arg2.findViewWithTag(imgUrl);
				if (imageview != null) {
					imageview.setImageBitmap(bitmap);
				}

			}
		});
		
		
		h.pinglun.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				ScaleAnimation scale=new ScaleAnimation(0, 1, 0, 1);
				scale.setDuration(500);
				h.ll.setVisibility(View.VISIBLE);
				h.ll.setAnimation(scale);
				
			}
		});
		return view;
	}

}
