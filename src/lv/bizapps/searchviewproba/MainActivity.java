package lv.bizapps.searchviewproba;

import android.os.Build;
import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.SearchManager;
import android.content.Context;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends ActionBarActivity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		ActionBar ab = getSupportActionBar();
		ab.show();
	}

	@SuppressLint("NewApi")
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);

		if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
			// Get the SearchView and set the searchable configuration
		    SearchManager searchManager = (SearchManager)getSystemService(Context.SEARCH_SERVICE);
		    SearchView searchView = (SearchView)menu.findItem(R.id.menu_search).getActionView();
		    // Assumes current activity is the searchable activity
		    searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
		    //searchView.setIconifiedByDefault(false); // Do not iconify the widget; expand it by default
		}

		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch(item.getItemId()) {
			case R.id.menu_search:	Log.e("AAA", "ON SEARCH");
									onSearchRequested();
            						return true;
			default:
									return false;
		}
	}
}
