package com.qcyg.jochen.esheng.app;

import java.util.List;
import java.util.Stack;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.util.Log;

/**
 * 应用程序Activity管理类：用于Activity管理和应用程序退出
 */
public class AppManager {

	private static Stack<Activity> activityStack;
	private static AppManager instance;

	private AppManager() {
	}

	/**
	 * 单一实例
	 */
	public static AppManager getAppManager() {
		if (instance == null) {
			instance = new AppManager();
		}
		return instance;
	}

	/**
	 * 添加Activity到堆栈
	 */
	public void addActivity(Activity activity) {
		if (activityStack == null) {
			activityStack = new Stack<Activity>();
		}
		activityStack.add(activity);
	}

	/**
	 * 获取当前Activity（堆栈中最后一个压入的）
	 */
	public Activity currentActivity() {
		Activity activity = activityStack.lastElement();
		return activity;
	}

	/**
	 * 结束当前Activity（堆栈中最后一个压入的）
	 */
	public void finishActivity() {
		Activity activity = activityStack.lastElement();
		finishActivity(activity);
	}

	/**
	 * 结束指定的Activity
	 */
	public void finishActivity(Activity activity) {
		if (activity != null) {
			activityStack.remove(activity);
			activity.finish();
			activity = null;
		}
	}

	/**
	 * 结束指定类名的Activity
	 */
	public void finishActivity(Class<?> cls) {
		for (Activity activity : activityStack) {
			if (activity.getClass().equals(cls)) {
				finishActivity(activity);
			}
		}
	}

	/**
	 * 结束所有Activity
	 */
	public void finishAllActivity() {
		for (int i = 0, size = activityStack.size(); i < size; i++) {
			if (null != activityStack.get(i)) {
				Activity activity = activityStack.get(i);
				if (activity != null) {
					activity.finish();
					// ((IExitListener)activity).exit();
					activity = null;
				}
			}
		}
		activityStack.clear();
	}

	/**
	 * 退出应用程序
	 */
	public void AppExit(Context context) {
		try {
			finishAllActivity();
			// int currentVersion = android.os.Build.VERSION.SDK_INT;
			// ActivityManager am = (ActivityManager)
			// context.getSystemService(Context.ACTIVITY_SERVICE);
			// if (currentVersion > android.os.Build.VERSION_CODES.ECLAIR_MR1) {
			// am.killBackgroundProcesses(context.getPackageName());
			// } else {// android2.1
			// am.restartPackage(context.getPackageName());
			// }
			System.exit(0);
		} catch (Exception e) {
		}
	}

	public static boolean isBackground(Context context) {

		ActivityManager activityManager = (ActivityManager) context
				.getSystemService(Context.ACTIVITY_SERVICE);
		List<RunningAppProcessInfo> appProcesses = activityManager
				.getRunningAppProcesses();
		for (RunningAppProcessInfo appProcess : appProcesses) {
			if (appProcess.processName.equals(context.getPackageName())) {
				if (appProcess.importance == RunningAppProcessInfo.IMPORTANCE_BACKGROUND) {
					Log.i("后台", appProcess.processName);
					return true;
				} else {
					Log.i("前台", appProcess.processName);
					return false;
				}
			}
		}
		return false;
	}

//	public static void KillUnusedActivity() {
//		// Log.i("Size", AppSingleton.getInstance().listA.size() + "");
//		for (int i = AppSingleton.getInstance().listA.size() - 1; i >= 0; i--) {
//			Log.i("Activity", AppSingleton.getInstance().listA.get(i)
//					.getClass().getName());
//			AppSingleton.getInstance().listA.get(i).finish();
//			AppSingleton.getInstance().listA.remove(i);
//		}
//	}

	/**
	 * 退出其他Activity指导TAB页指定的4个Activity
	 */
//	public static void KillOtherActivity() {
//		// Log.i("Size", AppSingleton.getInstance().listA.size() + "");
//		for (int i = AppSingleton.getInstance().listA.size() - 1; i >= 0; i--) {
//			Log.i("Activity", AppSingleton.getInstance().listA.get(i)
//					.getClass().getName());
//			String name = AppSingleton.getInstance().listA.get(i).getClass()
//					.getSimpleName();
//			Log.i("otherActivity---->", name);
//			if (name.equals("HomeActivity") || name.equals("ThreadsActivity")
//					|| name.equals("OwnerActivity")
//					|| name.equals("PerimeterActivity")) {
//				return;
//			}
//			AppSingleton.getInstance().listA.get(i).finish();
//			AppSingleton.getInstance().listA.remove(i);
//		}
//	}
}