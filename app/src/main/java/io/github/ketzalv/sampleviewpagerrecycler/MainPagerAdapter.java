package io.github.ketzalv.sampleviewpagerrecycler;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainPagerAdapter extends FragmentStatePagerAdapter {

    private List<PageFragment> pages = new ArrayList<>();

    public MainPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    public void addPage(PageModel pageModel){
        pages.add(PageFragment.newInstance(pageModel));
    }

    public void addPages(List<PageModel> pages){
        if(pages != null && !pages.isEmpty()){
            for(PageModel pageModel: pages){
                this.pages.add(PageFragment.newInstance(pageModel));
            }
        }
        notifyDataSetChanged();
    }
    @Override
    public Fragment getItem(int position) {
        return pages.get(position);
    }

    @Override
    public int getCount() {
        return pages.size();
    }
}
