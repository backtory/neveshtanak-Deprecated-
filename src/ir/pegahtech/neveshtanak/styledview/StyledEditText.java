package ir.pegahtech.neveshtanak.styledview;


import ir.pegahtech.neveshtanak.App;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.EditText;

public class StyledEditText extends EditText {

	public StyledEditText(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	public StyledEditText(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
	}

	public StyledEditText(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		// TODO Auto-generated constructor stub
	}

	
	
	@Override
	public void setText(CharSequence text, BufferType type) {
		// TODO Auto-generated method stub
		super.setText(text, type);
		
		App.fontAndReshape(this);
	}
	
	public void setPlainText(CharSequence text, BufferType type) {
		super.setText(text, type);
	}
	
}
