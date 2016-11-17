package com.sds.study.recordapp.record;

import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.sds.study.recordapp.R;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by CANET on 2016-11-17.
 */

public class ListFragment extends Fragment implements AdapterView.OnItemClickListener{

    String TAG=this.getClass().getName();
    String fileName;

    ListView listView;

    ArrayAdapter<String> adapter;
    ArrayList<String> list = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){

        View view = inflater.inflate(R.layout.fragment_list, null);

        listView = (ListView) view.findViewById(R.id.listView);

        list = (ArrayList<String>) getFiles();

        adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, list);

        listView.setAdapter(adapter);           //  껍데기와 연결
        listView.setOnItemClickListener(this);      //  ListView와 리스너 연결

        return view;

    }

    //  외부 저장소인 IOTRecord 디렉토리의 모든 파일 가져오기
    public List<String> getFiles(){

        File dir = new File( Environment.getExternalStorageDirectory(), "IOTRecord");

        File[] files = dir.listFiles();

        ArrayList<String> fileNameList = new ArrayList<>();

        for( int a=0 ; a<files.length ; a++ ){

            fileNameList.add(files[a].getName());

            Log.d( TAG, "파일이름은 "+files[a].getName());

        }

        return fileNameList;

    }

    //  adapterView는 ListView나 Spinner, GridView 등을 담는다. View는 내가 클릭한 item, index는 item의 번호, id는 item의 id
    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int index, long id){

        TextView textView = (TextView) view;
        fileName = textView.getText().toString();

        Toast.makeText(getContext(), "파일명은 " + fileName, Toast.LENGTH_SHORT).show();

        //  ViewPager 중 index1(2번째 페이지) 에 해당하는 DetailFragment 보여주기
        FileListActivity fileListActivity = (FileListActivity) getContext();

        ((FileListActivity) getContext()).getParent();

        Log.d( TAG, "주소값 비교 : "+fileListActivity);
        fileListActivity.viewPager.setCurrentItem(1);

    }

}
