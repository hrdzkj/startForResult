package com.hrdzkj.startforresult;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import java.util.HashMap;
import java.util.Map;



public class StartForResultLowApiImp extends Fragment implements IStartForResult.IStartForResultWithCallback {
    @SuppressLint("UseSparseArrays")
    private Map<Integer, IStartForResult.ICallback> mCallbacks = new HashMap<>();
    private String TAG = StartForResultLowApiImp.class.getSimpleName();

    private int LAST_REQUEST_CODE = 0;


    private int makeRequestCode()
    {
        LAST_REQUEST_CODE++;
        if (LAST_REQUEST_CODE>65535){
            LAST_REQUEST_CODE=1;
        }
        return LAST_REQUEST_CODE;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }


    @Override
    public void onDestroy() {
        mCallbacks.clear();
        super.onDestroy();

    }



    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //callback方式的处理
        IStartForResult.ICallback callback; // remove了
        callback = mCallbacks.remove(requestCode);
        if (callback != null) {
            callback.onCallBack(resultCode, data);
        }
    }


    @Override
    public void startForResultWithCallback(Intent intent, IStartForResult.ICallback callback) {
        int requestCode = makeRequestCode();
        //mCallbacks.clear();
        mCallbacks.put(requestCode, callback);
        startActivityForResult(intent,requestCode);
    }
}
