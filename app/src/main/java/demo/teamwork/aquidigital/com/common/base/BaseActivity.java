package demo.teamwork.aquidigital.com.common.base;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewGroup;

import com.bluelinelabs.conductor.Conductor;
import com.bluelinelabs.conductor.Controller;
import com.bluelinelabs.conductor.ControllerChangeHandler;
import com.bluelinelabs.conductor.Router;

import java.util.UUID;

import javax.inject.Inject;

import demo.teamwork.aquidigital.com.R;
import demo.teamwork.aquidigital.com.common.di.Injector;
import demo.teamwork.aquidigital.com.common.di.ScreenInjector;
import demo.teamwork.aquidigital.com.ui.ScreenNavigator;

public abstract class BaseActivity extends AppCompatActivity {

    @Inject
    ScreenInjector screenInjector;
    @Inject
    ScreenNavigator screenNavigator;

    // retain component across configuration changes
    private String instanceId;
    // key to put and retrieve from bundle
    static final String INSTANCE_ID_KEY = "instance_id";
    private Router router;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            instanceId = savedInstanceState.getString(INSTANCE_ID_KEY);
            Injector.inject(this);
        } else {
            instanceId = UUID.randomUUID().toString();
        }
        setContentView(layoutRes());

        ViewGroup screenContainer = findViewById(R.id.screen_container);
        if (screenContainer == null) {
            throw new NullPointerException("Activity must have a view with id: screen_container");
        }
        router = Conductor.attachRouter(this, screenContainer, savedInstanceState);
        screenNavigator.initWithRouter(router, initialScreen());

        monitorBackStack();
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onBackPressed() {
        if (!screenNavigator.pop()) {
            super.onBackPressed();
        }
    }

    @LayoutRes
    protected abstract int layoutRes();

    protected abstract Controller initialScreen();

    // when going through configuration change - store the id - which can be retrieved in the next onCreate()
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(INSTANCE_ID_KEY, instanceId);
    }

    // have a way to have a unique key for each Activity even across configuration changes
    public String getInstanceId() {
        return instanceId;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        screenNavigator.clear();
        if (isFinishing()) {
            Injector.clearComponent(this);
        }
    }

    public ScreenInjector getScreenInjector() {
        return screenInjector;
    }

    private void monitorBackStack() {
        router.addChangeListener(new ControllerChangeHandler.ControllerChangeListener() {
            @Override
            public void onChangeStarted(@Nullable Controller to,
                                        @Nullable Controller from,
                                        boolean isPush,
                                        @NonNull ViewGroup container,
                                        @NonNull ControllerChangeHandler handler) {

            }

            @Override
            public void onChangeCompleted(@Nullable Controller to,
                                          @Nullable Controller from,
                                          boolean isPush,
                                          @NonNull ViewGroup container,
                                          @NonNull ControllerChangeHandler handler) {

                if (!isPush && from != null) {
                    Injector.clearComponent(from);
                }

            }
        });
    }
}
