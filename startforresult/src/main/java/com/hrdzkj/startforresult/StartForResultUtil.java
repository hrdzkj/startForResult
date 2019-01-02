package com.hrdzkj.startforresult;

import android.app.Activity;
import android.os.Build;
import android.support.v4.app.FragmentActivity;

/**
 * 用于返回一个实现IStartForResultWithCallback的实现者
 */

public class StartForResultUtil {
    private static final String TAG = StartForResultUtil.class.getSimpleName();


    public static IStartForResult.IStartForResultWithCallback getInstance(Activity activity) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) { // Android 6.0以前
             return getLowApiImplement(activity);
        }

        if (activity instanceof FragmentActivity)
            return  getFragmentActivityImplement((FragmentActivity)activity);
        else {
            return  getLowApiImplement(activity);
        }

    }

    private static IStartForResult.IStartForResultWithCallback getLowApiImplement(Activity activity)
    {
        StartForResultLowApiImp implement = (StartForResultLowApiImp) activity.getFragmentManager().findFragmentByTag(TAG);
        if (implement == null) {
            implement = new StartForResultLowApiImp();
            android.app.FragmentManager fragmentManager = activity.getFragmentManager();
            fragmentManager
                    .beginTransaction()
                    .add(implement, TAG)
                    .commitAllowingStateLoss();
            fragmentManager.executePendingTransactions();
        }
        return implement;
    }


    private static IStartForResult.IStartForResultWithCallback getFragmentActivityImplement(FragmentActivity fragmentActivity){
        StartForResultFragmentActivityImp implement = (StartForResultFragmentActivityImp) fragmentActivity.getSupportFragmentManager().findFragmentByTag(TAG);
        if (implement == null) {
            implement = new StartForResultFragmentActivityImp();
            android.support.v4.app.FragmentManager fragmentManager = fragmentActivity.getSupportFragmentManager();
            fragmentManager
                    .beginTransaction()
                    .add(implement, TAG)
                    .commitAllowingStateLoss();
            fragmentManager.executePendingTransactions();
        }
        return implement;
    }


}
