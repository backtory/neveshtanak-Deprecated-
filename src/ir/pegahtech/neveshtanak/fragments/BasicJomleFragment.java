package ir.pegahtech.neveshtanak.fragments;

import ir.pegahtech.neveshtanak.FirstPage;
import ir.pegahtech.neveshtanak.R;
import ir.pegahtech.neveshtanak.util.ui.JomleListAdapter;
import ir.pegahtech.neveshtanak.util.ui.UiUtil;
import ir.pegahtech.saas.client.neveshtanak.models.jomles.JomleEntity;
import ir.pegahtech.saas.client.neveshtanak.models.jomles.JomleListResponse;
import ir.pegahtech.saas.client.neveshtanak.services.JomlesService;
import ir.pegahtech.saas.client.shared.http.ServiceCallback;
import ir.pegahtech.saas.client.shared.models.Exp;
import ir.pegahtech.saas.client.shared.models.ListRequest;
import ir.pegahtech.saas.client.shared.models.QueryObject;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class BasicJomleFragment extends Fragment implements OnScrollListener {
	private static final int LOADING = 1;
	private static final int LOADING_ERROR = 2;
	private static final int NO_JOMLE = 3;
	private static final int LOADED = 4;
	private static final int LOAD_SIZE = 30;
	private JomleListAdapter adapter;
	private SwipeRefreshLayout swipeLayout;
	private TextView noJomle, loadingTv, loadingError;
	private Button refreshButton;
	private ListView listView;
	private View v;
	private String orderBy = JomleEntity.COLUMN_CreationDate;
	private boolean isAsc;
	private FirstPage firstPage;

	private int visibleThreshold = 5;
	private int currentPage = 0;
	private int previousTotal = 0;
	private boolean loading = true, existMore = true;

	private JomlesService jomlesService = new JomlesService();
	
	public BasicJomleFragment(String orderBy, boolean isAsc){
		this.orderBy = orderBy;
		this.isAsc = isAsc;
	}

	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		v = inflater.inflate(R.layout.jomle_list_fragment,
				container, false);
		firstPage = (FirstPage) getActivity();
		initPage();
		return v;
	}

	private void initPage() {
		loading = existMore = true;
		previousTotal = currentPage = 0;
		visibleThreshold = 5;
		swipeLayout = (SwipeRefreshLayout) v.findViewById(R.id.swipe_layout);
		noJomle = (TextView) v.findViewById(R.id.no_jomle);
		loadingTv = (TextView) v.findViewById(R.id.loading);
		loadingError = (TextView) v.findViewById(R.id.loading_error);
		refreshButton = (Button) v.findViewById(R.id.refresh);
		listView = (ListView) v.findViewById(R.id.list_view);
		adapter = new JomleListAdapter(this);
		listView.setAdapter(adapter);
		setListeners();
		loadMore();
	}

	private void setListeners() {
		refreshButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				initPage();
			}
		});
		swipeLayout.setOnRefreshListener(new OnRefreshListener() {

			@Override
			public void onRefresh() {
				initPage();
				swipeLayout.setRefreshing(false);
			}
		});
		listView.setOnScrollListener(this);
	}

	private void setVisiblity(int mode) {
		switch (mode) {
		case LOADED:
			noJomle.setVisibility(View.GONE);
			refreshButton.setVisibility(View.GONE);
			loadingError.setVisibility(View.GONE);
			loadingTv.setVisibility(View.GONE);
			swipeLayout.setVisibility(View.VISIBLE);
			break;
		case NO_JOMLE:
			noJomle.setVisibility(View.VISIBLE);
			refreshButton.setVisibility(View.GONE);
			loadingError.setVisibility(View.GONE);
			loadingTv.setVisibility(View.GONE);
			swipeLayout.setVisibility(View.GONE);
			break;
		case LOADING_ERROR:
			noJomle.setVisibility(View.GONE);
			refreshButton.setVisibility(View.VISIBLE);
			loadingError.setVisibility(View.VISIBLE);
			loadingTv.setVisibility(View.GONE);
			swipeLayout.setVisibility(View.GONE);
			break;
		case LOADING:
			noJomle.setVisibility(View.GONE);
			refreshButton.setVisibility(View.GONE);
			loadingError.setVisibility(View.GONE);
			loadingTv.setVisibility(View.VISIBLE);
			swipeLayout.setVisibility(View.GONE);
		default:
			noJomle.setVisibility(View.GONE);
			refreshButton.setVisibility(View.GONE);
			loadingError.setVisibility(View.GONE);
			loadingTv.setVisibility(View.VISIBLE);
			swipeLayout.setVisibility(View.GONE);
		}
	}

	private void loadMore() {
		if (!existMore)
			return;
		int start = adapter.geJomleEntities().size();
		ListRequest request = new ListRequest(start, LOAD_SIZE, false, true,
				new QueryObject()).addOrderBy(Exp.property(orderBy), isAsc);
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
				System.err.println(resultCode);
				if (adapter.geJomleEntities().size() == 0)
					setVisiblity(LOADING_ERROR);
			}
		});
	}

	@Override
	public void onScroll(AbsListView view, int firstVisibleItem,
			int visibleItemCount, int totalItemCount) {
		if (loading) {
			if (totalItemCount > previousTotal) {
				loading = false;
				previousTotal = totalItemCount;
				currentPage++;
			}
		}
		if (!loading
				&& (totalItemCount - visibleItemCount) <= (firstVisibleItem + visibleThreshold)) {
			loadMore();
			loading = true;
		}
	}

	@Override
	public void onScrollStateChanged(AbsListView view, int scrollState) {
	}
}