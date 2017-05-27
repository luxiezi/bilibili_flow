package bilibilidemo.lyq.com.lyq;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.Toast;

import bilibilidemo.lyq.com.lyq.base.BaseActivity;
import bilibilidemo.lyq.com.lyq.ui.home.fragment.fragment.HomePageFragment;
import butterknife.BindView;

public class MainActivity extends BaseActivity implements NavigationView.OnNavigationItemSelectedListener{

    HomePageFragment mHomePageFragment;
    @BindView(R.id.navigation_view)
    NavigationView navigationView;
    @BindView(R.id.container)
    FrameLayout containerView;
    @BindView(R.id.drawer_layout)
    DrawerLayout mDrawerLayout;

    @Override
    protected void initView(Bundle savedInstanceState) {
        navigationView.setItemIconTintList(null);//侧滑item图片就是显示他本身的颜色
        navigationView.setNavigationItemSelectedListener(this);
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


    /**
     * DrawerLayout侧滑菜单开关
     */
    public void toggleDrawer(){
        if (mDrawerLayout.isDrawerOpen(GravityCompat.START)){
            mDrawerLayout.closeDrawer(GravityCompat.START);
        }else{
            mDrawerLayout.openDrawer(GravityCompat.START);
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

//        item.setCheckable(true);
        mDrawerLayout.closeDrawer(GravityCompat.START);

        switch (item.getItemId()){

            case R.id.item_home://首页
                Toast.makeText(this,"首页",Toast.LENGTH_SHORT).show();
                return true;

            case R.id.item_vip:
                Log.i("--------------","这是vip页面");
                Toast.makeText(this,"vip",Toast.LENGTH_SHORT).show();
                return true;

            case R.id.item_download://离线下载

                return true;



            case R.id.item_favourite://我的收藏
                Log.i("--------------","这是收藏页面");
                Toast.makeText(this,"我的收藏页面",Toast.LENGTH_SHORT).show();
                return true;

            case R.id.item_history://历史记录
                return true;

            case R.id.item_group://关注的人
                return true;

            case R.id.item_tracker://我的钱包
                return true;



            case R.id.item_theme:
                return true;

            case R.id.item_app://应用推荐
                return true;

            case R.id.item_settings:
                return true;
        }

        return false;
    }
}
