package com.qcyg.jochen.esheng.tools;

import com.qcyg.jochen.esheng.R;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class DialogPhoto implements OnClickListener {
	private static DialogPhoto dialog;// 自定义弹出框对象
	Context context;// 上下文对象
	int type;// 弹框类型（0、无取消框，1、有取消框）
	Idialog idialog;// 确定执行动作
	String msg;// 提示信息
	Dialog myDialog;
	String titletext;

	/**
	 * 构造DialogUtil对象
	 * 
	 * @param context
	 *            上下文对象
	 * @param type
	 *            类型
	 * @param idialog
	 *            回调接口
	 */
	private DialogPhoto(Context context, Idialog idialog, String titletext) {
		this.context = context;
		this.idialog = idialog;
		this.titletext = titletext;
	}

	/**
	 * 构造DialogUtil单例对象并显示
	 * 
	 * @param context
	 *            上下文对象
	 * @param type
	 *            类型,注：如果类型为0，无取消按钮，1、为有取消按钮
	 * @param idialog
	 *            回调接口
	 */

	public static void showDialog(Context context, Idialog idialog,
			String titletext) {
		dialog = new DialogPhoto(context, idialog, titletext);
		dialog.initDialog();
	}

	/**
	 * 确定按钮
	 */
	private void initDialog() {
		myDialog = new Dialog(context, R.style.dialog);
		myDialog.setContentView(R.layout.common_photo_dialog);
		myDialog.setCanceledOnTouchOutside(false);
		TextView title = (TextView) myDialog.findViewById(R.id.title);
		TextView photos = (TextView) myDialog.findViewById(R.id.photos);
		TextView camera = (TextView) myDialog.findViewById(R.id.camera);
		TextView cancel = (TextView) myDialog.findViewById(R.id.cancel);
		title.setText(titletext);

		cancel.setText("取消");
		myDialog.show();
		photos.setOnClickListener(this);
		camera.setOnClickListener(this);
		cancel.setOnClickListener(this);
	}

	public interface Idialog {
		public void doPhotosClicked();

		public void doCameraClicked();
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.photos:
			idialog.doPhotosClicked();
			myDialog.dismiss();
			break;
		case R.id.camera:
			idialog.doCameraClicked();
			myDialog.dismiss();
			break;
		case R.id.cancel:
			myDialog.dismiss();
			break;
		default:
			break;
		}
	}
}
