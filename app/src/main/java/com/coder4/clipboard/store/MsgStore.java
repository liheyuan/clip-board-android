package com.coder4.clipboard.store;

import android.widget.BaseAdapter;

import com.coder4.clipboard.model.Msg;

import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by lihy on 15/10/13.
 */
public class MsgStore {

    // SingleTon Thread-Safe ensure
    private static MsgStore instance = new MsgStore();

    private List<Msg> list;

    private List<WeakReference<BaseAdapter>> adapterList;

    public static MsgStore getStore() {
        return instance;
    }

    private MsgStore(){
        list = new LinkedList<Msg>();
        adapterList = new LinkedList<>();

        for(int i=0; i<10; i++){
            Msg msg = new Msg();
            msg.setMsg(i+"");
            msg.setTimestamp(1444727706 + i);
            list.add(msg);
        }
    }

    public void AddAdapter(BaseAdapter adapter) {
        adapterList.add(new WeakReference<BaseAdapter>(adapter));
    }

    public int Size() {
        synchronized (MsgStore.this) {
            return list.size();
        }
    }

    public void Add(Msg msg) {
        synchronized (MsgStore.this) {
            list.add(msg);
        }
        // notify data change
        notifyAdapter();
    }

    public Msg Get(int i) {
        synchronized (MsgStore.this) {
            if (i >= 0 && i < list.size()) {
                return list.get(i);
            }
        }
        return null;
    }

    private void notifyAdapter(){
        for(WeakReference<BaseAdapter> adapter:adapterList){
            if(adapter != null && adapter.get() != null){
                adapter.get().notifyDataSetChanged();
            }
        }
    }
}
