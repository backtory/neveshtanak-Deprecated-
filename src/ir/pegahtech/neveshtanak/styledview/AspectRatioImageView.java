package ir.pegahtech.neveshtanak.styledview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

public class AspectRatioImageView extends ImageView {

	public AspectRatioImageView(Context context) {
		super(context);
	}

	public AspectRatioImageView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public AspectRatioImageView(Context context, AttributeSet attrs,
			int defStyle) {
		super(context, attrs, defStyle);
	}

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		try {
			int width = MeasureSpec.getSize(widthMeasureSpec);
			int height = width * getDrawable().getIntrinsicHeight()
					/ getDrawable().getIntrinsicWidth();
			setMeasuredDimension(width, height);
			// super.onMeasure(widthMeasureSpec, heightMeasureSpec);
		} catch (NullPointerException e) {
			super.onMeasure(widthMeasureSpec, heightMeasureSpec);
			e.printStackTrace();
		}
	}
}
