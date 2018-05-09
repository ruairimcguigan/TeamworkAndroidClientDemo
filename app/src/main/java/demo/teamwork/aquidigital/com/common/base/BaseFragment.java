package demo.teamwork.aquidigital.com.common.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;

public abstract class BaseFragment extends Fragment{

    private boolean injected = false;

    @Nullable
    @Override
    public View onCreateView(
            LayoutInflater inflater,
            @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getLayout(), container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    protected abstract int getLayout();

    protected abstract void attachView();

    protected abstract void detachPresenter();

    //    @Override
//    protected void onContextAvailable(@NonNull Context context) {
//        /**
//         * Controller instances are retained across config changes, so this method can be called
//         * more than once. Ensures injection doesn't occur unnecessarily
//         */
//        if ((!injected)){
//            Injector.inject(this);
//            injected = true;
//        }
//
//        super.onContextAvailable(context);

    }

