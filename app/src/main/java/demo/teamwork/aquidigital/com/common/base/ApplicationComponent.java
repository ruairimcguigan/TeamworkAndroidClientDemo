package demo.teamwork.aquidigital.com.common.base;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Interface is used to generate and inject code which uses the modules to fulfill the requested dependencies.
 * Lifecycle scope of application
 */
@Singleton
@Component(modules = { ApplicationModule.class, ActivityBindingModule.class })
public interface ApplicationComponent {

    void inject(TeamworkApplication teamworkApplication);
}
