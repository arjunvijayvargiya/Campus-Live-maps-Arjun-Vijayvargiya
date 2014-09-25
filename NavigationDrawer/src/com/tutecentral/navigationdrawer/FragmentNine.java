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

public class FragmentNine extends Fragment {
	private GoogleMap googleMap;
	public FragmentNine(){
		
	}
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View view = inflater.inflate(R.layout.fragment_layout_nine, container,
				false);
		
		googleMap = ((MapFragment) getFragmentManager().findFragmentById(R.id.map9)).getMap();
		final LatLng placdiv = new LatLng(17.545983, 78.571467);
		final LatLng psdiv = new LatLng(17.544878, 78.571078);
		
		Marker TP = googleMap.addMarker(new MarkerOptions().position(placdiv).title("Placement Division")); 
		Marker TP1 = googleMap.addMarker(new MarkerOptions().position(psdiv).title("Practice School Division"));
		
		CameraUpdate center = CameraUpdateFactory.newLatLng(psdiv);
		CameraUpdate zoom = CameraUpdateFactory.zoomTo(18);
		googleMap.moveCamera(center);
		googleMap.animateCamera(zoom);

		
		return view;
	}
	public void onDestroyView() 
	{ 
		super.onDestroyView(); 
	    Fragment fragment = (getFragmentManager().findFragmentById(R.id.map9));  
	    FragmentTransaction ft = getActivity().getFragmentManager().beginTransaction();
	    ft.remove(fragment);
	    ft.commit();
	    

	}
	
	
	
	
	
	
}
