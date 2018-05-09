package demo.teamwork.aquidigital.com.features.home;

import android.support.v4.app.Fragment;

import com.bluelinelabs.conductor.Controller;

import dagger.Binds;
import dagger.Module;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;
import demo.teamwork.aquidigital.com.common.di.FragmentKey;
import demo.teamwork.aquidigital.com.features.projects.ProjectsComponent;
import demo.teamwork.aquidigital.com.features.projects.ProjectsFragment;

@Module(subcomponents = {ProjectsComponent.class,
})
public abstract class MainScreenBindingModule {

    @Binds
    @IntoMap
    @FragmentKey(ProjectsFragment.class)
    abstract AndroidInjector.Factory<? extends Fragment> bindProjectsInjector(ProjectsComponent.Builder builder);
}
