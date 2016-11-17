package com.sds.study.recordapp.record;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**

    ViewPager는 무조건 슬라이딩 되므로 그 기능을 막아버리기

 */

public class MyViewPager extends ViewPager{

    //  자바코드로
    public MyViewPager(Context context){

        super(context);
    }

    //  xml로
    public MyViewPager(Context context, AttributeSet attrs){

        super(context, attrs);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev){

        return false;

    }

}
