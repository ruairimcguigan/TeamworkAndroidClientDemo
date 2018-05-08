package demo.teamwork.aquidigital.com.common.base;

import android.app.Activity;

import dagger.Binds;
import dagger.Module;
import dagger.android.ActivityKey;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;
import demo.teamwork.aquidigital.com.features.home.HomeActivity;
import demo.teamwork.aquidigital.com.features.home.HomeActivityComponent;

@Module(subcomponents = {HomeActivityComponent.class})
public abstract class ActivityBindingModule {

    @Binds // replacement for @Provides
    @IntoMap
    @ActivityKey(HomeActivity.class)
    abstract AndroidInjector.Factory<? extends Activity> providesLoginActivityInjector(HomeActivityComponent.Builder builder);
}
