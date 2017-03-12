package ch.ralena.musicmachine;

import android.os.Looper;

/**
 * Created by crater-windoze on 3/7/2017.
 */

public class DownloadThread extends Thread {
	private static final String TAG = DownloadThread.class.getSimpleName();

	public DownloadHandler mHandler;

	@Override
	public void run() {
		Looper.prepare();
		mHandler = new DownloadHandler();
		Looper.loop();
	}



}
