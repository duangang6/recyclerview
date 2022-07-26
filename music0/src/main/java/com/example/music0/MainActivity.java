package com.example.music0;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.music0.R;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<HashMap<String, Object>> list;
    int[] imgs={R.drawable.test1,R.drawable.test2,R.drawable.test3,R.drawable.test4,R.drawable.test5,R.drawable.test6,R.drawable.test7,R.drawable.test8,R.drawable.test9,R.drawable.test10};
    String[] titles={"天后","下一站","雾里看花","爱拼","最后一首歌","刘德华",
            "刘德华","刘德华","刘德华","刘德华"};
    String[] infos={"王菲","张学友","金瑾","刘德华","刘德华","刘德华",
            "刘德华","刘德华","刘德华","刘德华"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //获取RecyclerView控件给recyclerView变量
        recyclerView = findViewById(R.id.rv);
        //创建/填充模板链表list
        initData();

        // 布局管理器
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        // 将布局设置为线性布局
        recyclerView.setLayoutManager(layoutManager);

        /*GridLayoutManager girdLayoutManager=new GridLayoutManager(this,2);
        // 将布局设置为格点布局
        recyclerView.setLayoutManager(girdLayoutManager);*/
       /* StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);*/

        // 创建一个适配器类为list，其中RecyclerViewAdapter继承于RecyclerView.Adapter<RecyclerView.ViewHolder>，其有三个自带方法。
        RecyclerViewAdapter adapter =   new RecyclerViewAdapter(this,list);
        recyclerView.setAdapter(adapter);

//        adapter.setOnItemClickListener(new RecyclerViewAdapter.OnItemClickListener() {
//            // 点击跳转界面
//            public void onItemClick(View view, int position) {
//                Toast.makeText(MainActivity.this, "click " + position, Toast.LENGTH_SHORT).show();
//
//                Intent intent =  new Intent(MainActivity.this, music.class);
//                startActivityForResult(intent, 0);
//
//            }
//        });

    }

    private void initData() {
        list = new ArrayList<>();

        for (int i = 0; i < imgs.length; i++) {
            HashMap<String, Object> map = new HashMap<>();
            map.put("img", imgs[i] );
            map.put("title", titles[i]);
            map.put("info", infos[i]);
            list.add(map);
        }

    }
}