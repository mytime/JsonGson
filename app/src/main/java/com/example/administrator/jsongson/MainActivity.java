package com.example.administrator.jsongson;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.administrator.jsongson.adapter.BookListAdapter;
import com.example.administrator.jsongson.bean.Book;
import com.example.administrator.jsongson.bean.Tag;
import com.google.gson.Gson;

import java.util.ArrayList;

/**
 * Gson的基本用发
 *
 * 数据地址：https://api.douban.com/v2/book/1220562
 *
 */
public class MainActivity extends AppCompatActivity {

    private String url = "https://api.douban.com/v2/book/1220562";
    private ListView lv;
    private BookListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv = (ListView) findViewById(R.id.lv);
        getData();//请求数据方法
    }

    public void getData() {

        StringRequest request = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                //1 输出数据，查看格式
                Log.i("info",s);

                //2 解析数据
                dealData(s);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {

            }
        });
        //请求加入volley队列
        new Volley().newRequestQueue(getApplicationContext()).add(request);
    }

    private void dealData(String result) {
        //1 创建Gson对象
        Gson gson = new Gson();
        //2 把json数据解析成实体
        Book book = gson.fromJson(result,Book.class);
        //3 查看解析的结果
        Log.i("info","书名："+book.getTitle()+","+"出版社："+book.getPublisher()+","+"标签:"+book.getTags().size());

        //解析Tags数组
        ArrayList<Tag> tags = gson.fromJson(9:35)




    }
}
