package com.example.zodiacsigns;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.util.Log;

import com.example.zodiacsigns.Model.ZodiacList;
import com.example.zodiacsigns.Model.ZodiacSign;
import com.example.zodiacsigns.Service.RetrofitSingleton;
import com.example.zodiacsigns.Service.ZodiacService;

import java.util.LinkedList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends FragmentActivity {
private static final String TAG = "MainActivity";

    @SuppressLint("CheckResult")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RetrofitSingleton.getInstance()
                .create(ZodiacService.class)
                .getZodiacSigns()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((ZodiacList zodiacList) -> {
            Log.d(TAG, "OnResponse:" + zodiacList.getZodiacList().get(0).getZodiacName() );

            List<Fragment> fragmentList = new LinkedList<>();
            for(ZodiacSign zodiacSign: zodiacList.getZodiacList()){
//                fragmentList.add(ViewpagerFragment.newInstance);
            }});


    }
}
