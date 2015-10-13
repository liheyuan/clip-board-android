package com.coder4.clipboard.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.coder4.clipboard.R;
import com.coder4.clipboard.adapter.MsgListAdapter;
import com.coder4.clipboard.model.Msg;
import com.coder4.clipboard.store.MsgStore;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * Created by lihy on 15/10/12.
 */
public class MsgListFragment extends BaseFragment {

    @Bind(R.id.list)
    protected ListView listView;
    @Bind(R.id.editMsg)
    protected EditText editText;
    @Bind(R.id.btnSend)
    protected Button btnSend;

    private MsgListAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = super.onCreateView(inflater, container, savedInstanceState);
        adapter = new MsgListAdapter(inflater);
        listView.setAdapter(adapter);
        return v;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_msglist;
    }

    @OnClick(R.id.btnSend)
    public void sendMsg(Button button){
        // generate new msg obj
        String text = editText.getText().toString();
        Msg msg = new Msg();
        msg.setMsg(text);
        msg.setTimestamp(System.currentTimeMillis());
        // add to store
        MsgStore.getStore().Add(msg);
        // notify update
        adapter.notifyDataSetChanged();
        editText.setText("");
    }
}
