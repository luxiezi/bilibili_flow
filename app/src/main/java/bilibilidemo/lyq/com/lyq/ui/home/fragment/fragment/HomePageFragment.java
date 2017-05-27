package bilibilidemo.lyq.com.lyq.ui.home.fragment.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import bilibilidemo.lyq.com.lyq.MainActivity;
import bilibilidemo.lyq.com.lyq.R;
import bilibilidemo.lyq.com.lyq.ui.home.fragment.adapter.ViewPagerAdapter;
import bilibilidemo.lyq.com.lyq.widget.NoScrollViewPager;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by lu on 2017/4/26.
 * 首页模块主界面
 */

public class HomePageFragment extends Fragment {

    private String TAG = "HomePageFragment";

    Unbinder unbind;
    View parentView;
    FragmentActivity activity;

    @BindView(R.id.vp_container_home)
    NoScrollViewPager viewPager;
    @BindView(R.id.radiogroup_fragment)
    RadioGroup radioGroup;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;


    public static HomePageFragment newInstance(){
        return new HomePageFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        parentView = inflater.inflate(getLayoutId(),container,false);
        activity=getActivity();
        return parentView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        unbind=ButterKnife.bind(this,view);
        initToolBar();
        radioGroup.check(R.id.attention_rb_fragment);
        initFragment();
        setListenner();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    private void initToolBar() {

        mToolbar.setTitle("");
        setHasOptionsMenu(true);
        ((AppCompatActivity) getActivity()).setSupportActionBar(mToolbar);
    }

    public int getLayoutId() {
        return R.layout.fragment_home_page;
    }

    public void initFragment() {

        List<Fragment> fragments = new ArrayList<>();
        fragments.add(HomeLiveFragment.newInstance());
        fragments.add(HomeRecommendedFragment.newInstance());
        fragments.add(HomeBangumiFragment.newInstance());
        fragments.add(HomeRegionFragment.newInstance());
        fragments.add(HomeAttentionFragment.newInstance());
        fragments.add(HomeDiscoverFragment.newInstance());

        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(fragments,getChildFragmentManager());
        viewPager.setAdapter(viewPagerAdapter);

    }

    private void setListenner() {

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {

                switch (checkedId){
                    case R.id.attention_rb_fragment:

                        viewPager.setCurrentItem(0);

                        break;
                    case R.id.bangumi_rb_fragment:

                        viewPager.setCurrentItem(1);

                        break;
                    case R.id.discover_rb_fragment:

                        viewPager.setCurrentItem(2);

                        break;
                    case R.id.live_rb_fragment:

                        viewPager.setCurrentItem(3);

                        break;
                    case R.id.recommended_rb_fragment:

                        viewPager.setCurrentItem(4);

                        break;
                    case R.id.region_rb_fragment:

                        viewPager.setCurrentItem(5);

                        break;
                }
            }

        });
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        menu.clear();
        inflater.inflate(R.menu.menu_main,menu);
        super.onCreateOptionsMenu(menu, inflater);

    }

    /*
    点击头像打开抽屉
     */
    @OnClick(R.id.toobar_user)
    void toggleDrawer(){
        Activity activity=getActivity();
        if (activity instanceof MainActivity){
            ((MainActivity)activity).toggleDrawer();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.id_action_game:
                Toast.makeText(getContext(),"游戏页面",Toast.LENGTH_SHORT).show();
                break;
            case R.id.id_action_download:
                Toast.makeText(getContext(),"离线页面",Toast.LENGTH_SHORT).show();
                break;
            case R.id.id_action_search:
                Toast.makeText(getContext(),"搜索页面",Toast.LENGTH_SHORT).show();
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.activity= (FragmentActivity) activity;

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
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
    }
}
