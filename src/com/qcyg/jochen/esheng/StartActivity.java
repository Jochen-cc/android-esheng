package com.qcyg.jochen.esheng;

import java.util.Timer;
import java.util.TimerTask;

import com.qcyg.jochen.esheng.leading.LeadActivity;
import com.qcyg.jochen.esheng.progressBar.NumberProgressBar;

import android.os.Bundle;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;

public class StartActivity extends ActionBarActivity {
	private int counter = 0;
	private Timer timer;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_start);

		final NumberProgressBar bnp = (NumberProgressBar) findViewById(R.id.numberbar);
		counter = 0;
		timer = new Timer();
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				runOnUiThread(new Runnable() {
					@Override
					public void run() {
						bnp.incrementProgressBy(1);
						counter++;
						if (counter == 110) {
							Intent mIntent = new Intent();
							mIntent.setClass(StartActivity.this,
									LeadActivity.class);
							startActivity(mIntent);
							finish();
							// bnp.setProgress(0);
							// counter = 0;
						}
					}
				});
			}
		}, 1000, 100);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		timer.cancel();
	}
}
