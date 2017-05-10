package bilibilidemo.lyq.com.lyq.ui.home.fragment.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

import java.util.List;

import bilibilidemo.lyq.com.lyq.R;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by lu on 2017/4/26.
 * 首页模块主界面
 */

public class HomePageFragment extends Fragment {
    private String TAG = "HomePageFragment";

    Unbinder unbind;

    View parentView;
    int content_id=R.id.vp_container_home;


    FragmentManager mFragmentManager;
    FragmentActivity activity;

    HomeAttentionFragment mHomeAttentionFragment;
    HomeBangumiFragment mHomeBangumiFragment;
    HomeDiscoverFragment mHomeDiscoverFragment;
    HomeLiveFragment mHomeLiveFragment;
    HomeRecommendedFragment mHomeRecommendedFragment;
    HomeRegionFragment mHomeRegionFragment;

    private Fragment mCurrentFragment;//当前fragment
    private static final String KEY_CURRENT_FRAGMENT_TAG = "key_current_fragment_tag";

    @BindView(R.id.radiogroup_fragment)
    RadioGroup radioGroup;

    public static HomePageFragment newInstance(){
        return new HomePageFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        parentView = inflater.inflate(getLayoutId(),container,false);
        activity=getActivity();
        mFragmentManager=getChildFragmentManager();
        return parentView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        unbind=ButterKnife.bind(activity);

        radioGroup= (RadioGroup) view.findViewById(R.id.radiogroup_fragment);
        radioGroup.check(R.id.attention_rb_fragment);

        if (savedInstanceState==null){
            Log.i(TAG,"savedInstanceState==null-------------");
            initFragment();

        }else{

            mHomeAttentionFragment = (HomeAttentionFragment) mFragmentManager.findFragmentByTag(HomeAttentionFragment.class.getName());
            mHomeBangumiFragment = (HomeBangumiFragment) mFragmentManager.findFragmentByTag(HomeBangumiFragment.class.getName());
            mHomeDiscoverFragment = (HomeDiscoverFragment) mFragmentManager.findFragmentByTag(HomeDiscoverFragment.class.getName());
            mHomeLiveFragment = (HomeLiveFragment) mFragmentManager.findFragmentByTag(HomeLiveFragment.class.getName());
            mHomeRecommendedFragment = (HomeRecommendedFragment) mFragmentManager.findFragmentByTag(HomeRecommendedFragment.class.getName());
            mHomeRegionFragment = (HomeRegionFragment) mFragmentManager.findFragmentByTag(HomeRegionFragment.class.getName());

            String showTag = savedInstanceState.getString(KEY_CURRENT_FRAGMENT_TAG);

            List<Fragment> fragments =mFragmentManager.getFragments();

            for (Fragment fragment : fragments) {

                if (TextUtils.equals(showTag, fragment.getTag())) {
                    mFragmentManager.beginTransaction()
                            .show(fragment)
                            .commitAllowingStateLoss();

                    mCurrentFragment = fragment;

                } else {
                    mFragmentManager.beginTransaction()
                            .hide(fragment)
                            .commitAllowingStateLoss();
                }

            }
        }

        setListenner();
    }

    public int getLayoutId() {
        return R.layout.fragment_home_page;
    }

    public void initFragment() {

        Log.i(TAG,"initFragment()-------------");
        mHomeAttentionFragment=HomeAttentionFragment.newInstance();
        mHomeBangumiFragment =HomeBangumiFragment.newInstance();
        mHomeDiscoverFragment = HomeDiscoverFragment.newInstance();
        mHomeLiveFragment = HomeLiveFragment.newInstance();
        mHomeRecommendedFragment = HomeRecommendedFragment.newInstance();
        mHomeRegionFragment = HomeRegionFragment.newInstance();

        mFragmentManager.beginTransaction()
                .add(content_id, mHomeAttentionFragment, HomeAttentionFragment.class.getName())
                .add(content_id, mHomeBangumiFragment, HomeBangumiFragment.class.getName()).hide(mHomeBangumiFragment)
                .add(content_id, mHomeDiscoverFragment, HomeDiscoverFragment.class.getName()).hide(mHomeDiscoverFragment)
                .add(content_id, mHomeLiveFragment, HomeLiveFragment.class.getName()).hide(mHomeLiveFragment)
                .add(content_id, mHomeRecommendedFragment, HomeRecommendedFragment.class.getName()).hide(mHomeRecommendedFragment)
                .add(content_id, mHomeRegionFragment, HomeRegionFragment.class.getName()).hide(mHomeRegionFragment)
                .commit();

        mCurrentFragment = mHomeAttentionFragment;
    }

    private void setListenner() {

        Log.i(TAG,"setListenner()-------------");

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {

                 Fragment showFragment=null;//显示的fragment
                Log.i(TAG,"checkedId:-------------"+checkedId);
                switch (checkedId){
                    case R.id.attention_rb_fragment:

                        showFragment=mHomeAttentionFragment;

                        break;
                    case R.id.bangumi_rb_fragment:

                        showFragment=mHomeBangumiFragment;

                        break;
                    case R.id.discover_rb_fragment:

                        showFragment=mHomeDiscoverFragment;

                        break;
                    case R.id.live_rb_fragment:

                        showFragment=mHomeLiveFragment;

                        break;
                    case R.id.recommended_rb_fragment:

                        showFragment=mHomeRecommendedFragment;

                        break;
                    case R.id.region_rb_fragment:

                        showFragment=mHomeRegionFragment;

                        break;
                }
                replaceFragment(showFragment);
            }

        });
    }

    private void replaceFragment(Fragment showFragment) {
        Log.i(TAG,"replaceFragment()-------------");
        if (showFragment==null
                || showFragment==mCurrentFragment
                || mCurrentFragment==null){
            return;
        }
        mFragmentManager.beginTransaction()
                .hide(mCurrentFragment)
                .show(showFragment)
                .commitAllowingStateLoss();

        mCurrentFragment=showFragment;

    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.activity= (FragmentActivity) activity;

    }

    @Override
    public void onDetach() {
        super.onDetach();
        this.activity=null;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbind.unbind();
    }


    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(KEY_CURRENT_FRAGMENT_TAG,mCurrentFragment.getTag());

    }
}
