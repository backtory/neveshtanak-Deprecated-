package ir.pegahtech.neveshtanak;

import ir.pegahtech.neveshtanak.fragments.UserJomlesFragment;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

public class UsersJomlesPage extends ActionBarActivity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.user_jomles_page);
		String userId = getIntent().getStringExtra("user-id");
		String userName = getIntent().getStringExtra("user-name");
		getSupportFragmentManager().beginTransaction()
				.add(R.id.main, new UserJomlesFragment(userId, userName)).commit();
	}
}
