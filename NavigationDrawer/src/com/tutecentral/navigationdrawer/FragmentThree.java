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
import android.widget.ImageView;
import android.widget.TextView;

public class FragmentThree extends Fragment {

	

	public FragmentThree() {

	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_layout_three, container,
				false);
		
		GoogleMap googleMap = ((MapFragment) getFragmentManager().findFragmentById(R.id.map3)).getMap();
		final LatLng hockey = new LatLng(17.543849, 78.574093);
		final LatLng football = new LatLng(17.543586, 78.575021);
		final LatLng lawntennis= new LatLng(17.541601, 78.575651);
		final LatLng basketball = new LatLng(17.541289, 78.575474);
		final LatLng cricket = new LatLng(17.539734, 78.577534);
		final LatLng sac = new LatLng(17.540629, 78.575227);
		Marker TP = googleMap.addMarker(new MarkerOptions().position(hockey).title("Hockey")); 
		Marker TP1 = googleMap.addMarker(new MarkerOptions().position(football).title("football"));
		Marker TP2 = googleMap.addMarker(new MarkerOptions().position(lawntennis).title("lawntennis"));
		Marker TP3 = googleMap.addMarker(new MarkerOptions().position(basketball).title("basketball"));
		Marker TP4 = googleMap.addMarker(new MarkerOptions().position(cricket).title("cricket"));
		Marker TP5 = googleMap.addMarker(new MarkerOptions().position(sac).title("SAC"));
		CameraUpdate center = CameraUpdateFactory.newLatLng(lawntennis);
		CameraUpdate zoom = CameraUpdateFactory.zoomTo(18);
		googleMap.moveCamera(center);
		googleMap.animateCamera(zoom);
	
		
		return view;
	}
	public void onDestroyView() 
	{ 
		super.onDestroyView(); 
        Fragment fragment = (getFragmentManager().findFragmentById(R.id.map3));  
        FragmentTransaction ft = getActivity().getFragmentManager().beginTransaction();
        ft.remove(fragment);
        ft.commit();
	    
	
	}

}
