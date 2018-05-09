package demo.teamwork.aquidigital.com.features.projects;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import demo.teamwork.aquidigital.com.common.di.ScreenScope;

@ScreenScope
@Subcomponent
public interface ProjectsComponent extends AndroidInjector<ProjectsFragment> {

    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<ProjectsFragment> {

    }
}
