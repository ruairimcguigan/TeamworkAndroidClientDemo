package demo.teamwork.aquidigital.com.features.home;

import com.bluelinelabs.conductor.Controller;

import demo.teamwork.aquidigital.com.R;
import demo.teamwork.aquidigital.com.common.base.BaseActivity;
import demo.teamwork.aquidigital.com.features.projects.ProjectsController;

public class HomeActivity extends BaseActivity {

    @Override
    protected int layoutRes() {
        return R.layout.activity_home;
    }

    @Override
    protected Controller initialScreen() {
        return new ProjectsController(); // TODO: 08/05/2018 this will change when welcome home screen is added
    }
}
