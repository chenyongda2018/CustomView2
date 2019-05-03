package example.chen.com.customview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import example.chen.com.customview.activity.CustomView1Activity;

public class MainActivity extends AppCompatActivity {

    RecyclerView mRecyclerView;
    ActivityListAdapter mActivityListAdapter;
    private ArrayList<ActivityItem> mActivities = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();

        mRecyclerView = findViewById(R.id.custom_view_list_view);
        mActivityListAdapter = new ActivityListAdapter(this, mActivities);
        LinearLayoutManager manager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        mRecyclerView.setAdapter(mActivityListAdapter);
        mRecyclerView.setLayoutManager(manager);
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        mActivityListAdapter.setListener(new ActivityListAdapter.onActivityItemClick() {
            @Override
            public void onClick(int position) {
                ActivityItem activityItem = mActivities.get(position);
                try {
                    Intent intent = new Intent(MainActivity.this, Class.forName(activityItem.getActivityClass()));
                    startActivity(intent);
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }

            }
        });
    }

    private void initData() {
        mActivities.add(new ActivityItem("example.chen.com.customview.activity.CustomView1Activity", "Canvas Rotate"));
        mActivities.add(new ActivityItem("example.chen.com.customview.activity.CustomView2Activity", "Pie chart"));
        mActivities.add(new ActivityItem("example.chen.com.customview.activity.CustomView3Activity", "Canvas Scale"));
    }
}
