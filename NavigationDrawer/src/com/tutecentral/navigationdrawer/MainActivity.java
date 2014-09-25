package com.tutecentral.navigationdrawer;

import java.util.ArrayList;
import java.util.List;


import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.text.InputFilter.LengthFilter;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity {

	private DrawerLayout mDrawerLayout;
	private ListView mDrawerList;
	private ActionBarDrawerToggle mDrawerToggle;

	private CharSequence mDrawerTitle;
	private CharSequence mTitle;
	CustomDrawerAdapter adapter;

	List<DrawerItem> dataList;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
        //mapCreator();
		// Initializing
		
		dataList = new ArrayList<DrawerItem>();
		mTitle = mDrawerTitle = getTitle();
		mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
		mDrawerList = (ListView) findViewById(R.id.left_drawer);

		mDrawerLayout.setDrawerShadow(R.drawable.drawer_shadow,
				GravityCompat.START);

		// Add Drawer Item to dataList
		dataList.add(new DrawerItem("Free Roam", R.drawable.freeroam));
		dataList.add(new DrawerItem("Academic Blocks", R.drawable.building));
		dataList.add(new DrawerItem("Sports", R.drawable.soccerball));
		dataList.add(new DrawerItem("Shopping Complex", R.drawable.shoppingcart));
		dataList.add(new DrawerItem("Eating Points", R.drawable.hamburger));
		dataList.add(new DrawerItem("Hostels", R.drawable.home));
		dataList.add(new DrawerItem("Ponds", R.drawable.water));
		dataList.add(new DrawerItem("Important Places", R.drawable.important));
		dataList.add(new DrawerItem("Divisions", R.drawable.buildingdivi));
		dataList.add(new DrawerItem("Toilets",
				R.drawable.ic_action_import_export));
		dataList.add(new DrawerItem("About", R.drawable.ic_action_about));
		dataList.add(new DrawerItem("Help", R.drawable.ic_action_settings));
		dataList.add(new DrawerItem("Extras", R.drawable.ic_action_help));

		adapter = new CustomDrawerAdapter(this, R.layout.custom_drawer_item,
				dataList);

		mDrawerList.setAdapter(adapter);

		mDrawerList.setOnItemClickListener(new DrawerItemClickListener());

		getActionBar().setDisplayHomeAsUpEnabled(true);
		getActionBar().setHomeButtonEnabled(true);

		mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout,
				R.drawable.ic_drawer, R.string.drawer_open,
				R.string.drawer_close) {
			public void onDrawerClosed(View view) {
				getActionBar().setTitle(mTitle);
				invalidateOptionsMenu(); // creates call to
											// onPrepareOptionsMenu()
			}

			public void onDrawerOpened(View drawerView) {
				getActionBar().setTitle(mDrawerTitle);
				invalidateOptionsMenu(); // creates call to
											// onPrepareOptionsMenu()
			}
		};

		mDrawerLayout.setDrawerListener(mDrawerToggle);

		if (savedInstanceState == null) {
			SelectItem(0);
		}

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public void SelectItem(int possition) {

		Fragment fragment = null;
		Bundle args = new Bundle();
		switch (possition) {
		case 0:
			fragment = new FragmentOne();
			
			
			
			break;
			
			
		case 1:
			fragment = new FragmentTwo();
			
			break;
		case 2:
			fragment = new FragmentThree();
			
			break;
		case 3:
			fragment = new FragmentFour();
			
			break;
		case 4:
			fragment = new FragmentFive();
			
			break;
		case 5:
			fragment = new FragmentSix();
			
			break;
		case 6:
			fragment = new FragmentSeven();
			
			break;
		case 7:
			fragment = new FragmentEight();
			
			break;
		case 8:
			fragment = new FragmentNine();
			
			break;
		case 9:
			fragment = new FragmentTen();
			
			break;
		case 10:
			fragment = new About();
			
			break;
		case 11:
			fragment = new Help();
			
			break;
		case 12:
			fragment = new FragmentOne();
			break;
			
		default:
			break;
		}

		fragment.setArguments(args);
		FragmentManager frgManager = getFragmentManager();
		frgManager.beginTransaction().replace(R.id.content_frame, fragment)
				.commit();

		mDrawerList.setItemChecked(possition, true);
		setTitle(dataList.get(possition).getItemName());
		mDrawerLayout.closeDrawer(mDrawerList);

	}

	@Override
	public void setTitle(CharSequence title) {
		mTitle = title;
		getActionBar().setTitle(mTitle);
	}

	@Override
	protected void onPostCreate(Bundle savedInstanceState) {
		super.onPostCreate(savedInstanceState);
		// Sync the toggle state after onRestoreInstanceState has occurred.
		mDrawerToggle.syncState();
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		super.onConfigurationChanged(newConfig);
		// Pass any configuration change to the drawer toggles
		mDrawerToggle.onConfigurationChanged(newConfig);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// The action bar home/up action should open or close the drawer.
		// ActionBarDrawerToggle will take care of this.
		if (mDrawerToggle.onOptionsItemSelected(item)) {
			return true;
		}

		return false;
	}

	private class DrawerItemClickListener implements
			ListView.OnItemClickListener {
		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			SelectItem(position);

		}
	}
private void mapCreator(){
	final GoogleMap googleMap;
	googleMap = ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();
	final LatLng bitspilani = new LatLng(17.544860 , 78.571718);
	Marker TP = googleMap.addMarker(new MarkerOptions().position(bitspilani).title("BPHC")); 
	CameraUpdate center = CameraUpdateFactory.newLatLng(bitspilani);
	CameraUpdate zoom = CameraUpdateFactory.zoomTo(18);
	googleMap.moveCamera(center);
	googleMap.animateCamera(zoom);
	
	//determining the location through GPS
	
	LocationManager lm=(LocationManager) this.getSystemService(Context.LOCATION_SERVICE);
	LocationListener listener=new LocationListener() {
		
		@Override
		public void onStatusChanged(String arg0, int arg1, Bundle arg2) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void onProviderEnabled(String arg0) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void onProviderDisabled(String arg0) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void onLocationChanged(Location loc) {
			// TODO Auto-generated method stub
			final float lati = (float)loc.getLatitude();
			final float longi  = (float)loc.getLongitude();
			final LatLng pos = new LatLng(lati , longi);
			Marker userMarker = googleMap.addMarker(new MarkerOptions().position(pos).title("YOU"));
			
		}
	};
	
	lm.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, listener);
	
	//SAVING THE LAST LOCATION
	String locationprevious = LocationManager.NETWORK_PROVIDER;
	Location last = lm.getLastKnownLocation(locationprevious);
}
}
