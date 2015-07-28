package ir.pegahtech.neveshtanak.util.ui;

import ir.pegahtech.neveshtanak.R;
import ir.pegahtech.neveshtanak.styledview.textdrawable.TextDrawable;

import java.util.Random;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.widget.Toast;

public class UiUtil {
	private static UiUtil _instance;
	private boolean isToasting = false;
	private final static int TOAST_DUR = 3500;

	public static UiUtil getInstance() {
		if (_instance == null)
			_instance = new UiUtil();
		return _instance;
	}

	public void showInternetProblem(Context context) {
		toast(context.getString(R.string.internet_error), context);
	}

	public void toast(String s, Context context) {
		if (isToasting)
			return;
		isToasting = true;
		Handler h = new Handler();
		h.postDelayed(new Runnable() {

			@Override
			public void run() {
				isToasting = false;
			}
		}, TOAST_DUR);
		Toast.makeText(context, s, Toast.LENGTH_LONG).show();
	}	

	public Drawable getUserNameAsDrawable(String userName, Context context) {
		Random rnd = new Random();
		TextDrawable drawable = null;
		if (userName == null)
			drawable = TextDrawable.builder().buildRound(
					"#",
					Color.argb(255, rnd.nextInt(256), rnd.nextInt(256),
							rnd.nextInt(256)));
		else
		drawable = TextDrawable.builder().buildRound(
				alphabetConverter(context, userName.charAt(0) + ""),
				Color.argb(255, rnd.nextInt(256), rnd.nextInt(256),
						rnd.nextInt(256)));

		return drawable;
	}

	private String alphabetConverter(Context context, String input) {
		String[] alphabet = context.getResources().getStringArray(
				R.array.alphabet);
		if (input.matches("[a-zA-Z]+"))
			return input;

		if (input.equals(alphabet[0]))
			return "A";
		else if (input.equals(alphabet[1]))
			return "B";

		else if (input.equals(alphabet[2]))
			return "P";

		else if (input.equals(alphabet[3]))
			return "T";

		else if (input.equals(alphabet[4]))
			return "S";

		else if (input.equals(alphabet[5]))
			return "J";

		else if (input.equals(alphabet[6]))
			return "CH";

		else if (input.equals(alphabet[7]))
			return "H";

		else if (input.equals(alphabet[8]))
			return "KH";

		else if (input.equals(alphabet[9]))
			return "D";

		else if (input.equals(alphabet[10]))
			return "Z";

		else if (input.equals(alphabet[11]))
			return "R";

		else if (input.equals(alphabet[12]))
			return "Z";

		else if (input.equals(alphabet[13]))
			return "ZH";

		else if (input.equals(alphabet[14]))
			return "S";

		else if (input.equals(alphabet[15]))
			return "SH";

		else if (input.equals(alphabet[16]))
			return "F";

		else if (input.equals(alphabet[17]))
			return "GH";

		else if (input.equals(alphabet[18]))
			return "K";

		else if (input.equals(alphabet[19]))
			return "G";

		else if (input.equals(alphabet[20]))
			return "L";

		else if (input.equals(alphabet[21]))
			return "M";

		else if (input.equals(alphabet[22]))
			return "N";

		else if (input.equals(alphabet[23]))
			return "V";

		else if (input.equals(alphabet[24]))
			return "H";

		else if (input.equals(alphabet[25]))
			return "Y";

		else
			return "#";
	}
}
