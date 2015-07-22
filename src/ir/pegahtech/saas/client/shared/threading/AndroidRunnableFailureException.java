package ir.pegahtech.saas.client.shared.threading;

public class AndroidRunnableFailureException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = -264974769600456353L;

	private int what;
	
	public AndroidRunnableFailureException(int what) {
		super();
		setWhat(what);
	}
	
	public AndroidRunnableFailureException(String msg, int what) {
		super(msg);
		setWhat(what);
	}
	
	public AndroidRunnableFailureException(Exception ex, int what) {
		super(ex);
		setWhat(what);
	}

	public int getWhat() {
		return what;
	}

	public void setWhat(int what) {
		this.what = what;
	}
}
