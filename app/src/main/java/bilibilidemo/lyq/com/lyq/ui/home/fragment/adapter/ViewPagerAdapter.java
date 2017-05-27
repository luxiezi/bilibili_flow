package bilibilidemo.lyq.com.lyq.ui.home.fragment.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by lu on 2017/5/11.
 */

public class ViewPagerAdapter extends FragmentPagerAdapter{

    List<Fragment> fragments;

    public ViewPagerAdapter(List<Fragment> fragments,FragmentManager childFragmentManager) {
        super(childFragmentManager);
        this.fragments=fragments;
    }


    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments==null ? 0 : fragments.size();
    }
}
