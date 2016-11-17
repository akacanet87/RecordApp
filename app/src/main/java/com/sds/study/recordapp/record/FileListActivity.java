package com.sds.study.recordapp.record;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.sds.study.recordapp.R;

/**

    녹음으로 생성된 파일을 목록으로 보여주고 해당 파일을 선택하면 재생시키기

 */

public class FileListActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener{

    String TAG;

    ViewPager viewPager;
    RecordPagerAdapter pagerAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState){

        TAG = this.getClass().getName();

        super.onCreate(savedInstanceState);

        setContentView(R.layout.filelist_layout);

        viewPager = (ViewPager) findViewById( R.id.viewPager);
        pagerAdapter = new RecordPagerAdapter(getSupportFragmentManager());

        viewPager.setAdapter(pagerAdapter);
        viewPager.addOnPageChangeListener(this);

        Log.d( TAG, "주소값 비교 : "+this);

    }

    //  페이지가 선택이 확정되면 (commit)
    @Override
    public void onPageSelected(int position){

        ListFragment listFragment =(ListFragment) pagerAdapter.fragments[0];
        DetailFragment detailFragment =(DetailFragment) pagerAdapter.fragments[1];
        detailFragment.fileNameView.setText(listFragment.fileName);

    }

    @Override
    public void onPageScrollStateChanged(int state){

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels){

    }

}
