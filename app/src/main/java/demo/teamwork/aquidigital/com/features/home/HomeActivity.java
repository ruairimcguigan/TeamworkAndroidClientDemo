package demo.teamwork.aquidigital.com.features.home;

import android.os.Bundle;
import android.support.annotation.Nullable;

import demo.teamwork.aquidigital.com.R;
import demo.teamwork.aquidigital.com.common.base.BaseActivity;
import demo.teamwork.aquidigital.com.features.projects.ProjectsFragment;

public class HomeActivity extends BaseActivity {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        showProjects();
    }

    private void showProjects() {
        showFragment(getScreenContainer(), ProjectsFragment.class);
    }

    @Override
    protected int layoutRes() {
        return R.layout.activity_home;
    }

    @Override
    protected void attachView() {

    }

    @Override
    protected void detachPresenter() {

    }
}
