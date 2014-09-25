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

public class FragmentFour extends Fragment {
private GoogleMap googleMap;
public FragmentFour(){
	
}
@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
		Bundle savedInstanceState) {

	View view = inflater.inflate(R.layout.fragment_layout_four, container,
			false);
	
	googleMap = ((MapFragment) getFragmentManager().findFragmentById(R.id.map4)).getMap();
	final LatLng vr = new LatLng(17.541927, 78.575786);
	final LatLng cp = new LatLng(17.542031, 78.575848);
	final LatLng bk= new LatLng(17.542070, 78.575679);
	final LatLng sl = new LatLng(17.542102, 78.575707);
	final LatLng po = new LatLng(17.539734, 78.577534);
	final LatLng fs = new LatLng(17.542251, 78.575856);
	final LatLng mo = new LatLng(17.542034, 78.576074);
	Marker TP = googleMap.addMarker(new MarkerOptions().position(vr).title("Viceroy")); 
	Marker TP1 = googleMap.addMarker(new MarkerOptions().position(cp).title("Connaught Place"));
	Marker TP2 = googleMap.addMarker(new MarkerOptions().position(bk).title("Bakery"));
	Marker TP3 = googleMap.addMarker(new MarkerOptions().position(sl).title("Saloon"));
	Marker TP4 = googleMap.addMarker(new MarkerOptions().position(fs).title("Fruit Shop"));
	Marker TP5 = googleMap.addMarker(new MarkerOptions().position(mo).title("More"));
	Marker TP6 = googleMap.addMarker(new MarkerOptions().position(po).title("Post-Office"));
	CameraUpdate center = CameraUpdateFactory.newLatLng(cp);
	CameraUpdate zoom = CameraUpdateFactory.zoomTo(18);
	googleMap.moveCamera(center);
	googleMap.animateCamera(zoom);

	
	return view;
}
public void onDestroyView() 
{ 
	super.onDestroyView(); 
    Fragment fragment = (getFragmentManager().findFragmentById(R.id.map4));  
    FragmentTransaction ft = getActivity().getFragmentManager().beginTransaction();
    ft.remove(fragment);
    ft.commit();
    

}

	
	
	
	
	
	
	
	
	
	
	
}
