package ir.pegahtech.neveshtanak;

import ir.pegahtech.neveshtanak.util.data.DataHandler;
import ir.pegahtech.neveshtanak.util.ui.UiUtil;
import ir.pegahtech.saas.client.Neveshtanak.models.jomles.JomleEntity;
import ir.pegahtech.saas.client.Neveshtanak.services.JomlesService;
import ir.pegahtech.saas.client.shared.http.ServiceCallback;
import ir.pegahtech.saas.client.shared.models.InsertUpdateResponse;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class PostPage extends ActionBarActivity {
	private static final int MAX_LETTERS = 256;
	private ImageView accountImage;
	private TextView remainingLetters;
	private EditText text;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.post_layout);
		initViews();
		setListeners();
	}

	private void initViews() {
		accountImage = (ImageView) findViewById(R.id.account_image);
		remainingLetters = (TextView) findViewById(R.id.count);
		remainingLetters.setText(getString(R.string.remaining_letters) + MAX_LETTERS);
		text = (EditText) findViewById(R.id.edit);
		accountImage.setImageDrawable(UiUtil.getInstance()
				.getUserNameAsDrawable(
						DataHandler.getInstance(this).getUserName(), this));
	}

	private void setListeners() {
		text.addTextChangedListener(new TextWatcher() {

			@Override
			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
			}

			@Override
			public void afterTextChanged(Editable s) {
				remainingLetters.setText(getString(R.string.remaining_letters)
						+ (MAX_LETTERS - text.getText().toString().length()));
			}
		});
	}

	private void sendJomle(String jomle) {
		if (DataHandler.getInstance(this).getUserName() == null) {
			showGetUserNameDialog();
			return;
		}
		JomlesService jomlesService = new JomlesService();
		JomleEntity jomleEntity = new JomleEntity();
		jomleEntity.setJomle(jomle);
		jomleEntity.setLikeCount(0);
		jomleEntity.setUserId(DataHandler.getInstance(this).getUserId());
		jomleEntity.setUserName(DataHandler.getInstance(this).getUserName());
		jomlesService.create(jomleEntity,
				new ServiceCallback<InsertUpdateResponse>() {

					@Override
					public void success(InsertUpdateResponse result) {
						UiUtil.getInstance().toast(getString(R.string.sent),
								PostPage.this);
					}

					@Override
					public void fail(int resultCode) {
						UiUtil.getInstance().showInternetProblem(PostPage.this);
					}
				});
	}

	private void showGetUserNameDialog() {
		// TODO Auto-generated method stub
//		String name = "khashi";
//		DataHandler.getInstance(this).saveUserName(name);
	}
}
