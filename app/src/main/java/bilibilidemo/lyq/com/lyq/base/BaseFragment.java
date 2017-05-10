package bilibilidemo.lyq.com.lyq.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by lu on 2017/4/26.
 */

public abstract class BaseFragment extends Fragment {

    private View parentView;

    private FragmentActivity activity;

    Unbinder unbinder;

    public abstract
    @LayoutRes
    int getLayoutId();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        parentView=inflater.inflate(getLayoutId(),container,false);
        activity=getSupportActivity();
//        init();
//        showFragment();
        return parentView;
    }

//    public abstract void init();
//    public abstract void showFragment();

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);
        unbinder= ButterKnife.bind(activity);
    }
    private FragmentActivity getSupportActivity() {
        return super.getActivity();
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
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
}
