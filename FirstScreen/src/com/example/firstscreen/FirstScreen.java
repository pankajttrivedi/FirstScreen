package com.example.firstscreen;

import java.util.Locale;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.PaintDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.NavUtils;
import android.support.v4.view.ViewPager;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class FirstScreen extends FragmentActivity {

	/**
	 * The {@link android.support.v4.view.PagerAdapter} that will provide
	 * fragments for each of the sections. We use a
	 * {@link android.support.v4.app.FragmentPagerAdapter} derivative, which
	 * will keep every loaded fragment in memory. If this becomes too memory
	 * intensive, it may be best to switch to a
	 * {@link android.support.v4.app.FragmentStatePagerAdapter}.
	 */
	SectionsPagerAdapter mSectionsPagerAdapter;

	/**
	 * The {@link ViewPager} that will host the section contents.
	 */
	ViewPager mViewPager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		// Create the adapter that will return a fragment for each of the three
		// primary sections of the app.
		mSectionsPagerAdapter = new SectionsPagerAdapter(
				getSupportFragmentManager());

		// Set up the ViewPager with the sections adapter.
		mViewPager = (ViewPager) findViewById(R.id.pager);
		mViewPager.setAdapter(mSectionsPagerAdapter);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.first_screen, menu);
		return true;
	}

	/**
	 * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
	 * one of the sections/tabs/pages.
	 */
	public class SectionsPagerAdapter extends FragmentPagerAdapter {

		public SectionsPagerAdapter(FragmentManager fm) {
			super(fm);
		}

		@Override
		public Fragment getItem(int position) {
			// getItem is called to instantiate the fragment for the given page.
			// Return a DummySectionFragment (defined as a static inner class
			// below) with the page number as its lone argument.
			Fragment fragment = new DummySectionFragment();
			Bundle args = new Bundle();
			args.putInt(DummySectionFragment.ARG_SECTION_NUMBER, position + 1);
			fragment.setArguments(args);
			return fragment;
		}

		@Override
		public int getCount() {
			// Show 3 total pages.
			return 4;
		}

		@Override
		public CharSequence getPageTitle(int position) {
			Locale l = Locale.getDefault();
			switch (position) {
			case 0:
				return getString(R.string.title_section1).toUpperCase(l);
			case 1:
				return getString(R.string.title_section2).toUpperCase(l);
			case 2:
				return getString(R.string.title_section3).toUpperCase(l);
			}
			return null;
		}
	}

	/**
	 * A dummy fragment representing a section of the app, but that simply
	 * displays dummy text.
	 */
	public static class DummySectionFragment extends Fragment {
		/**
		 * The fragment argument representing the section number for this
		 * fragment.
		 */
		public static final String ARG_SECTION_NUMBER = "section_number";

		public DummySectionFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {

			int pageNumber=getArguments().getInt(ARG_SECTION_NUMBER);


			View rootView = inflater.inflate(
					R.layout.fragment_first_screen_dummy, container, false);
			TextView dummyTextView = (TextView) rootView
					.findViewById(R.id.section_label);
			TextView dummy=(TextView)rootView.findViewById(R.id.section_label2);
			rootView.setBackgroundColor(Color.WHITE);
			TextView dummyTwo=(TextView)rootView.findViewById(R.id.section_label3);
			TextView dummyThree=(TextView)rootView.findViewById(R.id.section_label4);
			if (pageNumber==1)
			{
				dummy.setText("Learn");
				dummy.setTextColor(Color.parseColor("#30B2EA"));
				dummy.setTextSize(40);
				dummy.setTypeface(Typeface.DEFAULT);
				dummyThree.setText("Idea Management");
				dummyThree.setTextColor(Color.parseColor("#30B2EA"));
				dummyThree.setTypeface(Typeface.DEFAULT);
				dummyTwo.setText("Find the idea that works best for you");

			}
			if (pageNumber==2)
			{
				dummy.setText("Capture");
				dummy.setTextColor(Color.parseColor("#30B2EA"));
				dummy.setTextSize(40);
				dummy.setTypeface(Typeface.DEFAULT);
				dummyThree.setText("On the move");
				dummyThree.setTextColor(Color.parseColor("#30B2EA"));
				dummyThree.setTypeface(Typeface.DEFAULT);
				dummyTwo.setText("All your idea at one place");

			}
			if (pageNumber==3)
			{
				dummy.setText("Start");
				dummy.setTextColor(Color.parseColor("#30B2EA"));
				dummy.setTextSize(40);
				dummy.setTypeface(Typeface.DEFAULT);
				dummyThree.setText("Innovation on the go");
				dummyThree.setTextColor(Color.parseColor("#30B2EA"));
				dummyThree.setTypeface(Typeface.DEFAULT);
				dummyTwo.setText("Incubatize your first idea now");
			}
			if (pageNumber==4)
			{
				rootView = inflater.inflate(
						R.layout.login, container, false);
				rootView.setBackgroundColor(Color.WHITE);
				TextView link=(TextView)rootView.findViewById(R.id.textView1);

				link.setClickable(true);
				link.setMovementMethod(LinkMovementMethod.getInstance());
				String text = "<a href='http://www.google.com'> " +link.getText()+" </a>";
				link.setText(Html.fromHtml(text));
				//link.setTextColor(Color.BLACK);
				link.setTextSize(11);

				Button myButton = (Button)rootView.findViewById(R.id.button1);
				myButton.setBackgroundDrawable(new PaintDrawable(Color.parseColor("#31B2EA")));
			}
			return rootView;
		}
	}

}
