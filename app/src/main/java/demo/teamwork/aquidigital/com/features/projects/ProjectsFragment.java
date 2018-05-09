package demo.teamwork.aquidigital.com.features.projects;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import demo.teamwork.aquidigital.com.R;
import demo.teamwork.aquidigital.com.common.base.BaseFragment;

public class ProjectsFragment extends BaseFragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getLayout(), container, false);

        return view;
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_projects;
    }

    @Override
    protected void attachView() {

    }

    @Override
    protected void detachPresenter() {

    }
}
