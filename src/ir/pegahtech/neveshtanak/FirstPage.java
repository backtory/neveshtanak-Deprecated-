package ir.pegahtech.neveshtanak;

import ir.pegahtech.neveshtanak.fragments.BasicJomleFragment;
import ir.pegahtech.neveshtanak.fragments.LikedJomlesFragment;
import ir.pegahtech.neveshtanak.util.ui.PagerSlidingTabStrip;
import ir.pegahtech.saas.client.Neveshtanak.models.jomles.JomleEntity;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;

public class FirstPage extends ActionBarActivity {
	MyPagerAdapter adapter;
	private PagerSlidingTabStrip tabs;
	private ViewPager pager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.first_page);
		initViews();
	}

	private void initViews() {
		tabs = (PagerSlidingTabStrip) findViewById(R.id.tab_strip);
		pager = (ViewPager) findViewById(R.id.viewpager);
		List<Fragment> fragments = new ArrayList<Fragment>();
		fragments.add(new LikedJomlesFragment());
		fragments.add(new BasicJomleFragment(JomleEntity.COLUMN_CreationDate,
				false));
		fragments.add(new BasicJomleFragment(JomleEntity.COLUMN_LikeCount,
				false));
		adapter = new MyPagerAdapter(getSupportFragmentManager(), fragments);
		pager.setAdapter(adapter);
		tabs.setViewPager(pager);
		pager.setCurrentItem(2);
	}

	public class MyPagerAdapter extends FragmentPagerAdapter {

		List<Fragment> fragments;

		public MyPagerAdapter(FragmentManager fm, List<Fragment> fragmentList) {
			super(fm);
			this.fragments = fragmentList;
			if (fragments == null) {
				throw new NullPointerException("fragment list cannot be null");
			}
		}

		@Override
		public CharSequence getPageTitle(int position) {
			if (position == 2)
				return getString(R.string.best);
			else if (position == 1)
				return getString(R.string.my_wall);
			else
				return getString(R.string.favorite);
		}

		@Override
		public int getCount() {
			return fragments.size();
		}

		@Override
		public Fragment getItem(int position) {
			return fragments.get(position);
		}
	}
}
