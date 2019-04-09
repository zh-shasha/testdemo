package com.example.zss.testdemo;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class TestFragment extends Fragment {
    private TextView tv;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_test, container, false);
        tv=(TextView)view.findViewById(R.id.tv1);
        //界面传值5s
        Bundle bundle =this.getArguments();//得到从Activity传来的数据
        String mess = null;
        if(bundle!=null){
            mess = bundle.getString("data");
        }
        tv.setText(mess);
        MyCountTimer myCountTimer = new MyCountTimer(6000, 1000, tv, "");
        myCountTimer.start();


        Intent intent=new Intent(getContext(),MainActivity.class);
        intent.putExtra("text1","结束");
        startActivity(intent);

        return view;

    }

}
