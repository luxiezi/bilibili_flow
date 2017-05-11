package bilibilidemo.lyq.com.lyq.ui.home.fragment.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

import java.util.ArrayList;
import java.util.List;

import bilibilidemo.lyq.com.lyq.R;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by lu on 2017/4/26.
 * 首页模块主界面
 */

public class HomePageFragment extends Fragment
{
    private String TAG = "HomePageFragment";

    Unbinder unbind;

    View parentView;
    int content_id = R.id.vp_container_home;

    FragmentActivity activity;

    private Fragment mCurrentFragment;//当前fragment
    private static final String KEY_CURRENT_FRAGMENT_TAG = "key_current_fragment_tag";

    @BindView(R.id.radiogroup_fragment)
    RadioGroup radioGroup;

    @BindView(R.id.vp_container_home)
    ViewPager mViewPager;

    public static HomePageFragment newInstance()
    {
        return new HomePageFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        parentView = inflater.inflate(getLayoutId(), container, false);
        activity = getActivity();
        return parentView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);

        unbind = ButterKnife.bind(this,view);

        radioGroup = (RadioGroup) view.findViewById(R.id.radiogroup_fragment);
        radioGroup.check(R.id.attention_rb_fragment);

        initFragment();

        setListener();
    }

    public int getLayoutId()
    {
        return R.layout.fragment_home_page;
    }

    public void initFragment()
    {
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(HomeAttentionFragment.newInstance());
        fragments.add(HomeBangumiFragment.newInstance());
        fragments.add(HomeDiscoverFragment.newInstance());
        fragments.add(HomeLiveFragment.newInstance());
        fragments.add(HomeRecommendedFragment.newInstance());
        fragments.add(HomeRegionFragment.newInstance());

        ViewPagerAdapter pagerAdapter = new ViewPagerAdapter(fragments, getChildFragmentManager());
        mViewPager.setAdapter(pagerAdapter);
    }

    private void setListener()
    {
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId)
            {

                switch (checkedId)
                {
                    case R.id.attention_rb_fragment:


                        break;
                    case R.id.bangumi_rb_fragment:


                        break;
                    case R.id.discover_rb_fragment:


                        break;
                    case R.id.live_rb_fragment:


                        break;
                    case R.id.recommended_rb_fragment:


                        break;
                    case R.id.region_rb_fragment:


                        break;
                }
            }

        });
    }


    @Override
    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        this.activity = (FragmentActivity) activity;

    }

    @Override
    public void onDetach()
    {
        super.onDetach();
        this.activity = null;
    }

    @Override
    public void onDestroyView()
    {
        super.onDestroyView();
        unbind.unbind();
    }


    @Override
    public void onSaveInstanceState(Bundle outState)
    {
        super.onSaveInstanceState(outState);
        outState.putString(KEY_CURRENT_FRAGMENT_TAG, mCurrentFragment.getTag());

    }
}
