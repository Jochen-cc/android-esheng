package com.qcyg.jochen.esheng.webView;

import com.qcyg.jochen.esheng.widget.markdown.MarkdownView;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

public class LocalMarkdownActivity extends Activity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		MarkdownView webView = new MarkdownView(this);
		setContentView(webView);
		webView.loadMarkdownFile("file:///android_asset/hello.md");
	}
}
