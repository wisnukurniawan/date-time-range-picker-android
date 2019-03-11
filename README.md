Date Time Range Picker for Android customize from [android-times-square](https://github.com/square/android-times-square)
==========================

Standalone Android widget for picking a single date from a calendar view.

<img src="https://github.com/wisnukurniawan/date-time-range-picker-android/blob/master/screenshot.png" width="300" height="533" />

## Installation
### Via Gradle
Add it in your root build.gradle at the end of repositories:

```
allprojects {
	repositories {
		...
		maven { url 'https://jitpack.io' }
	}
}
```
Add the dependency:

```
dependencies {
	implementation "com.github.wisnukurniawan:date-time-range-picker-android:${version}"
}

```

## Usage
-----

Include `CalendarPickerView` in your layout XML.

```xml
<com.wisnu.datetimerangepickerandroid.CalendarPickerView
    android:id="@+id/calendar_view"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    />
```

Default implementation to show Calendar

```java
calendar.init(today, nextYear.getTime())
    .inMode(RANGE);
```


To show the Calendar

```java
Calendar nextYear = Calendar.getInstance();
nextYear.add(Calendar.YEAR, 1);

CalendarPickerView calendar = (CalendarPickerView) findViewById(R.id.calendar_view);
Date today = new Date();
calendar.init(today, nextYear.getTime())
    .withSelectedDate(today);
```

## Proguard
No configuration needed.
