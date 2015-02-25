package com.qcyg.jochen.esheng.webView;

import com.qcyg.jochen.esheng.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class WebViewActivity extends Activity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_webview);
	}

	public void displayDataActivity(View view) {
		this.startActivity(new Intent(this, MarkdownDataActivity.class));
	}

	public void displayThemesActivity(View view) {
		this.startActivity(new Intent(this, MarkdownThemesActivity.class));
	}

	public void displayOnlineMdActivity(View view) {
		this.startActivity(new Intent(this, OnlineMarkdownActivity.class));
	}

	public void displayLocalMdFileActivity(View view) {
		this.startActivity(new Intent(this, LocalMarkdownActivity.class));
	}
}
