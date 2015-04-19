package com.example.hellolambda;

import java.util.Arrays;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		int x = 42;
		runOnUiThread(() -> {
		    Log.d("MainActivity", "Hello from lambda! x = " + x);
		});		

		if (savedInstanceState == null) {
			getFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_main, container,
					false);
			
			return rootView;
		}
		
		@Override
		public void onActivityCreated(Bundle savedInstanceState)
		{
			super.onActivityCreated(savedInstanceState);
			
			Button btnLambda = (Button)getActivity().findViewById(R.id.buttonLambda);
			btnLambda.setOnClickListener((View v) -> {
				String[] citiesArray = { "New York", "Istanbul", "Tokyo", "Warsaw", 
									     "London", "Paris", "Beijing" };
		
				// Sort players by name using lambda expressions
				Arrays.sort(citiesArray, (s1, s2) -> s1.compareTo(s2));	
				
				StringBuilder citiesBuilder = new StringBuilder();
				for(String item : citiesArray)
					citiesBuilder.append(item + "\n");
				
				AlertDialog.Builder alertBuilder = new AlertDialog.Builder(getActivity());
				alertBuilder.setMessage(citiesBuilder.toString());
				alertBuilder.setTitle("Sorted Cities Array");
				AlertDialog dialogBox = alertBuilder.create();
				dialogBox.show();
			});
		}
	}
}
