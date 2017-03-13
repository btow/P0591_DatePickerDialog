package com.example.samsung.p0591_datepickerdialog;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import com.example.samsung.p0591_datepickerdialog.R;

public class MainActivity extends AppCompatActivity {

    int DIALOG_DATE = 1,
        myYear      = 2017,
        myMonth     = 02,
        myDay       = 03;
    TextView tvDate;

    DatePickerDialog.OnDateSetListener myCallBack = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            myDay = dayOfMonth;
            myMonth = month;
            myYear = year;
            String massage = "Date is " + myDay + " day of " + ((myMonth + 1) > 9 ? myMonth + 1 : ("0" + (myMonth + 1))) + " month of " + myYear + " year";
            tvDate.setText(massage);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        tvDate = (TextView) findViewById(R.id.tvDate);
    }

    @SuppressWarnings("deprecation")
    public void onClickDate(View view) {
        showDialog(DIALOG_DATE);
    }

    @SuppressWarnings("deprecation")
    protected Dialog onCreateDialog(int id) {
        if (id == DIALOG_DATE) {
            DatePickerDialog datePickerDialog = new DatePickerDialog(
                    this, myCallBack, myYear, --myMonth, myDay
            );
            return datePickerDialog;
        }
        return super.onCreateDialog(id);
    }
}
