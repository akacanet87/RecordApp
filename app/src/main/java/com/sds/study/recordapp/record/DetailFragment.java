package com.sds.study.recordapp.record;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.sds.study.recordapp.R;

import java.util.List;

/**
 * Created by CANET on 2016-11-17.
 */

public class DetailFragment extends Fragment implements View.OnClickListener{

    ListFragment fragment;
    TextView fileNameView;
    ImageView btnPlay, disc;

    String fileName;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){

        View view = inflater.inflate(R.layout.fragment_detail, null);

        fileNameView = (TextView) view.findViewById(R.id.fileName);
        btnPlay = (ImageView) view.findViewById(R.id.play);
        disc = (ImageView) view.findViewById(R.id.disc);

        //  페이지를 구성하는 나 아닌 다른 페이지 프레그먼트를 접근해보기
        FragmentManager manager = this.getFragmentManager();

        List<Fragment> list = manager.getFragments();

        fragment = (ListFragment) list.get(0);

        fileName = fragment.fileName;

        return view;

    }

    public void play(){

        Animation animation = AnimationUtils.loadAnimation(getContext(), R.anim.disc);

        //  안드로이드에서 에니매이션의 대상이 되는 주체는 모든 뷰이다.
        disc.startAnimation(animation);

    }

    @Override
    public void onClick(View view){

        if( view.equals(btnPlay)){

            Toast.makeText(getContext(), "시작", Toast.LENGTH_SHORT).show();
            play();

        }

    }

}
