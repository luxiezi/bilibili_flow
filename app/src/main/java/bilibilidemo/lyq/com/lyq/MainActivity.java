package bilibilidemo.lyq.com.lyq;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.widget.FrameLayout;

import bilibilidemo.lyq.com.lyq.base.BaseActivity;
import bilibilidemo.lyq.com.lyq.ui.home.fragment.fragment.HomePageFragment;
import butterknife.BindView;

public class MainActivity extends BaseActivity {

    HomePageFragment mHomePageFragment;
    @BindView(R.id.navigation_view)
    NavigationView navigationView;
    @BindView(R.id.container)
    FrameLayout containerView;

    @Override
    protected void initView(Bundle savedInstanceState) {
        navigationView.setItemIconTintList(null);//侧滑item图片就是显示他本身的颜色
        initFragments();

    }

    private void initFragments() {

        mHomePageFragment=HomePageFragment.newInstance();
        getSupportFragmentManager().beginTransaction()
        .add(R.id.container,mHomePageFragment,null)
        .commit();
    }


    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }
}
