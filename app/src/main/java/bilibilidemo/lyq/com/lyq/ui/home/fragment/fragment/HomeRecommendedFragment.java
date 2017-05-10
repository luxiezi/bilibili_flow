package bilibilidemo.lyq.com.lyq.ui.home.fragment.fragment;

import bilibilidemo.lyq.com.lyq.R;
import bilibilidemo.lyq.com.lyq.base.BaseFragment;

/**
 * Created by lu on 2017/4/26.
 * 首页推荐界面
 */

public class HomeRecommendedFragment extends BaseFragment {
    public static HomeRecommendedFragment newInstance(){
        return new HomeRecommendedFragment();
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_home_recommended;
    }
}
