package com.example.ilhamsuaib.materialtab;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;


/**
 * A simple {@link Fragment} subclass.

 */
public class ClassFragment extends Fragment{

    private ImageButton btn_menu_about, btn_menu_back;
    private ViewPager viewPager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_class, container, false);
        btn_menu_about = (ImageButton) v.findViewById(R.id.btn_menu_about);
        btn_menu_back = (ImageButton) v.findViewById(R.id.btn_menu_back);
        viewPager = (ViewPager) getActivity().findViewById(R.id.viewPager);

        btn_menu_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(1);
            }
        });
        return v;
    }
}