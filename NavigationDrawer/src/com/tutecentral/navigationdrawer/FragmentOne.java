package com.tutecentral.navigationdrawer;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class FragmentOne extends Fragment {

	ImageView ivIcon;
	TextView tvItemName;

	public static final String IMAGE_RESOURCE_ID = "iconResourceID";
	public static final String ITEM_NAME = "itemName";
    private GoogleMap googleMap;
	public FragmentOne() {

	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View view = inflater.inflate(R.layout.fragment_layout_one, container,
				false);
		
		googleMap = ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();
		final LatLng bitspilani = new LatLng(17.545358,78.571888);
		Marker TP = googleMap.addMarker(new MarkerOptions().position(bitspilani).title("BITS PILANI HYDERABAD CAMPUS")); 
		CameraUpdate center = CameraUpdateFactory.newLatLng(bitspilani);
		CameraUpdate zoom = CameraUpdateFactory.zoomTo(18);
		googleMap.moveCamera(center);
		googleMap.animateCamera(zoom);
	
		
		return view;
	}
	public void onDestroyView() 
	{ 
		super.onDestroyView(); 
        Fragment fragment = (getFragmentManager().findFragmentById(R.id.map));  
        FragmentTransaction ft = getActivity().getFragmentManager().beginTransaction();
        ft.remove(fragment);
        ft.commit();
	    
	
	}

}
