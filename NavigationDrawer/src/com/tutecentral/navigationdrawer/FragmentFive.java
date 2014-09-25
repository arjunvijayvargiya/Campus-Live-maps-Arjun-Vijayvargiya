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

public class FragmentFive extends Fragment {

	private GoogleMap googleMap;
	public FragmentFive(){
		
	}
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View view = inflater.inflate(R.layout.fragment_layout_five, container,
				false);
		
		googleMap = ((MapFragment) getFragmentManager().findFragmentById(R.id.map5)).getMap();
		final LatLng bru1 = new LatLng(17.542750, 78.574134);
		final LatLng bru2 = new LatLng(17.544484, 78.575041);
		final LatLng mess1= new LatLng(17.542448, 78.574054);
		final LatLng mess2 = new LatLng(17.544755, 78.575159);
		final LatLng cafeteria = new LatLng(17.544995, 78.570808);
		final LatLng amul= new LatLng(17.542530, 78.575443);
		final LatLng bk= new LatLng(17.542034, 78.576074);
		final LatLng vr= new LatLng(17.542034, 78.576074);
		Marker TP = googleMap.addMarker(new MarkerOptions().position(vr).title("Viceroy")); 
		Marker TP1 = googleMap.addMarker(new MarkerOptions().position(bru1).title("Bru1"));
		Marker TP2 = googleMap.addMarker(new MarkerOptions().position(bk).title("Bakery"));
		Marker TP3 = googleMap.addMarker(new MarkerOptions().position(bru2).title("Bru2"));
		Marker TP4 = googleMap.addMarker(new MarkerOptions().position(mess1).title("Mess1"));
		Marker TP5 = googleMap.addMarker(new MarkerOptions().position(mess2).title("Mess2"));
		Marker TP6 = googleMap.addMarker(new MarkerOptions().position(cafeteria).title("Cafeteria"));
		Marker TP7 = googleMap.addMarker(new MarkerOptions().position(amul).title("Amul"));
		CameraUpdate center = CameraUpdateFactory.newLatLng(amul);
		CameraUpdate zoom = CameraUpdateFactory.zoomTo(18);
		googleMap.moveCamera(center);
		googleMap.animateCamera(zoom);

		
		return view;
	}
	public void onDestroyView() 
	{ 
		super.onDestroyView(); 
	    Fragment fragment = (getFragmentManager().findFragmentById(R.id.map5));  
	    FragmentTransaction ft = getActivity().getFragmentManager().beginTransaction();
	    ft.remove(fragment);
	    ft.commit();
	    

	}

		
		
	
	
	
	
	
}
