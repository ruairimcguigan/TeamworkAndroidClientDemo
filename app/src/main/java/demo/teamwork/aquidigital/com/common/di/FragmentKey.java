package demo.teamwork.aquidigital.com.common.di;

import android.support.v4.app.Fragment;

import com.bluelinelabs.conductor.Controller;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

import dagger.MapKey;

@MapKey
@Target(ElementType.METHOD)
public @interface FragmentKey {

    Class<? extends Fragment> value();
}
