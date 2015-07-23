package ir.pegahtech.neveshtanak.styledview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

public class StyledRelativeLayout extends RelativeLayout {

	public StyledRelativeLayout(Context context, AttributeSet attrs,
			int defStyle) {
		super(context, attrs, defStyle);
	}

	public StyledRelativeLayout(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public StyledRelativeLayout(Context context) {
		super(context);
	}
	
//	@Override
//	public boolean onInterceptTouchEvent(MotionEvent ev) {
//		 super.onInterceptTouchEvent(ev);
//		 ImageButton ibPlay = (ImageButton) findViewById(R.id.btn_playlistadd);
//		 return true;
//	}

}
