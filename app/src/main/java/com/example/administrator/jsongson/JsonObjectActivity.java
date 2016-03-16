package com.example.administrator.jsongson;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.administrator.jsongson.adapter.TagListAdapter;
import com.example.administrator.jsongson.bean.Tag;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;


/**
 * Gson的基本用发
 *
 * 数据地址：https://api.douban.com/v2/book/1220562
 *
 * 解析二级节点,json object
 *
 */
public class JsonObjectActivity extends AppCompatActivity {

    private ListView lv;
    private String url = "https://api.douban.com/v2/book/1220562";
    private TagListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_array_list);
        lv = (ListView) findViewById(R.id.lv);
        getData();//获取数据
    }

    public void getData() {
        StringRequest request = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                Log.i("info",s); //输出请求结果
                try {
                    dealData(s);//解析数据
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {

            }
        });
        //把请求加入volley对列
        Volley.newRequestQueue(getApplicationContext()).add(request);
    }

    private void dealData(String s) throws JSONException {
        Gson gson = new Gson();
        Type listType = new TypeToken<ArrayList<Tag>>(){
        }.getType();
        JSONObject object = new JSONObject(s);
        //tags ： 解析出来的JsonObject
        ArrayList<Tag> tags = gson.fromJson(object.getString("tags"),listType);

        //实例化adapter
        adapter = new TagListAdapter(this,tags);
        lv.setAdapter(adapter);

    }
}
