/**
 *
 * Copyright (c) 2014 CoderKiss
 *
 * CoderKiss[AT]gmail.com
 *
 */

package me.dawson.noom;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class HomeActivity extends Activity implements OnClickListener {
	public static final String TAG = "HomeActivity";

	private Button btListView;
	private Button btViewGroup;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);
		this.setTitle(TAG);

		btListView = (Button) findViewById(R.id.bt_listview);
		btViewGroup = (Button) findViewById(R.id.bt_viewgroup);

		btListView.setOnClickListener(this);
		btViewGroup.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {
		if (v.equals(btListView)) {
			Intent intent = new Intent();
			intent.setClass(this, ListViewActivity.class);
			startActivity(intent);
		} else if (v.equals(btViewGroup)) {
			Intent intent = new Intent();
			intent.setClass(this, ViewGroupActivity.class);
			startActivity(intent);
		}
	}
}
