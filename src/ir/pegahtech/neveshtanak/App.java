package ir.pegahtech.neveshtanak;

import ir.pegahtech.neveshtanak.styledview.StyledButton;
import ir.pegahtech.neveshtanak.styledview.StyledEditText;
import ir.pegahtech.neveshtanak.styledview.StyledTextView;
import ir.pegahtech.neveshtanak.util.data.DataHandler;
import ir.pegahtech.saas.client.neveshtanak.NeveshtanakConfiguration;
import ir.pegahtech.saas.client.shared.conf.SaaSDataProvider;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import android.app.Activity;
import android.app.Application;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.SpannableString;
import android.text.SpannedString;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import android.widget.Toast;

public class App extends Application {
	public static boolean isTokenInvalid = false;
	public static Context mContext;
	private static Resources mResources;
	private static Typeface mFont;
	private static int width = -1;
	private static ProgressDialog dialog;

	private static boolean isShown = false;

	@Override
	public void onCreate() {
		super.onCreate();
		mContext = getApplicationContext();
		NeveshtanakConfiguration.initialize(getCacheDir(), new SaaSDataProvider() {
			private Handler handler;
			
			@Override
			public void save(String key, String value) {
				DataHandler.getInstance(mContext).save(key, value);
			}
			
			@Override
			public void runOnMainThread(Runnable runnable) {
				handler = new Handler(Looper.getMainLooper()){
					@Override
					public void handleMessage(Message msg) {
						super.handleMessage(msg);
					}
				};
				handler.post(runnable);
			}
			
			@Override
			public String load(String key) {
				return DataHandler.getInstance(mContext).get(key);
			}

			@Override
			public boolean keyExists(String key) {
				return DataHandler.getInstance(mContext).get(key) != null;
			}

			@Override
			public void remove(String key) {
				DataHandler.getInstance(mContext).remove(key);
			}
		});
	}

	public static boolean isShown() {
		return isShown;
	}

	public static void setShown(boolean flag) {
		isShown = flag;
	}

	public static int getDpSize(int size) {
		DisplayMetrics metrics = mContext.getResources().getDisplayMetrics();
		int pixels = (int) (metrics.density * size + 0.5f);
		return pixels;
	}

	public static Resources resources() {
		if (mResources == null) {
			mResources = mContext.getResources();
		}
		return mResources;
	}

	public static String[] getReshapedArray(int Id) {
		CharSequence[] array = resources().getTextArray(Id);
		String[] output = new String[array.length];
		for (int i = 0; i < array.length; i++) {

			output[i] = (String) array[i];
		}
		return output;
	}

	public static String getReshapedText(String text) {
		return text;
	}

	public static String getReshapedText(int rId) {
		String text = (String) resources().getText(rId);
		return getReshapedText(text);
	}

	public static String getResourceText(int rId) {
		return (String) resources().getText(rId);
	}

	public static Typeface getFont(String fontFamily) {
		if (mFont == null) {
			mFont = Typeface.createFromAsset(mContext.getAssets(), "Yekan.ttf");
		}
		return mFont;
	}

	public static boolean isLatin(String input) {
		if (input == null)
			return false;
		return input.matches("^[a-z][A-Z] \\@\\#\\$\\!\\.]$");
	}

	public static void fontAndReshape(TextView tv) {
		String text = "";

		if (tv.getText() instanceof SpannedString) {
			text = ((SpannedString) tv.getText()).toString();
		} else if (tv.getText() instanceof SpannableString) {
			text = ((SpannableString) tv.getText()).toString();
		} else {
			text = (String) tv.getText();
		}

		if (tv instanceof StyledTextView)
			((StyledTextView) tv).setPlainText(text, BufferType.NORMAL);
		else if (tv instanceof StyledButton)
			((StyledButton) tv).setPlainText(text, BufferType.NORMAL);
		else if (tv instanceof StyledEditText)
			((StyledEditText) tv).setPlainText(text, BufferType.NORMAL);

		tv.setTypeface(getFont("Yekan"));
		tv.setTextSize(TypedValue.COMPLEX_UNIT_SP, 16);

	}

	public static void fontAndReshape(EditText txt) {
		String text = (String) txt.getHint();
		txt.setHint(getReshapedText(text));
		txt.setTypeface(getFont(isLatin(text) ? "Yekan" : "Yekan"));
	}

	public static void toast(final String message, final boolean top) {
		Handler h = new Handler(mContext.getMainLooper());

		h.post(new Runnable() {

			@Override
			public void run() {
				String msg = App.getReshapedText(message);
				Toast toast = Toast.makeText(mContext, msg, Toast.LENGTH_SHORT);
				if (top)
					toast.setGravity(Gravity.TOP | Gravity.CENTER_HORIZONTAL,
							0, getDpSize(45));
				toast.show();
			}
		});
	}

	public static void toast(int rId) {
		String msg = App.getReshapedText(rId);
		App.toast(msg, false);
	}

	public static void toastUp(int rId) {
		String msg = App.getReshapedText(rId);
		App.toast(msg, true);
	}

	public static int getScreenWidth() {
		DisplayMetrics metrics = mContext.getResources().getDisplayMetrics();
		width = metrics.widthPixels;
		return width;
	}

	public static Context getContext() {
		return mContext;
	}

	public static String getRawResource(int rId) {
		String text = "";
		try {
			InputStream is = resources().openRawResource(rId);
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			String line = null;
			while ((line = br.readLine()) != null) {
				text += line;
			}
		} catch (Exception ex) {
			text = "";
		}
		return text;
	}

	public static ProgressDialog getDialog() {
		return dialog;
	}

	public static void setDialog(ProgressDialog dlg) {
		dialog = dlg;
	}

	public static String limitedString(String str, int limitation) {
		if (str == null || str.length() <= limitation)
			return str;
		return str.substring(0, limitation - 3) + "...";
	}

	public static void hideSoftKeyboard(Activity activity) {
		try {
			InputMethodManager inputMethodManager = (InputMethodManager) activity
					.getSystemService(Activity.INPUT_METHOD_SERVICE);
			inputMethodManager.hideSoftInputFromWindow(activity
					.getCurrentFocus().getWindowToken(), 0);
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
	}

	public static boolean isOnline() {
		ConnectivityManager cm = (ConnectivityManager) mContext
				.getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo netInfo = cm.getActiveNetworkInfo();
		if (netInfo != null && netInfo.isConnected()) {
			return true;
		} else {
			return false;
		}
	}

	public static float pixelsToSp(Float px) {
		float scaledDensity = mContext.getResources().getDisplayMetrics().scaledDensity;
		return px / scaledDensity;
	}

	public static int spToPixels(float sp) {
		float scaledDensity = mContext.getResources().getDisplayMetrics().scaledDensity;
		return (int) (sp * scaledDensity);
	}

	public static int dipToPixels(float dipValue) {
		DisplayMetrics metrics = mContext.getResources().getDisplayMetrics();
		return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
				dipValue, metrics);
	}

	public static void runOnUiThread(Context context, Runnable runnable) {
		Handler handle = new Handler(context.getMainLooper());
		handle.post(runnable);
	}
}
