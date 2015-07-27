package ir.pegahtech.neveshtanak.util.ui;

import ir.pegahtech.neveshtanak.R;
import ir.pegahtech.neveshtanak.UsersJomlesPage;
import ir.pegahtech.neveshtanak.util.DateModifier;
import ir.pegahtech.neveshtanak.util.data.DataHandler;
import ir.pegahtech.saas.client.Neveshtanak.models.jomlelikes.JomleLikeEntity;
import ir.pegahtech.saas.client.Neveshtanak.models.jomlelikes.JomleLikeListResponse;
import ir.pegahtech.saas.client.Neveshtanak.models.jomles.JomleEntity;
import ir.pegahtech.saas.client.Neveshtanak.services.JomleLikesService;
import ir.pegahtech.saas.client.Neveshtanak.services.JomlesService;
import ir.pegahtech.saas.client.shared.http.ServiceCallback;
import ir.pegahtech.saas.client.shared.models.Exp;
import ir.pegahtech.saas.client.shared.models.InsertUpdateResponse;
import ir.pegahtech.saas.client.shared.models.ListRequest;
import ir.pegahtech.saas.client.shared.models.QueryObject;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class JomleListAdapter extends BaseAdapter {
	private Fragment container;
	private Context context;
	private List<JomleEntity> jomleList;

	public JomleListAdapter(Fragment container) {
		jomleList = new ArrayList<JomleEntity>();
		context = container.getActivity();
		this.container = container;
	}

	public List<JomleEntity> geJomleEntities() {
		return jomleList;
	}

	@Override
	public int getCount() {
		return jomleList.size();
	}

	@Override
	public Object getItem(int position) {
		return jomleList.get(position);
	}

	@Override
	public long getItemId(int position) {
		return 0;
	}

	private void setItemView(View view, final JomleEntity jomle) {
		ImageView accountImage = (ImageView) view
				.findViewById(R.id.account_image);
		final ImageButton likeBtn = (ImageButton) view
				.findViewById(R.id.neveshtanak_like_pic), shareBtn = (ImageButton) view
				.findViewById(R.id.neveshtanak_share_pic);
		final TextView likeTv = (TextView) view
				.findViewById(R.id.neveshtanak_like_count), sender = (TextView) view
				.findViewById(R.id.neveshtanaker), date = (TextView) view
				.findViewById(R.id.likesAndComments), neveshtanak = (TextView) view
				.findViewById(R.id.neveshtanak);
		neveshtanak.setText(jomle.getJomle());
		accountImage.setImageDrawable(UiUtil.getInstance().getUserNameAsDrawable(jomle.getUserName(), context));
		likeTv.setText("" + jomle.getLikeCount());
		date.setText(new DateModifier(context).getStringTime(jomle
				.getCreationDate()));
		sender.setText(jomle.getUserName());
		likeBtn.setImageResource(DataHandler.getInstance(context).isLiked(
				jomle.getGuid()) ? R.drawable.liked : R.drawable.new_like);
		shareBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent sendIntent = new Intent();
				sendIntent.setAction(Intent.ACTION_SEND);
				sendIntent.putExtra(Intent.EXTRA_TEXT, jomle.getJomle());
				sendIntent.setType("text/plain");
				v.getContext().startActivity(sendIntent);
			}
		});
		likeBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if (DataHandler.getInstance(context).isLiked(jomle.getGuid())) {
					UiUtil.getInstance().toast(
							context.getString(R.string.liked_before), context);
					return;
				}
				ListRequest request = new ListRequest(0, 1, false, true,
						new QueryObject()).and(
						Exp.equalsTo(JomleLikeEntity.COLUMN_UserId, DataHandler
								.getInstance(context).getUserId())).and(
						Exp.equalsTo(JomleLikeEntity.COLUMN_Jomle, jomle
								.getGuid().toString()));
				final JomleLikesService likesService = new JomleLikesService();
				likesService.list(request,
						new ServiceCallback<JomleLikeListResponse>() {

							@Override
							public void success(JomleLikeListResponse result) {
								if (result.getTotalCount() > 0) {
									UiUtil.getInstance()
											.toast(context
													.getString(R.string.liked_before),
													context);
									return;
								}
								jomle.setLikeCount(jomle.getLikeCount() + 1);
								JomlesService jomlesService = new JomlesService();
								jomlesService
										.update(jomle,
												new ServiceCallback<InsertUpdateResponse>() {

													@Override
													public void success(
															InsertUpdateResponse result) {
													}

													@Override
													public void fail(
															int resultCode) {
													}
												});
								JomleLikeEntity likeEntity = new JomleLikeEntity();
								likeEntity.setJomle(jomle.getGuid());
								likeEntity.setUserId(DataHandler.getInstance(
										context).getUserId());
								likesService
										.create(likeEntity,
												new ServiceCallback<InsertUpdateResponse>() {

													@Override
													public void success(
															InsertUpdateResponse result) {
														UiUtil.getInstance()
																.toast(context
																		.getString(R.string.liked),
																		context);
														DataHandler
																.getInstance(
																		context)
																.like(jomle
																		.getGuid());
														likeTv.setText("" + jomle.getLikeCount());
														likeBtn.setImageResource(R.drawable.liked);
													}

													@Override
													public void fail(
															int resultCode) {
														UiUtil.getInstance()
																.showInternetProblem(
																		context);
													}
												});
							}

							@Override
							public void fail(int resultCode) {
								UiUtil.getInstance().showInternetProblem(
										context);
							}
						});
			}
		});
		accountImage.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(context, UsersJomlesPage.class);
				intent.putExtra("user-id", jomle.getUserId());
				intent.putExtra("user-name", jomle.getUserName());
				context.startActivity(intent);
			}
		});
		sender.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(context, UsersJomlesPage.class);
				intent.putExtra("user-id", jomle.getUserId());
				context.startActivity(intent);
			}
		});
	}

	private Drawable getNameImage(String userName) {
		return context.getResources()
				.getDrawable(R.drawable.ic_action_send_sms);
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View view;
		if (convertView == null) {
			view = new View(context);
			view = inflater.inflate(R.layout.layout_neveshtanak_item, null);
		} else {
			view = (View) convertView;
		}
		setItemView(view, jomleList.get(position));
		return view;
	}
}
