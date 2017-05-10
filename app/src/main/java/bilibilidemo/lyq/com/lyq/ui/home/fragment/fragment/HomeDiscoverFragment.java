package bilibilidemo.lyq.com.lyq.ui.home.fragment.fragment;

import bilibilidemo.lyq.com.lyq.R;
import bilibilidemo.lyq.com.lyq.base.BaseFragment;

/**
 * Created by lu on 2017/4/26.
 * 首页发现界面
 */

public class HomeDiscoverFragment extends BaseFragment {
    public static HomeDiscoverFragment newInstance(){
        return new HomeDiscoverFragment();
    }
    @Override
    public int getLayoutId() {
        return R.layout.fragment_home_discover;
    }
}
