package com.coder4.clipboard.store;

import com.coder4.clipboard.model.Msg;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by lihy on 15/10/13.
 */
public class MsgStore {

    // SingleTon Thread-Safe ensure
    private static MsgStore instance = new MsgStore();

    private List<Msg> list;

    public static MsgStore getStore() {
        return instance;
    }

    private MsgStore(){
        list = new LinkedList<Msg>();

        for(int i=0; i<10; i++){
            Msg msg = new Msg();
            msg.setMsg(i+"");
            msg.setTimestamp(1444727706 + i);
            list.add(msg);
        }
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
    }

    public Msg Get(int i) {
        synchronized (MsgStore.this) {
            if (i >= 0 && i < list.size()) {
                return list.get(i);
            }
        }
        return null;
    }
}
