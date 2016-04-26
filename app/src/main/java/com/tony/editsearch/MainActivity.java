package com.tony.editsearch;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.tony.editsearch.adapter.UserAdapter;
import com.tony.editsearch.entity.User;
import com.tony.editsearch.widget.ClearEditText;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ClearEditText et_search;
    private ListView user_list;

    private String[] data;
    private ArrayAdapter<String> mAdapter;

    private List<User> mDatas = new ArrayList<>();
    private UserAdapter mUserAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initData();
        initView();
    }

    private void initData() {
        data = new String[]{"张无忌", "周芷若", "赵敏", "东方不败", "令狐冲", "上官婉儿",
                "纳兰容若", "张李丹妮", "任盈盈"};

        User user1 = new User(R.drawable.head, "张无忌");
        mDatas.add(user1);
        User user2 = new User(R.drawable.head, "周芷若");
        mDatas.add(user2);
        User user3 = new User(R.drawable.head, "赵敏");
        mDatas.add(user3);
        User user4 = new User(R.drawable.head, "东方不败");
        mDatas.add(user4);
        User user5 = new User(R.drawable.head, "令狐冲");
        mDatas.add(user5);
        User user6 = new User(R.drawable.head, "上官婉儿");
        mDatas.add(user6);
        User user7 = new User(R.drawable.head, "纳兰容若");
        mDatas.add(user7);
        User user8 = new User(R.drawable.head, "张李丹妮");
        mDatas.add(user8);
        User user9 = new User(R.drawable.head, "任盈盈");
        mDatas.add(user9);
        User user10 = new User(R.drawable.head, "绝无神");
        mDatas.add(user10);
    }

    private void initView() {
        et_search = (ClearEditText) findViewById(R.id.et_search);
        user_list = (ListView) findViewById(R.id.user_list);

        initListView();
        intiEditView();
    }

    private void intiEditView() {
        et_search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
//                mAdapter.getFilter().filter(s);

                mUserAdapter.getFilter().filter(s);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    private void initListView() {
//        mAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, data);
//        user_list.setAdapter(mAdapter);

        mUserAdapter = new UserAdapter(MainActivity.this,mDatas);
        user_list.setAdapter(mUserAdapter);
    }
}
