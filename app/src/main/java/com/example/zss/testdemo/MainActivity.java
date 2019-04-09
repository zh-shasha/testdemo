package com.example.zss.testdemo;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {
    private TestFragment testFragment;
    private Button btn;
    private FrameLayout frameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        frameLayout = (FrameLayout) findViewById(R.id.fraglayout);
        btn = (Button) findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                btn.setVisibility(View.GONE);
                TestFragment testFragment = new TestFragment();
                Bundle bundle = new Bundle();
                bundle.putString("data", "5");
                testFragment.setArguments(bundle);//数据传递到fragment中

                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction transaction = fm.beginTransaction();
                if (testFragment == null) {
                    testFragment = new TestFragment();
                }
                transaction.replace(R.id.fraglayout, testFragment);
                transaction.commit();
//                transaction.detach(testFragment);

            }
        });

        Intent intent = getIntent();
        //从Intent当中根据key取得value
        if (intent != null) {
            String btn = intent.getStringExtra("text");
        }
    }
}
