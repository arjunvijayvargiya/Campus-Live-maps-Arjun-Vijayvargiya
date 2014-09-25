package com.tutecentral.navigationdrawer;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class FragmentEight extends Fragment {
	private GoogleMap googleMap;
	public FragmentEight(){
		
	}
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View view = inflater.inflate(R.layout.fragment_layout_eight, container,
				false);
		
		googleMap = ((MapFragment) getFragmentManager().findFragmentById(R.id.map8)).getMap();
		final LatLng lib = new LatLng(17.545638, 78.571441);
		final LatLng ltc = new LatLng(17.544835, 78.571069);
		final LatLng stg1= new LatLng(17.545019, 78.571637);
		final LatLng stg2 = new LatLng(17.544011, 78.573794);
		
		Marker TP = googleMap.addMarker(new MarkerOptions().position(lib).title("Library")); 
		Marker TP1 = googleMap.addMarker(new MarkerOptions().position(ltc).title("Lecture Theatre Complex"));
		Marker TP2 = googleMap.addMarker(new MarkerOptions().position(stg1).title("Stage-1"));
		Marker TP3 = googleMap.addMarker(new MarkerOptions().position(stg2).title("Stage-2"));
		
		CameraUpdate center = CameraUpdateFactory.newLatLng(lib);
		CameraUpdate zoom = CameraUpdateFactory.zoomTo(18);
		googleMap.moveCamera(center);
		googleMap.animateCamera(zoom);

		
		return view;
	}
	public void onDestroyView() 
	{ 
		super.onDestroyView(); 
	    Fragment fragment = (getFragmentManager().findFragmentById(R.id.map8));  
	    FragmentTransaction ft = getActivity().getFragmentManager().beginTransaction();
	    ft.remove(fragment);
	    ft.commit();
	    

	}
	
	
	
	
	
	
	
	
	
}
