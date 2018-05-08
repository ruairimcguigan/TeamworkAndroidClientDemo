package demo.teamwork.aquidigital.com.common.base;

import android.app.Application;

import javax.inject.Inject;

import demo.teamwork.aquidigital.com.common.di.ActivityInjector;

public class TeamworkApplication extends Application {

    @Inject ActivityInjector activityInjector;
    private ApplicationComponent appComponent;

    @Override public void onCreate() {
        super.onCreate();

        appComponent = DaggerApplicationComponent
                .builder()
                .applicationModule(new ApplicationModule(this))
                .build();

        appComponent.inject(this);
    }

    public ActivityInjector getActivityInjector() {
        return activityInjector;
    }
}
