package org.chzz.test;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import org.chzz.test.ui.activity.ActivityActivity;
import org.chzz.test.ui.activity.BaseActivity;
import org.chzz.test.ui.activity.FileActivity;
import org.chzz.test.ui.activity.MemoryActivity;
import org.chzz.test.ui.activity.rxandroid.RxAndroidMainActivity;

public class MainActivity extends BaseActivity {

    private Button mActivity,mFile,mMemory,mRxAndroid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mActivity = (Button) findViewById(R.id.but_activity);
        mFile = (Button) findViewById(R.id.but_File);
        mMemory= (Button) findViewById(R.id.but_Memory);
        mRxAndroid= (Button) findViewById(R.id.but_rxAndroid);
        setListener();
    }

    @Override
    protected void setListener() {
        mActivity.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.but_activity:
                Intent _activity = new Intent(this, ActivityActivity.class);
                startActivity(_activity);
                break;
            case R.id.but_File:
                Intent _file = new Intent(this, FileActivity.class);
                startActivity(_file);
                break;
            case R.id.but_Memory:
                Intent _memory = new Intent(this, MemoryActivity.class);
                startActivity(_memory);
                break;
            case R.id.but_rxAndroid:
                Intent _rxAndroid = new Intent(this, RxAndroidMainActivity.class);
                startActivity(_rxAndroid);
                break;
        }
    }
}
