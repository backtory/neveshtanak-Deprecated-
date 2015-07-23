package ir.pegahtech.neveshtanak.styledview;

import ir.pegahtech.neveshtanak.App;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

public class StyledTextView extends TextView {

	public StyledTextView(Context context) {
		super(context);
	}

	public StyledTextView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public StyledTextView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	}

	@Override
	public void setText(CharSequence text, BufferType type) {
		super.setText(text, type);
		App.fontAndReshape(this);
	}

	public void setPlainText(CharSequence text, BufferType type) {
		super.setText(text, type);
	}

}
