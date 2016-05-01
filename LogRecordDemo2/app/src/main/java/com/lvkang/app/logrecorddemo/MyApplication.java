package com.lvkang.app.logrecorddemo;

import android.app.Application;

/**
 * Created by kangkang on 16/5/1.
 */
public class MyApplication extends Application{
    public static MyApplication INSTANCE=null;

    public MyApplication(){
        if (INSTANCE==null){
            INSTANCE=this;
        }

    }

    @Override
    public void onCreate() {
        INSTANCE=this;
        ExceptionHandler exceptionHandler=new ExceptionHandler();
        exceptionHandler.init(this);
        super.onCreate();
    }

    public static MyApplication getInstance(){
        if (INSTANCE==null){
            INSTANCE=new MyApplication();
        }

        return INSTANCE;
    }
}
