package bilibilidemo.lyq.com.lyq.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by lu on 2017/4/26.
 */

public abstract class BaseActivity extends AppCompatActivity {

    Unbinder unbinder;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        unbinder= ButterKnife.bind(this);
        initView(savedInstanceState);
    }
    protected abstract void initView(Bundle savedInstanceState);

    public abstract int getLayoutId();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }
}
