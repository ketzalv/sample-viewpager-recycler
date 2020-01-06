package io.github.ketzalv.sampleviewpagerrecycler;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

public class MainFragment extends Fragment {
    public static final String TAG = "MainFragment";

    private ViewPager pager;
    private MainPagerAdapter adapter;

    public static MainFragment newInstance() {

        Bundle args = new Bundle();

        MainFragment fragment = new MainFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (getView() == null) {
            return inflater.inflate(R.layout.fragment_main, container, false);
        }
        return getView();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        adapter = new MainPagerAdapter(getChildFragmentManager());
        pager = view.findViewById(R.id.view_pager);
        pager.setAdapter(adapter);
        adapter.addPages(PageModel.getDummies());
    }
}
