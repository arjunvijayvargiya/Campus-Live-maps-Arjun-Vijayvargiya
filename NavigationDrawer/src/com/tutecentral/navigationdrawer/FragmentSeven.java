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

public class FragmentSeven extends Fragment {
	private GoogleMap googleMap;
	public FragmentSeven(){
		
	}
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View view = inflater.inflate(R.layout.fragment_layout_seven, container,
				false);
		
		googleMap = ((MapFragment) getFragmentManager().findFragmentById(R.id.map7)).getMap();
		final LatLng wf = new LatLng(17.544160, 78.572402);
		final LatLng pd1 = new LatLng(17.544262, 78.573193);
		final LatLng pd2= new LatLng(17.542978, 78.575929);
		
		Marker TP = googleMap.addMarker(new MarkerOptions().position(wf).title("Water-Falls")); 
		Marker TP1 = googleMap.addMarker(new MarkerOptions().position(pd1).title("Pond-1"));
		Marker TP2 = googleMap.addMarker(new MarkerOptions().position(pd2).title("Pond-2"));
		CameraUpdate center = CameraUpdateFactory.newLatLng(wf);
		CameraUpdate zoom = CameraUpdateFactory.zoomTo(18);
		googleMap.moveCamera(center);
		googleMap.animateCamera(zoom);

		
		return view;
	}
	public void onDestroyView() 
	{ 
		super.onDestroyView(); 
	    Fragment fragment = (getFragmentManager().findFragmentById(R.id.map7));  
	    FragmentTransaction ft = getActivity().getFragmentManager().beginTransaction();
	    ft.remove(fragment);
	    ft.commit();
	    

	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
