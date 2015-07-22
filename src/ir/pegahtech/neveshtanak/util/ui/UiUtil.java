package ir.pegahtech.neveshtanak.util.ui;

import ir.pegahtech.neveshtanak.R;
import android.content.Context;
import android.os.Handler;
import android.widget.Toast;

public class UiUtil {
	private static UiUtil _instance;
	private boolean isToasting = false;
	private final static int TOAST_DUR = 3500;
	
	public static UiUtil getInstance(){
		if(_instance == null)
			_instance = new UiUtil();
		return _instance;
	}
	
	public void showInternetProblem(Context context) {
		toast(context.getString(R.string.internet_error), context);
	}
	
	public void toast(String s, Context context){
		if(isToasting)
			return;
		isToasting = true;
		Handler h = new Handler();
		h.postDelayed(new Runnable() {
			
			@Override
			public void run() {
				isToasting = false;
			}
		}, TOAST_DUR);
		Toast.makeText(context, s,
				Toast.LENGTH_LONG).show();
	}
}
