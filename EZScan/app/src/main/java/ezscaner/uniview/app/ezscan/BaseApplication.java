package ezscaner.uniview.app.ezscan;

import android.app.Application;

/**
 * Created by kangkang on 16/6/5.
 */
public class BaseApplication extends Application {
    private static BaseApplication INSTANCE;

    public BaseApplication() {
        super();
    }

    public static BaseApplication getInstance(){
        return INSTANCE;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        INSTANCE=this;
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }
}
