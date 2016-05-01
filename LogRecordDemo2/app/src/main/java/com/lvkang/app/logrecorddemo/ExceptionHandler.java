package com.lvkang.app.logrecorddemo;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Environment;
import android.util.Log;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.concurrent.TimeUnit;

import log.KLog;

/**
 * Created by kangkang on 16/4/29.
 */

public class ExceptionHandler implements Thread.UncaughtExceptionHandler {
    public static final String TAG = "CrashHandler";
    private static ExceptionHandler INSTANCE = new ExceptionHandler();
    private Context mContext;
    private Thread.UncaughtExceptionHandler mDefaultHandler;

    public static ExceptionHandler getInstance() {
        return INSTANCE;
    }

    public void init(Context ctx) {
        mContext = ctx;
        mDefaultHandler = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    public static String writeLogToFile(Process process) {

        InputStream inputStream = process.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream), 1024);
        String path = Environment.getExternalStorageDirectory() + File.separator + "LogFile";
        KLog.e(path);
        String logFilePath = path + File.separator + System.currentTimeMillis() + ".txt";
        KLog.e(logFilePath);

        File file = new File(path);

        File logFile = new File(logFilePath);
        try {

            if (!file.exists()) {
                KLog.e();
                if (!file.mkdirs()) {
                    KLog.e();
                    return null;
                }
            }

            if (!logFile.exists()) {
                KLog.e();
                if (!logFile.createNewFile()) {
                    KLog.e();
                    return null;
                }
            }
            KLog.e();

            String line = null;
            FileOutputStream out = new FileOutputStream(logFile, true);


            while ((line = bufferedReader.readLine()) != null) {


                if (line.length() == 0) {
                    continue;
                }
                if (out != null) {
                    out.write((line + "\r\n").getBytes());

                }
            }

            KLog.e();

        } catch (Exception e) {
            e.printStackTrace();

            return null;
        }
        KLog.e();


        return logFilePath;

    }


    @Override
    public void uncaughtException(Thread thread, Throwable ex) {
        KLog.e();

        ex.printStackTrace();

//        Intent intent = new Intent(MyApplication.getInstance(), ActCrash.class);
//        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//        MyApplication.getInstance().startActivity(intent);
        LogTask logTask=new LogTask();
        logTask.executeOnExecutor(AsyncTask.SERIAL_EXECUTOR);

        KLog.e();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.exit(0);


    }


    /**
     * 自定义错误处理,收集错误信息 发送错误报告等操作均在此完成. 开发者可以根据自己的情况来自定义异常处理逻辑
     *
     * @param ex
     * @return true:如果处理了该异常信息;否则返回false
     */
    private boolean handleException(Throwable ex) {
        if (ex == null) {
            return true;
        }
        // new Handler(Looper.getMainLooper()).post(new Runnable() {
        // @Override
        // public void run() {
        // new AlertDialog.Builder(mContext).setTitle("提示")
        // .setMessage("程序崩溃了...").setNeutralButton("我知道了", null)
        // .create().show();
        // }
        // });

        return true;
    }
}
