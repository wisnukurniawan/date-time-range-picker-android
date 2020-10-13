package com.wisnu.date_range_picker_android;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.wisnu.datetimerangepickerandroid.CalendarPickerView;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    Date selectedDate = new Date();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final CalendarPickerView cal = findViewById(R.id.calendar_view);
        cal.init(
                buildMinimumDate(),
                DateTime.now(DateTimeZone.UTC).plusDays(10).toDate()
        )
                .inMode(CalendarPickerView.SelectionMode.RANGE)
                .withSelectedDate(selectedDate);

        final Button button1 = findViewById(R.id.button1);

        button1.setText(selectedDate.toString());
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cal.init(
                        DateTime.now(DateTimeZone.UTC).toDate(),
                        DateTime.now(DateTimeZone.UTC).plusDays(10).toDate()
                )
                        .inMode(CalendarPickerView.SelectionMode.RANGE)
                        .withSelectedDate(selectedDate);

                cal.setOnDateSelectedListener(new CalendarPickerView.OnDateSelectedListener() {
                    @Override
                    public void onDateSelected(Date date) {
                        Log.d("onDateSelected", date.toString());
                        selectedDate = date;
                        button1.setText(selectedDate.toString());
                    }

                    @Override
                    public void onDateUnselected(Date date) {

                    }
                });
            }
        });

        cal.setOnDateResolvedListener(new CalendarPickerView.OnDateResolvedListener() {
            @Override
            public void onMinDateResolved(Date date) {
                selectedDate = date;
                button1.setText(selectedDate.toString());
                Log.d("onMinDateResolved", date.toString());
            }

            @Override
            public void onMaxDateResolved(Date date) {
                selectedDate = date;
                button1.setText(selectedDate.toString());
                Log.d("onMaxDateResolved", date.toString());
            }
        });
    }

    private Date buildMinimumDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_YEAR, 1);
        calendar.set(Calendar.YEAR, 2019);

        return calendar.getTime();
    }

}
