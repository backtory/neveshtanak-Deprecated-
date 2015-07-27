package ir.pegahtech.neveshtanak.fragments;

import android.view.View;
import ir.pegahtech.neveshtanak.util.ui.ChannelHeaderItem;
import ir.pegahtech.neveshtanak.util.ui.UiUtil;
import ir.pegahtech.saas.client.Neveshtanak.models.jomles.JomleEntity;
import ir.pegahtech.saas.client.Neveshtanak.models.jomles.JomleListResponse;
import ir.pegahtech.saas.client.shared.http.ServiceCallback;
import ir.pegahtech.saas.client.shared.models.Exp;
import ir.pegahtech.saas.client.shared.models.ListRequest;
import ir.pegahtech.saas.client.shared.models.QueryObject;

public class UserJomlesFragment extends BasicJomleFragment{
	private String userId, userName;
	private View headerView;
	public UserJomlesFragment(String userId, String userName){
		super(JomleEntity.COLUMN_CreationDate, false);
		this.userId = userId;
		this.userName = userName;
	}
	
	@Override
	protected void loadMore() {
		if (!existMore)
			return;
		int start = adapter.geJomleEntities().size();
		ListRequest request = new ListRequest(start, LOAD_SIZE, false, true,
				new QueryObject()).
				and(Exp.equalsTo(JomleEntity.COLUMN_UserId, userId)).addOrderBy(Exp.property(orderBy), isAsc);
		jomlesService.list(request, new ServiceCallback<JomleListResponse>() {

			@Override
			public void success(JomleListResponse result) {
				if (result.getTotalCount() < LOAD_SIZE) {
					existMore = false;
				}
				adapter.geJomleEntities().addAll(result.getData());
				adapter.notifyDataSetChanged();
				if (adapter.geJomleEntities().size() == 0)
					setVisiblity(NO_JOMLE);
				else
					setVisiblity(LOADED);
			}

			@Override
			public void fail(int resultCode) {
				UiUtil.getInstance().showInternetProblem(firstPage);
				if (adapter.geJomleEntities().size() == 0)
					setVisiblity(LOADING_ERROR);
			}
		});
	}
	
	@Override
	protected void initPage() {
		if(headerView != null)
			return;
		super.initPage();
		headerView = new ChannelHeaderItem(getActivity(), userName, userId).getV();
		listView.addHeaderView(headerView);
	}
}
