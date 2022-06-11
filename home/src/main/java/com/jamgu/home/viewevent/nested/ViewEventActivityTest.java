package com.jamgu.home.viewevent.nested;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jamgu.home.R;

import java.util.ArrayList;
import java.util.List;

/**
 * https://mp.weixin.qq.com/s/2HJOiezhc4nkvF8AquBJcA?from=singlemessage&scene=1&subscene=10000&clicktime=1654855124&enterid=1654855124&sessionid=0&ascene=1&fasttmpl_type=0&fasttmpl_fullversion=6191257-zh_CN-zip&fasttmpl_flag=0&realreporttime=1654855124132
 */
public class ViewEventActivityTest extends AppCompatActivity {

    private static final String TAG = "ViewEventActivityTest";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_event_test);

        RecyclerView recyclerView = findViewById(R.id.vRecycler2);
        RecyclerView recyclerView2 = findViewById(R.id.vRecycler3);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView2.setLayoutManager(new LinearLayoutManager(this));
        List<String> data = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            data.add(String.valueOf(i));
        }
        recyclerView.setAdapter(new HomeAdapter(this, data));
        recyclerView2.setAdapter(new HomeAdapter(this, data));
    }

    class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.MyViewHolder> {

        private List<String> mDatas;
        private LayoutInflater mInflater;


        public HomeAdapter(Context context, List<String> datas) {
            mInflater = LayoutInflater.from(context);
            mDatas = datas;
        }

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            MyViewHolder holder = new MyViewHolder(mInflater.inflate(R.layout.item_home, parent, false));
            return holder;
        }

        @Override
        public void onBindViewHolder(final MyViewHolder holder, final int position) {
            Log.i(TAG, "========onBindViewHolder==============" + position);
            holder.tv.setText(mDatas.get(position));
        }

        @Override
        public int getItemCount() {
            return mDatas.size();
        }

        class MyViewHolder extends RecyclerView.ViewHolder {

            TextView tv;

            public MyViewHolder(View view) {
                super(view);
                tv = (TextView) view.findViewById(R.id.id_num);
            }
        }
    }
}