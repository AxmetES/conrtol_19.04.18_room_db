package com.appcontroll.appcontroll_lists_db.Activitys;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;

import java.util.Calendar;

public class DatePickerFragment extends DialogFragment {
    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        android.icu.util.Calendar c  = android.icu.util.Calendar.getInstance();
        int year = c.get(android.icu.util.Calendar.YEAR);
        int month = c.get(android.icu.util.Calendar.MONTH);
        int day = c.get(android.icu.util.Calendar.DAY_OF_MONTH);

        return new DatePickerDialog(getActivity(),(DatePickerDialog.OnDateSetListener) getActivity(),year,month,day);
    }
}
