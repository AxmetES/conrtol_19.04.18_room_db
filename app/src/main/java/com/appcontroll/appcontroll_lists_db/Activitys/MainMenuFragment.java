package com.appcontroll.appcontroll_lists_db.Activitys;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.appcontroll.appcontroll_lists_db.R;

public class MainMenuFragment extends Fragment {
     Button btnClickChangeColor;
     RadioGroup colorChangeRadioGroup;
     RadioButton radioButtonBlue, radioButtonRed, radioButtonYellow;
     SharedPreferences sharedPreferences;
     SharedPreferences.Editor editor;


    public MainMenuFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_main_menu, container, false);

        btnClickChangeColor = (Button) view.findViewById(R.id.main_color_change_btn);
        colorChangeRadioGroup = (RadioGroup) view.findViewById(R.id.color_radio_group);
        radioButtonBlue = (RadioButton) view.findViewById(R.id.main_radio_blue);
        radioButtonRed = (RadioButton) view.findViewById(R.id.main_radio_red);
        radioButtonYellow = (RadioButton) view.findViewById(R.id.main_radio_yellow);

        btnClickChangeColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = colorChangeRadioGroup.getCheckedRadioButtonId();
                switch (id) {
                    case R.id.main_radio_blue:
                        Constant.theme = R.style.AppTheme_red;
                        break;

                    case R.id.main_radio_red:
                        Constant.theme = R.style.AppTheme_red;
                        break;

                    case R.id.main_radio_yellow:
                        Constant.theme = R.style.AppTheme_red;
                        break;
                }
            }
        });
        return view;
    }
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState){
        super.onViewCreated(view,savedInstanceState);
    }
}
