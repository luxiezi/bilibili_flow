package bilibilidemo.lyq.com.lyq.ui.home.fragment.fragment;

import bilibilidemo.lyq.com.lyq.R;
import bilibilidemo.lyq.com.lyq.base.BaseFragment;

/**
 * Created by lu on 2017/4/26.
 * 首页分区界面
 */

public class HomeRegionFragment extends BaseFragment{
//    private HomeRegionFragment instance;
//    public HomeRegionFragment getInstance(){
//        if (instance!=null){
//            instance=new HomeRegionFragment();
//        }
//        return instance;
//    }
    public static HomeRegionFragment newInstance(){
        return new HomeRegionFragment();
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_home_region;
    }
}
