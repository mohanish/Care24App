package com.care24;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.care24.utils.DividerItemDecoration;

import java.util.List;

import care24.com.core.model.IregisterResponse;
import care24.com.core.model.dbutils.DbManager;
import care24.com.core.model.model.DataEntity;
import care24.com.core.model.request.DataModelRequest;

public class MainActivity extends AppCompatActivity implements IregisterResponse {

    private static final String TAG = MainActivity.class.getSimpleName();
    private DataModelRequest dataRquestBuilder;
    private RecyclerView mDataRecyclerView;
    private DataModelAdaper mDataModelAdaper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        DataBindingUtil.setContentView(this, R.layout.activity_main);

        initUI();

        loadData();

    }

    private void initUI() {
        mDataRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mDataRecyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        mDataRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mDataRecyclerView.setLayoutManager(linearLayoutManager);
        mDataRecyclerView.setHasFixedSize(true);
    }

    private void setDataAdapter(List<DataEntity> dataEntityList) {
        if (null == mDataModelAdaper) {
            mDataModelAdaper = new DataModelAdaper(dataEntityList);
            mDataRecyclerView.setAdapter(mDataModelAdaper);
        }
    }

    private void loadData() {
        dataRquestBuilder = new DataModelRequest();
        if (!canLoadDataFromDB()) {
            dataRquestBuilder.getData(TAG);
        }
    }

    private boolean canLoadDataFromDB() {
        List<DataEntity> dataEntityList = DbManager.getAll();

        if (null != dataEntityList && !dataEntityList.isEmpty()) {
            setDataAdapter(dataEntityList);
            return true;
        }

        return false;
    }

    @Override
    protected void onResume() {
        super.onResume();
        dataRquestBuilder.registerResponse(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        dataRquestBuilder.unRegisterRespoonse();
    }

    @Override
    public void registerResponse() {
        loadData();
    }

    @Override
    public void unRegisterRespoonse() {

    }
}
