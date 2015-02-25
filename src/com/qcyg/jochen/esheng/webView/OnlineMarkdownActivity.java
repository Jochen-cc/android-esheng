package com.qcyg.jochen.esheng.webView;
import com.qcyg.jochen.esheng.widget.markdown.MarkdownView;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

public class OnlineMarkdownActivity extends Activity {
	@Override 
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE); 
		MarkdownView markdownView = new MarkdownView(this); 
		setContentView(markdownView);
		markdownView.loadMarkdownFile("https://raw.github.com/falnatsheh/MarkdownView/master/README.md");
	}
}
 