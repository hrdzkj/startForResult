package com.hrdzkj.startforresultsample;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by LiuYi on 2018/11/22.
 */
public class ToActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_to);
        findViewById(R.id.textResult).setOnClickListener(view -> {
            Intent intent = new Intent();
            intent.putExtra("key","value");
            setResult(88, intent);
            finish();
        });

        findViewById(R.id.textNormalFinish).setOnClickListener(view -> finish());
    }
}
