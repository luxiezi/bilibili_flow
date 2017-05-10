package bilibilidemo.lyq.com.lyq;

import android.app.Application;

/**
 * Created by lu on 2017/4/27.
 */

public class BilibiliApp extends Application {

    private static BilibiliApp mInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance=this;
        init();
    }

    private void init() {

    }

    public static BilibiliApp getInstance(){
        return mInstance;
    }
}
