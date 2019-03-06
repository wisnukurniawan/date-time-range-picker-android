package com.wisnu.date_range_picker_android;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.wisnu.datetimerangepickerandroid.CalendarPickerView;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CalendarPickerView cal = findViewById(R.id.calendar_view);
        cal.init(
            DateTime.now(DateTimeZone.UTC).minusYears(1).toDate(),
            DateTime.now(DateTimeZone.UTC).plusDays(4).toDate()
        )
            .inMode(CalendarPickerView.SelectionMode.RANGE)
            .withSelectedDate(DateTime.now(DateTimeZone.UTC).minusDays(1).plusDays(4).toDate());
    }
}
