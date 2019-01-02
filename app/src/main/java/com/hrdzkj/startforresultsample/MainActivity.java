package com.hrdzkj.startforresultsample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;

import com.hrdzkj.startforresult.StartForResultUtil;

public class MainActivity extends FragmentActivity {
   private final static String TAG = MainActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.startForResult).setOnClickListener(view -> {
            StartForResultUtil.getInstance(MainActivity.this)
                    .startForResultWithCallback(new Intent(MainActivity.this,ToActivity.class), (resultCode, data) -> {
                Log.v(TAG,"---------->StartForResultresultCode="+resultCode);
            });
        });

        findViewById(R.id.normalGo).setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this,ToActivity.class);
            startActivityForResult(intent,0x003);
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.v(TAG,"---------->onActivityResult resultCode="+resultCode);
    }
}
