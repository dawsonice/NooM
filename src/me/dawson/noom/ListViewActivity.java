/**
 *
 * Copyright (c) 2014 CoderKiss
 *
 * CoderKiss[AT]gmail.com
 *
 */

package me.dawson.noom;

import me.dawson.kisstools.utils.BitmapUtil;
import me.dawson.noom.view.NoomBitmap;
import me.dawson.noom.view.NoomImage;
import me.dawson.noom.view.NoomText;
import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;

public class ListViewActivity extends Activity {
	public static final String TAG = "ListViewActivity";

	private ListView lvNoom;
	private BaseAdapter adapter = new BaseAdapter() {

		@Override
		public int getCount() {
			return 20;
		}

		@Override
		public Object getItem(int position) {
			return null;
		}

		@Override
		public long getItemId(int position) {
			return 0;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			LinearLayout container = null;
			NoomImage ni = null;
			NoomText nt = null;
			if (!(convertView instanceof LinearLayout)) {
				container = new LinearLayout(parent.getContext());
				ni = new NoomImage(parent.getContext());
				ni.setId(2000);
				nt = new NoomText(parent.getContext());
				nt.setId(2001);
				nt.setGravity(Gravity.CENTER);
				LinearLayout.LayoutParams ilp = new LinearLayout.LayoutParams(
						200, 200);
				ilp.setMargins(10, 10, 10, 10);
				container.addView(ni, 0, ilp);
				LinearLayout.LayoutParams tlp = new LinearLayout.LayoutParams(
						LinearLayout.LayoutParams.MATCH_PARENT, 200);
				container.addView(nt, 1, tlp);
				tlp.setMargins(10, 10, 10, 10);
			} else {
				container = (LinearLayout) convertView;
				ni = (NoomImage) container.findViewById(2000);
				nt = (NoomText) container.findViewById(2001);
			}

			String fileName = "image" + (position % 4 + 1) + ".jpg";
			Bitmap bitmap = BitmapUtil.getAssetBitmap(parent.getContext(),
					fileName);
			NoomBitmap nb = new NoomBitmap(bitmap);
			ni.setBackground(nb);
			nt.setText("NoomText " + position);

			return container;
		}
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_listview);
		setTitle(TAG);

		lvNoom = (ListView) findViewById(R.id.lv_noom);
		lvNoom.setAdapter(adapter);
	}
}
