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
import me.dawson.noom.view.NoomButton;
import me.dawson.noom.view.NoomImage;
import me.dawson.noom.view.NoomText;
import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;

public class ViewGroupActivity extends Activity {
	public static final String TAG = "ViewGroupActivity";

	private NoomText tvNoom;
	private NoomImage ivNoom;
	private NoomButton btNoom;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_viewgroup);
		setTitle(TAG);

		tvNoom = (NoomText) findViewById(R.id.tv_noom);
		ivNoom = (NoomImage) findViewById(R.id.iv_noom);
		btNoom = (NoomButton) findViewById(R.id.bt_noom);

		Bitmap bm = BitmapUtil.getAssetBitmap(this, "image1.jpg");
		NoomBitmap nb = new NoomBitmap(bm);
		tvNoom.setBackground(nb);

		bm = BitmapUtil.getAssetBitmap(this, "image2.jpg");
		nb = new NoomBitmap(bm);
		ivNoom.setBackground(nb);

		bm = BitmapUtil.getAssetBitmap(this, "image3.jpg");
		nb = new NoomBitmap(bm);
		btNoom.setBackground(nb);
	}

}
