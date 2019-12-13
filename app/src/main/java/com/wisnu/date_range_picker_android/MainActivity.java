package com.wisnu.date_range_picker_android;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import com.wisnu.datetimerangepickerandroid.CalendarPickerView;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume() {
        super.onResume();
        CalendarPickerView cal = findViewById(R.id.calendar_view);
        cal.init(
                DateTime.now(DateTimeZone.UTC).minusYears(1).toDate(),
                DateTime.now(DateTimeZone.UTC).plusDays(1).toDate()
        )
                .inMode(CalendarPickerView.SelectionMode.RANGE)
                .withSelectedDate(DateTime.now(DateTimeZone.UTC).minusDays(1).toDate());
        cal.setOnDateResolvedListener(new CalendarPickerView.OnDateResolvedListener() {
            @Override
            public void onMinDateResolved(Date date) {
                Log.d("onMinDateResolved", date.toString());
            }

            @Override
            public void onMaxDateResolved(Date date) {
                Log.d("onMaxDateResolved", date.toString());
            }
        });
    }
}
