package demo.teamwork.aquidigital.com.features.home;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import demo.teamwork.aquidigital.com.common.di.ActivityScope;
import demo.teamwork.aquidigital.com.ui.ScreenNavigationModule;

@ActivityScope
@Subcomponent(modules = { MainScreenBindingModule.class, ScreenNavigationModule.class,
})
/**
 * Built on top of ApplicationComponent
 */
public interface HomeActivityComponent extends AndroidInjector<HomeActivity> {

    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<HomeActivity> {

        @Override
        public void seedInstance(HomeActivity instance) {

        }
    }
}
