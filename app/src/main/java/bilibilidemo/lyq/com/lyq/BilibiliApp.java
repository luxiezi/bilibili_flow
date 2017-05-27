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
//        registerActivityLifecycleCallbacks(new ActivityLifecycleCallbacks() {
//            @Override
//            public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
//                //这里全局给Activity设置toolbar和title,你想象力有多丰富,这里就有多强大,以前放到BaseActivity的操作都可以放到这里
//                if (activity.findViewById(R.id.toolbar) != null) { //找到 Toolbar 并且替换 Actionbar
//                    if (activity instanceof AppCompatActivity) {
//                        ((AppCompatActivity) activity).setSupportActionBar((Toolbar) activity.findViewById(R.id.toolbar));
//                        ((AppCompatActivity) activity).getSupportActionBar().setDisplayShowTitleEnabled(false);
//                    } else {
//                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//                            activity.setActionBar((android.widget.Toolbar) activity.findViewById(R.id.toolbar));
//                            activity.getActionBar().setDisplayShowTitleEnabled(false);
//                        }
//                    }
//                }
////                if (activity.findViewById(R.id.tv_head_username) != null) { //找到 Toolbar 的标题栏并设置标题名
////                    ((TextView) activity.findViewById(R.id.tv_head_username)).setText(activity.getTitle());
////                }
//
////                if (activity.findViewById(R.id.toolbar_back) != null) { //找到 Toolbar 的返回按钮,并且设置点击事件,点击关闭这个 Activity
////                    activity.findViewById(R.id.toolbar_back).setOnClickListener(v -> {activity.onBackPressed();});
////                }
//            }
//
//            @Override
//            public void onActivityStarted(Activity activity) {
//
//            }
//
//            @Override
//            public void onActivityResumed(Activity activity) {
//
//            }
//
//            @Override
//            public void onActivityPaused(Activity activity) {
//
//            }
//
//            @Override
//            public void onActivityStopped(Activity activity) {
//
//            }
//
//            @Override
//            public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
//
//            }
//
//            @Override
//            public void onActivityDestroyed(Activity activity) {
//
//            }
//
//        });

        init();
    }

    private void init() {

    }

    public static BilibiliApp getInstance(){
        return mInstance;
    }
}
