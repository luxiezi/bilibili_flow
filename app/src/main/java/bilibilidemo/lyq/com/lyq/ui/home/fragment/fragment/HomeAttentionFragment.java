package bilibilidemo.lyq.com.lyq.ui.home.fragment.fragment;

import bilibilidemo.lyq.com.lyq.R;
import bilibilidemo.lyq.com.lyq.base.BaseFragment;

/**
 * Created by lu on 2017/4/26.
 * 首页关注界面
 */

public class HomeAttentionFragment extends BaseFragment {

    public static HomeAttentionFragment newInstance(){
        return new HomeAttentionFragment();
    }
    @Override
    public int getLayoutId() {
        return R.layout.fragment_home_attention;
    }
}
