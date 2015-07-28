package ir.pegahtech.neveshtanak.util.ui;

import java.util.Date;

import ir.pegahtech.neveshtanak.R;
import ir.pegahtech.neveshtanak.util.DateModifier;
import ir.pegahtech.saas.client.Neveshtanak.models.jomlelikes.JomleLikeEntity;
import ir.pegahtech.saas.client.Neveshtanak.models.jomlelikes.JomleLikeListResponse;
import ir.pegahtech.saas.client.Neveshtanak.models.jomles.JomleEntity;
import ir.pegahtech.saas.client.Neveshtanak.models.jomles.JomleListResponse;
import ir.pegahtech.saas.client.Neveshtanak.services.JomleLikesService;
import ir.pegahtech.saas.client.Neveshtanak.services.JomlesService;
import ir.pegahtech.saas.client.shared.http.ServiceCallback;
import ir.pegahtech.saas.client.shared.models.Exp;
import ir.pegahtech.saas.client.shared.models.ListRequest;
import ir.pegahtech.saas.client.shared.models.QueryObject;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ChannelHeaderItem {
	private Activity ac;
	private ImageView nameImage;
	private TextView name, jomlesCount, likesCount, lastActivity;
	private String userName, userId;
	private JomlesService jomlesService;
	private JomleLikesService likesService;
	private long lastActivityDate = 0;
	private View v;

	public ChannelHeaderItem(Activity ac, String userName, String userId) {
		this.ac = ac;
		this.userName = userName;
		this.userId = userId;
		jomlesService = new JomlesService();
		likesService = new JomleLikesService();
		getJomlesCountAndSetLastActivity();
		getLikesCountAndSetLastActivity();
		initView();
	}

	private void initView() {
		LayoutInflater inflater = (LayoutInflater) ac
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		v = new View(ac);
		v = inflater.inflate(R.layout.profile_header, null);
		nameImage = (ImageView)v.findViewById(R.id.name_image);
		name = (TextView)v.findViewById(R.id.txt_title);
		jomlesCount = (TextView)v.findViewById(R.id.txt_jomles);
		likesCount = (TextView)v.findViewById(R.id.txt_likes);
		lastActivity = (TextView)v.findViewById(R.id.txt_latest_activity);
		
		//////////// setting values!!!!!////////////
		nameImage.setImageDrawable(UiUtil.getInstance().getUserNameAsDrawable(userName, ac));
		name.setText(userName);
		jomlesCount.setText("-");
		likesCount.setText("-");
		lastActivity.setText("-");
	}
	
	private void updateLastActivityDate(Long lastTime){
		if(lastActivityDate != 0 && lastTime != null){
			lastActivityDate = Math.max(lastActivityDate, lastTime);
			lastActivity.setText(new DateModifier(ac).getStringTime(new Date(lastActivityDate)));
		}
		if(lastActivityDate == 0 && lastTime != null){
			lastActivityDate = lastTime;
		}
		if(lastActivityDate != 0 && lastTime == null){
			if(lastActivityDate > 0)
				lastActivity.setText(new DateModifier(ac).getStringTime(new Date(lastActivityDate)));
		}
		if(lastActivityDate == 0 && lastTime == null){
			lastActivityDate = -1;
		}
	}

	private void getLikesCountAndSetLastActivity() {
		ListRequest request = new ListRequest(0, 1, false, true, new QueryObject()).
				and(Exp.equalsTo(JomleLikeEntity.COLUMN_UserId, userId)).
				addOrderBy(Exp.property(JomleLikeEntity.COLUMN_CreationDate), false);
		likesService.list(request,
				new ServiceCallback<JomleLikeListResponse>() {

					@Override
					public void success(JomleLikeListResponse result) {
						likesCount.setText(result.getTotalCount().toString());
						Long lastTime = null;
						if(result.getData().size() > 0)
							lastTime = result.getData().get(0).getCreationDate().getTime();
						updateLastActivityDate(lastTime);
					}

					@Override
					public void fail(int resultCode) {
					}
				});
	}

	private void getJomlesCountAndSetLastActivity() {
		ListRequest request = new ListRequest(0, 1, false, true, new QueryObject()).
				and(Exp.equalsTo(JomleEntity.COLUMN_UserId, userId)).
				addOrderBy(Exp.property(JomleEntity.COLUMN_CreationDate), false);
		jomlesService.list(request, new ServiceCallback<JomleListResponse>() {
			
			@Override
			public void success(JomleListResponse result) {
				jomlesCount.setText(result.getTotalCount().toString());
				Long lastTime = null;
				if(result.getData().size() > 0)
					lastTime = result.getData().get(0).getCreationDate().getTime();
				updateLastActivityDate(lastTime);
			}
			
			@Override
			public void fail(int resultCode) {
			}
		});
	}

	public View getV() {
		return v;
	}

	public void setV(View v) {
		this.v = v;
	}
}
