/**
 *
 * Copyright (c) 2014 CoderKiss
 *
 * CoderKiss[AT]gmail.com
 *
 */

package me.dawson.noom.view;

import android.graphics.Bitmap;
import android.util.Log;

public class NoomBitmap {
	public static final String TAG = "NoomBitmap";

	private int refCount;
	private Bitmap bitmap;
	private Object lock;

	public NoomBitmap(Bitmap bm) {
		this.bitmap = bm;
		this.lock = new Object();
	}

	public Bitmap getBitmap() {
		return this.bitmap;
	}

	public void retain() {
		synchronized (lock) {
			++refCount;
		}
	}

	public void release() {
		synchronized (lock) {
			--refCount;
			if (refCount <= 0 && bitmap != null) {
				Log.d(TAG, "recycle bitmap " + this);
				bitmap.recycle();
			}
		}
	}
}
