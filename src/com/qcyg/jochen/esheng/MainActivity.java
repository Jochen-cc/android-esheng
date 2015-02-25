package com.qcyg.jochen.esheng;

import com.qcyg.jochen.esheng.widget.xlist.XListView;
import com.qcyg.jochen.esheng.widget.xlist.XListView.IXListViewListener;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity implements IXListViewListener {

	private XListView main_xlist;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initListView();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	private void initListView() {
		main_xlist = (XListView) findViewById(R.id.main_xlist);
		main_xlist.setXListViewListener(this);
		main_xlist.setPullLoadEnable(false);
		main_xlist.hideFooterLine();
		main_xlist.setOverScrollMode(View.OVER_SCROLL_NEVER);
		// main_xlist.setImageFetcher(mImageFetcher);
		// adapter = new SecurityAdapter(MineSecurityActivity.this, listModel,
		// security_mark, handler, mImageFetcher);
		main_xlist.setAdapter(null);
	}
	
	@Override
	public void onRefresh() {
		// TODO Auto-generated method stub
		/**
		 * 下拉刷新
		 */
	}

	@Override
	public void onLoadMore() {
		// TODO Auto-generated method stub
		/**
		 * 加载更多
		 */
	}

}
