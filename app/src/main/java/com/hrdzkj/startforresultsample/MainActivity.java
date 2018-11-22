package com.hrdzkj.startforresultsample;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.hrdzkj.startforresult.StartForResultUtil;

public class MainActivity extends Activity {
   private final static String TAG = MainActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.startForResult).setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this,ToActivity.class);
            StartForResultUtil.getInstance(MainActivity.this)
                    .startForResultWithCallback(new Intent(MainActivity.this,ToActivity.class), (resultCode, data) -> {
                Log.v(TAG,"---------->StartForResultresultCode="+resultCode);
            });
        });

        findViewById(R.id.normalGo).setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this,ToActivity.class);
            startActivityForResult(intent,0x99);
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.v(TAG,"---------->onActivityResult resultCode="+resultCode);
    }
}
