package ir.pegahtech.neveshtanak;

import ir.pegahtech.neveshtanak.styledview.StyledDialog;
import ir.pegahtech.neveshtanak.util.data.DataHandler;
import ir.pegahtech.neveshtanak.util.ui.UiUtil;
import ir.pegahtech.saas.client.Neveshtanak.models.jomles.JomleEntity;
import ir.pegahtech.saas.client.Neveshtanak.services.JomlesService;
import ir.pegahtech.saas.client.shared.http.ServiceCallback;
import ir.pegahtech.saas.client.shared.models.InsertUpdateResponse;
import android.app.Dialog;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class PostPage extends ActionBarActivity {
	private static final int MAX_LETTERS = 256;
	private ImageView accountImage;
	private TextView remainingLetters;
	private EditText text;
	private Button btnSend;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.post_layout);
		initViews();
		setListeners();
	}

	private void initViews() {
		btnSend = (Button) findViewById(R.id.btn_send);
		accountImage = (ImageView) findViewById(R.id.account_image);
		remainingLetters = (TextView) findViewById(R.id.count);
		remainingLetters.setText(getString(R.string.remaining_letters)
				+ MAX_LETTERS);
		remainingLetters.setTypeface(Typeface.createFromAsset(getAssets(),
				"Yekan.ttf"));
		text = (EditText) findViewById(R.id.edit);
		accountImage.setImageDrawable(UiUtil.getInstance()
				.getUserNameAsDrawable(
						DataHandler.getInstance(this).getUserName(), this));
	}

	private void setListeners() {
		btnSend.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				sendJomle(text.getText().toString());
			}
		});

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
				remainingLetters.setTypeface(Typeface.createFromAsset(
						getAssets(), "Yekan.ttf"));
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
						finish();
					}

					@Override
					public void fail(int resultCode) {
						UiUtil.getInstance().showInternetProblem(PostPage.this);
					}
				});
	}

	private void showGetUserNameDialog() {
		final Dialog signUpDialog = new StyledDialog(this);
		signUpDialog.setContentView(R.layout.dialog_signup);
		Button cancelBtn = (Button) signUpDialog.findViewById(R.id.btn_cancel), okBtn = (Button) signUpDialog
				.findViewById(R.id.btn_ok);
		final EditText name = (EditText) signUpDialog
				.findViewById(R.id.lbl_dialog_text_camera);
		cancelBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				signUpDialog.dismiss();
			}
		});
		okBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				DataHandler.getInstance(PostPage.this).saveUserName(
						name.getText().toString());
				accountImage.setImageDrawable(UiUtil.getInstance()
						.getUserNameAsDrawable(name.getText().toString(),
								PostPage.this));
				signUpDialog.dismiss();
			}
		});
		signUpDialog.show();
	}
}
