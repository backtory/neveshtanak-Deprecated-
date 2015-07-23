package ir.pegahtech.neveshtanak;

import java.util.Calendar;
import java.util.Date;
import ir.pegahtech.neveshtanak.R;


import android.content.Context;

public class DateModifier {

	Context mContext;
	Date now;
	String timeStamp;
	long diff;
	CalendarTool calendar;
	Calendar MiladiCal;

	public DateModifier(Context context) {
		this.mContext = context;
		now = new Date();
		timeStamp = mContext.getResources().getString(R.string.app_name);
		calendar = new CalendarTool();

	}

	public String getStringTime(Date time) {
		long dif = (now.getTime()) - (time.getTime());
		dif /= 1000;
		if (dif < 60) {
			timeStamp = " "
					+ mContext.getResources().getString(
							R.string.time_afew_seconds_ago);
		} else {
			dif /= 60;
			if (dif < 60) {
				timeStamp = (dif + " " + mContext.getResources().getString(
						R.string.time_min_ago));
			} else {
				dif /= 60;
				if (dif < 24) {
					timeStamp = dif
							+ " "
							+ mContext.getResources().getString(
									R.string.time_hours_ago);
				} else {
					dif /= 24;
					if (dif < 7) {
						timeStamp = dif
								+ " "
								+ mContext.getResources().getString(
										R.string.time_days_ago);
					} else {
						dif /= 7;
						if (dif < 4) {
							timeStamp = dif
									+ " "
									+ mContext.getResources().getString(
											R.string.time_weeks_ago);
						} else {
							dif /= 4;
							if (dif < 12) {
								timeStamp = dif
										+ " "
										+ mContext.getResources().getString(
												R.string.time_months_ago);
							} else {
								dif /= 12;
								timeStamp = dif
										+ " "
										+ mContext.getResources().getString(
												R.string.time_years_ago);
							}
						}
					}
				}
			}
		}

		return timeStamp;
	}
}
