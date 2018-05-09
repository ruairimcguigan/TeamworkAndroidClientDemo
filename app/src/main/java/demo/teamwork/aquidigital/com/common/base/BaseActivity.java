package demo.teamwork.aquidigital.com.common.base;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewGroup;

import java.util.UUID;

import javax.inject.Inject;

import butterknife.BindView;
import demo.teamwork.aquidigital.com.R;
import demo.teamwork.aquidigital.com.common.di.Injector;
import demo.teamwork.aquidigital.com.common.di.ScreenInjector;
import demo.teamwork.aquidigital.com.ui.ScreenNavigator;

import static butterknife.ButterKnife.bind;

public abstract class BaseActivity extends AppCompatActivity implements FragmentManager.OnBackStackChangedListener {

    @BindView(R.id.screen_container) ViewGroup screenContainer;

    @Inject ScreenInjector screenInjector;
    @Inject ScreenNavigator screenNavigator;

    private String instanceId;
    static final String INSTANCE_ID_KEY = "instance_id";

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        checkInstanceKeyAndInject(savedInstanceState);
        setContentView(layoutRes());

        super.onCreate(savedInstanceState);
        bind(this);
        if (screenContainer == null) {
            throw new NullPointerException("Activity must have a view with id: screen_container");
        }
        attachView();
    }

    @LayoutRes
    protected abstract int layoutRes();

    protected abstract void attachView();

    protected abstract void detachPresenter();

    protected final <T extends Fragment> void showFragment(@IdRes int fragmentPlaceholder, Class<T> fragmentClass) {
        showFragment(fragmentPlaceholder, fragmentClass, null, false);
    }

    @SuppressLint("StringFormatInvalid")
    protected final <T extends Fragment> void showFragment(@IdRes int fragmentPlaceholder, Class<T> fragmentClass, Bundle bundle, boolean addToBackStack) {

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        Fragment fragment = getSupportFragmentManager().findFragmentByTag(fragmentClass.getSimpleName());

        if (fragment == null) {
            try {
                fragment = fragmentClass.newInstance();

                fragment.setArguments(bundle);
            } catch (InstantiationException | IllegalAccessException e) {
                throw new RuntimeException(getApplicationContext().getString(R.string.fragment_not_created_message, e));
            }
        }

        addCustomTransitionAnimation(fragmentPlaceholder, fragmentClass, fragmentTransaction, fragment);

        if (addToBackStack) {
            fragmentTransaction.addToBackStack(null);
        }

        fragmentTransaction.commit();
    }

    public void onBackStackChanged() {
        shouldShowActionBarUpButton();
    }

    public void popFragmentBackStack() {
        if (getSupportFragmentManager().getBackStackEntryCount() > 0) {
            getSupportFragmentManager().popBackStack();
        }
    }

    protected void shouldShowActionBarUpButton() {
        if (getSupportFragmentManager().getBackStackEntryCount() == 0) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        } else {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    protected Snackbar makeSnackBar(@IdRes int hostLayoutId, String message) {
        Snackbar mySnackbar = Snackbar.make(findViewById(hostLayoutId),
                message, Snackbar.LENGTH_SHORT);
        mySnackbar.show();
        return mySnackbar;
    }

    protected void showActionbarTitle() {
        if (getActionBar() != null) {
            getActionBar().setDisplayShowTitleEnabled(true);
        }
    }

    protected void hideActionbarTitle() {
        if (getActionBar() != null) {
            getActionBar().setDisplayShowTitleEnabled(false);
        }
    }

    private <T extends Fragment> void addCustomTransitionAnimation(@IdRes int fragmentPlaceholder, Class<T> fragmentClass, FragmentTransaction fragmentTransaction, Fragment fragment) {
        fragmentTransaction.setCustomAnimations(R.anim.slide_in_right, R.anim.slide_out_left,
                android.R.anim.slide_in_left, android.R.anim.slide_out_right);
        fragmentTransaction.replace(fragmentPlaceholder, fragment, fragmentClass.getSimpleName());
    }

    private void checkInstanceKeyAndInject(@Nullable Bundle savedInstanceState) {
        // retain component across configuration changes
        if (savedInstanceState != null) {
            instanceId = savedInstanceState.getString(INSTANCE_ID_KEY);
            Injector.inject(this);
        } else {
            instanceId = UUID.randomUUID().toString();
        }
    }

    @Override
    public void onBackPressed() {
        if (!screenNavigator.pop()) {
            super.onBackPressed();
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(INSTANCE_ID_KEY, instanceId);
    }

    public String getInstanceId() {
        return instanceId;
    }


    public ScreenInjector getScreenInjector() {
        return screenInjector;
    }

    protected int getScreenContainer(){
        return R.id.screen_container;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        screenNavigator.clear();
        if (isFinishing()) {
            Injector.clearComponent(this);
        }
    }

}
