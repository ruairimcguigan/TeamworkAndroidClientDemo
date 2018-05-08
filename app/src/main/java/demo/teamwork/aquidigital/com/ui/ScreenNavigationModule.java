package demo.teamwork.aquidigital.com.ui;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class ScreenNavigationModule {

    @Binds
    abstract ScreenNavigator provideScreenNavigator(DefaultScreenNavigator screenNavigator);

}
