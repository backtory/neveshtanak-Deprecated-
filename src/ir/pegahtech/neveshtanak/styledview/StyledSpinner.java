package ir.pegahtech.neveshtanak.styledview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Spinner;

public class StyledSpinner extends Spinner{



	public StyledSpinner(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		// TODO Auto-generated constructor stub
	}

	public StyledSpinner(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
	}


	public StyledSpinner(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	private boolean isDropDownMenuShown;


	
	
	@Override
	public boolean performClick() {
	this.isDropDownMenuShown = true; //Flag to indicate the spinner menu is shown
	    return super.performClick();
	}
	
	public void setDropdownShown(boolean flag){
		this.isDropDownMenuShown = flag;
	}
	
	public boolean isDropdownShown(){
		return this.isDropDownMenuShown;
	}

}
