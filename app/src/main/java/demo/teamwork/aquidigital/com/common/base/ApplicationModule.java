package demo.teamwork.aquidigital.com.common.base;

import android.content.Context;

import dagger.Module;
import dagger.Provides;
import demo.teamwork.aquidigital.com.common.base.TeamworkApplication;

/**
 * Initial module of application scope
 */
@Module
public class ApplicationModule {
    private TeamworkApplication application;

    public ApplicationModule(TeamworkApplication application) {
        this.application = application;
    }

    @Provides
    Context providesApplicationScope(){
        return application;
    }
}
