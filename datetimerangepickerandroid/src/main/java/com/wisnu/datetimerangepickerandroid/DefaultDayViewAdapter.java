package com.wisnu.datetimerangepickerandroid;

import static android.view.Gravity.CENTER_VERTICAL;
import static android.view.ViewGroup.LayoutParams.MATCH_PARENT;

import android.view.ContextThemeWrapper;
import android.widget.FrameLayout;
import android.widget.TextView;

public class DefaultDayViewAdapter implements DayViewAdapter {

    @Override
    public void makeCellView(CalendarCellView parent) {
        TextView textView = new TextView(new ContextThemeWrapper(parent.getContext(), R.style.CalendarCell_CalendarDate));
        textView.setDuplicateParentStateEnabled(true);

        parent.addView(textView, new FrameLayout.LayoutParams(MATCH_PARENT, 100, CENTER_VERTICAL));
        parent.setDayOfMonthTextView(textView);
    }
}
