package bilibilidemo.lyq.com.lyq.ui.home.fragment.fragment;

import bilibilidemo.lyq.com.lyq.R;
import bilibilidemo.lyq.com.lyq.base.BaseFragment;

/**
 * Created by lu on 2017/4/26.
 * 首页番剧页面
 */

public class HomeBangumiFragment extends BaseFragment {

    public static HomeBangumiFragment newInstance(){
        return new HomeBangumiFragment();
    }
    @Override
    public int getLayoutId() {
        return R.layout.fragment_home_bangumi;
    }
}
