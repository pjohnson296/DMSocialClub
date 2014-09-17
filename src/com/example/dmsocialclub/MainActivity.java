//Social club app
//Authors: Paxten Johnson, Joe Snee, Alex Peterson

package com.example.dmsocialclub;

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;

//sliding tabs will be implemented soon!
public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//setContentView(R.layout.activity_main);

		// setup action bar for tabs
		ActionBar actionBar = getActionBar();
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		actionBar.setDisplayShowTitleEnabled(false);

		Tab tab = actionBar.newTab()
				.setText(R.string.action_month)
				.setTabListener(new TabListener<MonthFragment>(
						this, "this month", MonthFragment.class));
		actionBar.addTab(tab);

		Tab tab1 = actionBar.newTab()
				.setText(R.string.action_today)
				.setTabListener(new TabListener<TodayFragment>(
						this, "today", TodayFragment.class));
		actionBar.addTab(tab1);
		
		tab = actionBar.newTab()
				.setText(R.string.action_week)
				.setTabListener(new TabListener<WeekFragment>(
						this, "this week", WeekFragment.class));
		actionBar.addTab(tab);
		actionBar.selectTab(tab1);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public void openAboutUs() {
		Intent intent = new Intent(this, AboutActivity.class);
		startActivity(intent);
	}
	
	public void openToday() {
		Intent intent = new Intent(this, TodayFragment.class);
		startActivity(intent);
	}
	public void openMonth() {
		Intent intent = new Intent(this, MonthFragment.class);
		startActivity(intent);
	}
	public void openCategories() {
		Intent intent = new Intent(this, CategoriesActivity.class);
		startActivity(intent);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		switch (id) {
		case R.id.action_about:
			openAboutUs();
			return true;
		case R.id.action_categories:
			openCategories();
			return true;
//		case R.id.action_month:
//			openMonth();
//			return true;
//		case R.id.action_today:
//			openToday();
//			return true;
		default:
		}
		//        if (id == R.id.action_settings) {
		//            return true;
		//        }
		return super.onOptionsItemSelected(item);
	}

	public static class TabListener<T extends Fragment> implements android.app.ActionBar.TabListener {
		private Fragment mFragment;
		private final Activity mActivity;
		private final String mTag;
		private final Class<T> mClass;

		/** Constructor used each time a new tab is created.
		 * @param activity  The host Activity, used to instantiate the fragment
		 * @param tag  The identifier tag for the fragment
		 * @param clz  The fragment's Class, used to instantiate the fragment
		 */
		public TabListener(Activity activity, String tag, Class<T> clz) {
			mActivity = activity;
			mTag = tag;
			mClass = clz;
		}

		/* The following are each of the ActionBar.TabListener callbacks */

		public void onTabSelected(Tab tab, FragmentTransaction ft) {
			// Check if the fragment is already initialized
			if (mFragment == null) {
				// If not, instantiate and add it to the activity
				mFragment = Fragment.instantiate(mActivity, mClass.getName());
				ft.add(android.R.id.content, mFragment, mTag);
			} else {
				// If it exists, simply attach it in order to show it
				ft.attach(mFragment);
			}
		}

		public void onTabUnselected(Tab tab, FragmentTransaction ft) {
			if (mFragment != null) {
				// Detach the fragment, because another one is being attached
				ft.detach(mFragment);
			}
		}

		public void onTabReselected(Tab tab, FragmentTransaction ft) {
			// User selected the already selected tab. Usually do nothing.
		}
	}
	public void changeToDanceImage (View view) {
		ImageButton imgBut = (ImageButton) findViewById(R.id.imageView1);
		
		imgBut.setImageResource(R.drawable.dance_category);
	}
	public void changeToTwitterImage (View view) {
		ImageButton imgBut2 = (ImageButton) findViewById(R.id.aerial);
		
		imgBut2.setImageResource(R.drawable.tweet_screen);
	}

	
	public void loadCircus(View view) {
		ImageView circus = (ImageView) findViewById(R.id.circusJam);
		ImageView tempImageView = circus;
		AlertDialog.Builder imageDialog = new AlertDialog.Builder(this);
		LayoutInflater inflater = (LayoutInflater) this.getSystemService(LAYOUT_INFLATER_SERVICE);
		
		View layout = inflater.inflate(R.layout.sundaycircus, (ViewGroup) findViewById(R.id.circusLayout));
		ImageView image = (ImageView) layout.findViewById(R.id.circusJam);
		//image.setImageDrawable(tempImageView.getDrawable());
		imageDialog.setView(layout);
		
		imageDialog.create();
		imageDialog.show();
	}
	public void loadAerial(View view) {
		ImageView aerial = (ImageView) findViewById(R.id.aerial);
		ImageView tempImageView = aerial;
		AlertDialog.Builder imageDialog = new AlertDialog.Builder(this);
		LayoutInflater inflater = (LayoutInflater) this.getSystemService(LAYOUT_INFLATER_SERVICE);
		
		View layout = inflater.inflate(R.layout.aerial, (ViewGroup) findViewById(R.id.aerialLayout));
		ImageView image = (ImageView) layout.findViewById(R.id.aerial);
		//image.setImageDrawable(tempImageView.getDrawable());
		imageDialog.setView(layout);
		
		imageDialog.create();
		imageDialog.show();
	}
//	
//	public void loadEvent (ImageView imageView, int resource, int layout, int width, int height){
//		ImageView tempImageView = imageView;
//		AlertDialog.Builder imageDialog = new AlertDialog.Builder(this);
//		LayoutInflater inflater = (LayoutInflater) this.getSystemService(LAYOUT_INFLATER_SERVICE);
//		
//		View layout = inflater.inflate(R.layout.sundaycircus, (ViewGroup) findViewById(R.id.circusLayout));
//		ImageView image = (ImageView) layout.findViewById(R.id.circusJam);
//		//image.setImageDrawable(tempImageView.getDrawable());
//		imageDialog.setView(layout);
//		
//		imageDialog.create();
//		imageDialog.show();
//		
//	}
	
	
	
	
	
	
	
}
