package ir.pegahtech.neveshtanak.fragments;

import ir.pegahtech.neveshtanak.util.data.DataHandler;
import ir.pegahtech.neveshtanak.util.ui.UiUtil;
import ir.pegahtech.saas.client.Neveshtanak.models.jomlelikes.JomleLikeEntity;
import ir.pegahtech.saas.client.Neveshtanak.models.jomlelikes.JomleLikeListResponse;
import ir.pegahtech.saas.client.Neveshtanak.models.jomles.JomleEntity;
import ir.pegahtech.saas.client.shared.http.ServiceCallback;
import ir.pegahtech.saas.client.shared.models.Exp;
import ir.pegahtech.saas.client.shared.models.ListRequest;
import ir.pegahtech.saas.client.shared.models.QueryObject;

import java.util.ArrayList;
import java.util.List;

public class LikedJomlesFragment extends BasicJomleFragment {

	public LikedJomlesFragment() {
		super(JomleLikeEntity.COLUMN_CreationDate, false);
	}
	
	@Override
	protected void loadMore() {
		if (!existMore)
			return;
		int start = adapter.geJomleEntities().size();
		ListRequest request = new ListRequest(start, LOAD_SIZE, false, true,
				new QueryObject()).addOrderBy(Exp.property(orderBy), isAsc).
				includeObject(JomleLikeEntity.INCLUDE_RelatedJomle).
				and(Exp.equalsTo(JomleLikeEntity.COLUMN_UserId, DataHandler.getInstance(firstPage).getUserId()));
		likesService.list(request, new ServiceCallback<JomleLikeListResponse>() {
			
			@Override
			public void success(JomleLikeListResponse result) {
				if (result.getTotalCount() < LOAD_SIZE) {
					existMore = false;
				}
				List<JomleEntity> jomles = new ArrayList<JomleEntity>();
				for(JomleLikeEntity like : result.getData()){
					System.err.println(like.getRelatedJomle().getLikeCount());
					jomles.add(like.getRelatedJomle());
				}
				adapter.geJomleEntities().addAll(jomles);
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
}
