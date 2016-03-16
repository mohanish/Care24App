package com.care24;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.care24.databinding.DataRowBindBinding;

import java.util.List;

import care24.com.core.model.model.DataEntity;


/**
 * Created by mohanish on 3/15/16.
 */
public class DataModelAdaper extends RecyclerView.Adapter<DataModelAdaper.DataViewHolder> {

    private List<DataEntity> dataEntityList;


    public DataModelAdaper(List<DataEntity> dataEntities) {
        this.dataEntityList = dataEntities;
    }

    @Override
    public DataViewHolder onCreateViewHolder(ViewGroup parent, int type) {
        DataRowBindBinding dataRowBindBinding = DataBindingUtil.bind(LayoutInflater.from(parent.getContext()).inflate(R.layout.data_row_bind, parent, false));
        DataViewHolder holder = new DataViewHolder(dataRowBindBinding);
        return holder;
    }

    @Override
    public void onBindViewHolder(DataViewHolder holder, int position) {
        final DataEntity dataEntity = dataEntityList.get(position);
        ((DataViewHolder)holder).getBinding().setVariable(com.care24.BR.datamodel, dataEntity);
        ((DataViewHolder)holder).getBinding().executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return (null != dataEntityList ? dataEntityList.size() : 0);
    }

    static class DataViewHolder extends RecyclerView.ViewHolder {

        private DataRowBindBinding binding;

        public DataViewHolder(DataRowBindBinding itemView) {
            super(itemView.getRoot());
            this.binding = itemView;
        }

        public DataRowBindBinding getBinding() {
            return binding;
        }
    }
}
