package bilibilidemo.lyq.com.lyq.ui.home.fragment.fragment;

import bilibilidemo.lyq.com.lyq.R;
import bilibilidemo.lyq.com.lyq.base.BaseFragment;

/**
 * Created by lu on 2017/4/26.
 * 首页直播界面
 */

public class HomeLiveFragment extends BaseFragment {

    public static HomeLiveFragment newInstance(){
        return new HomeLiveFragment();
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_home_live;
    }
}
