package io.github.ketzalv.sampleviewpagerrecycler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadFragment(MainFragment.newInstance(), MainFragment.TAG);
    }

    protected  void loadFragment(Fragment fragment, String tag){
        loadFragment(fragment, tag,true, TransitionEnum.FADE);
    }
    protected void loadFragment(Fragment fragment, String tag, boolean addToBackStack, TransitionEnum transition) {
        String backStateName = tag;
        boolean fragmentPopped = getSupportFragmentManager().popBackStackImmediate(backStateName, 0);
        if (!fragmentPopped) { //fragment not in back stack, create it.
            try {
                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                if (!transition.equals(TransitionEnum.NONE)) {
                    ft.setCustomAnimations(transition.getEnterAnimation(), transition.getExitAnimation(),
                            transition.getEnterAnimation(), transition.getExitAnimation());
                }
                ft.replace(R.id.frame_fragment_container, fragment, tag);
                if (addToBackStack) {
                    ft.addToBackStack(tag);
                }
                ft.commit();
            } catch (Exception e) {

            }
        }
    }
}
