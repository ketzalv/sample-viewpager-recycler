package io.github.ketzalv.sampleviewpagerrecycler;

import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class PageFragment extends Fragment {

    private static final String ARGS_PAGE_MODEL = "ARG_PAGE_MODEL";
    private PageModel pageModel;

    private ItemAdapter adapter = new ItemAdapter();

    public static PageFragment newInstance(PageModel pageModel) {

        Bundle args = new Bundle();
        args.putParcelable(ARGS_PAGE_MODEL, pageModel);
        PageFragment fragment = new PageFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getArguments() != null && getArguments().containsKey(ARGS_PAGE_MODEL)){
            pageModel = getArguments().getParcelable(ARGS_PAGE_MODEL);
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (getView() == null) {
            return inflater.inflate(R.layout.fragment_page, container, false);
        }
        return getView();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ((TextView) view.findViewById(R.id.text_name)).setText(pageModel.getName());
        initRecycler((RecyclerView) view.findViewById(R.id.recycler), adapter);
        adapter.addItems(pageModel.getItems());
    }

    private void initRecycler(RecyclerView recyclerView, RecyclerView.Adapter adapter) {
        if (recyclerView != null) {
            LinearLayoutManager lm = new LinearLayoutManager(getActivity(), RecyclerView.VERTICAL, false);
            recyclerView.setLayoutManager(lm);
            recyclerView.setNestedScrollingEnabled(false);
            recyclerView.setHasFixedSize(true);

            recyclerView.setAdapter(adapter);
        }
    }
}
