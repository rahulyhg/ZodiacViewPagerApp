package com.example.zodiacsigns;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.util.Log;

import com.example.zodiacsigns.Adapter.ZodiacViewPagerAdapter;
import com.example.zodiacsigns.Fragment.ZodiacDisplayFragment;
import com.example.zodiacsigns.Model.ZodiacOuterClass;
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
List<Fragment> fragmentList = new LinkedList<>();
        RetrofitSingleton.getInstance()
                .create(ZodiacService.class)
                .getZodiacSigns()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((ZodiacOuterClass zodiacOuterClass) -> {
                    Log.d(TAG, "OnResponse:" + zodiacOuterClass.getZodiacList().get(0).getZodiacName());
                    final ViewPager viewPager = findViewById(R.id.main_viewpager);

                    for (ZodiacSign zodiacSign : zodiacOuterClass.getZodiacList()) {
                        fragmentList.add(ZodiacDisplayFragment.getInstance(zodiacSign.getZodiacName(),
                                zodiacSign.getZodiacDateRange(),
                                zodiacSign.getZodiacImage()));
                    }
                    viewPager.setAdapter(new ZodiacViewPagerAdapter(getSupportFragmentManager(), fragmentList));
                });


    }
}
