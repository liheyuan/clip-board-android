package com.coder4.clipboard.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.coder4.clipboard.R;
import com.coder4.clipboard.model.Msg;
import com.coder4.clipboard.store.MsgStore;

/**
 * Created by lihy on 15/10/13.
 */
public class MsgListAdapter extends BaseAdapter {
    LayoutInflater inflater = null;

    public MsgListAdapter(LayoutInflater inflater){
        super();
        this.inflater = inflater;
        MsgStore.getStore().AddAdapter(this);
    }

    @Override
    public int getCount() {
        return MsgStore.getStore().Size();
    }

    @Override
    public Msg getItem(int position) {
        return MsgStore.getStore().Get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            convertView = inflater.inflate(R.layout.adapter_msg, parent, false);
        }
        // Get Msg
        Msg msg = getItem(position);
        if(msg != null) {
            // set time and msg
            TextView viewMsg = (TextView) convertView.findViewById(R.id.msg);
            TextView viewTime = (TextView) convertView.findViewById(R.id.time);
            if(viewMsg != null){
                viewMsg.setText(msg.getMsg());
            }
            if(viewTime != null){
                viewTime.setText(msg.getTimestamp()+"");
            }
        }
        return convertView;
    }
}
