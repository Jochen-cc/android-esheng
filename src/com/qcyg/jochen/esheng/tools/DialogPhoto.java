package com.qcyg.jochen.esheng.tools;

import com.qcyg.jochen.esheng.R;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class DialogPhoto implements OnClickListener {
	private static DialogPhoto dialog;// �Զ��嵯�������
	Context context;// �����Ķ���
	int type;// �������ͣ�0����ȡ����1����ȡ����
	Idialog idialog;// ȷ��ִ�ж���
	String msg;// ��ʾ��Ϣ
	Dialog myDialog;
	String titletext;

	/**
	 * ����DialogUtil����
	 * 
	 * @param context
	 *            �����Ķ���
	 * @param type
	 *            ����
	 * @param idialog
	 *            �ص��ӿ�
	 */
	private DialogPhoto(Context context, Idialog idialog, String titletext) {
		this.context = context;
		this.idialog = idialog;
		this.titletext = titletext;
	}

	/**
	 * ����DialogUtil����������ʾ
	 * 
	 * @param context
	 *            �����Ķ���
	 * @param type
	 *            ����,ע���������Ϊ0����ȡ����ť��1��Ϊ��ȡ����ť
	 * @param idialog
	 *            �ص��ӿ�
	 */

	public static void showDialog(Context context, Idialog idialog,
			String titletext) {
		dialog = new DialogPhoto(context, idialog, titletext);
		dialog.initDialog();
	}

	/**
	 * ȷ����ť
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

		cancel.setText("ȡ��");
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
