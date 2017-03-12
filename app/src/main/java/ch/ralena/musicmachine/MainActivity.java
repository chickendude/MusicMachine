package ch.ralena.musicmachine;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

	private static final String TAG = MainActivity.class.getSimpleName();
	public static final String KEY_SONG = "key_song";

	private Button mDownloadButton;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		mDownloadButton = (Button) findViewById(R.id.downloadButton);
		mDownloadButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Toast.makeText(MainActivity.this, "Downloading...", Toast.LENGTH_SHORT).show();

				// Send messages to handler for processing

				for (String song : Playlist.songs) {
					Intent intent = new Intent(MainActivity.this, DownloadService.class);
					intent.putExtra(KEY_SONG, song);
					startService(intent);
				}
			}
		});
	}
}
