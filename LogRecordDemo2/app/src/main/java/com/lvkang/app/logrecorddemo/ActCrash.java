package com.lvkang.app.logrecorddemo;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.io.IOException;

import log.KLog;

public class ActCrash extends AppCompatActivity {

    public static final String TAG = "CrashHandler";
    public Handler mHandler = new Handler();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_crash);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//        final ProgressDialog progress = new ProgressDialog(ActCrash.this);
//        progress.setMessage("getting log...");
//        progress.setIndeterminate(true);
//        progress.setCancelable(false);
//        progress.show();
//        final AsyncTask task = new LogTask(ActCrash.this, progress).execute();
//        mHandler.postDelayed(new Runnable() {
//            public void run() {
//                if (task.getStatus() == AsyncTask.Status.FINISHED)
//                    return;
//                // It's probably one of these devices where some fool broke logcat.
//                progress.dismiss();
//                task.cancel(true);
//                new AlertDialog.Builder(ActCrash.this)
//                        .setMessage("get log failed")
//                        .setCancelable(true)
//                        .setIcon(android.R.drawable.ic_dialog_alert)
//                        .show();
//            }
//        }, 3000);
//
//        finish();
    }

    static String getVersion(Context c) {
        try {
            return c.getPackageManager().getPackageInfo(c.getPackageName(), 0).versionName;
        } catch (Exception e) {
            return "unknown version";
        }
    }
}

class LogTask extends AsyncTask<Void, Void, Void> {
    Activity activity;
    String logPath;
    Process process;
    ProgressDialog progress;

    LogTask(){
        activity=null;
        progress=null;



    }

    LogTask(Activity a, ProgressDialog p) {
        activity = a;
        progress = p;
    }

    @Override
    protected Void doInBackground(Void... v) {
        try {
            KLog.e("crash", "doInBackground begin");
            process = Runtime.getRuntime().exec("logcat -v time");
            logPath = ExceptionHandler.writeLogToFile(process);
            KLog.e("crash", "doInBackground end");
        } catch (IOException e) {
            e.printStackTrace();
           // Toast.makeText(activity, e.toString(), Toast.LENGTH_LONG).show();
        }
        return null;
    }

    @Override
    protected void onCancelled() {
        KLog.e("crash", "onCancelled");
        process.destroy();
    }

    @Override
    protected void onPostExecute(Void v) {
        KLog.e("crash", "onPostExecute");
        //progress.setMessage(activity.getString(R.string.starting_email));
        //ExceptionHandler.sendLog(logPath, activity);
        //progress.dismiss();
       // activity.finish();
       // Log.e("crash", "onPostExecute over");
    }

}

