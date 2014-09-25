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

public class FragmentSix extends Fragment {
	private GoogleMap googleMap;
	public FragmentSix(){
		
	}
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View view = inflater.inflate(R.layout.fragment_layout_six, container,
				false);
		
		googleMap = ((MapFragment) getFragmentManager().findFragmentById(R.id.map6)).getMap();
		final LatLng gn = new LatLng(17.542525, 78.574762);
		final LatLng bu = new LatLng(17.541834, 78.574628);
		final LatLng vy= new LatLng(17.541328, 78.574059);
		final LatLng kr = new LatLng(17.543082, 78.573694);
		final LatLng ra = new LatLng(17.542569, 78.573185);
		final LatLng sh = new LatLng(17.541939, 78.572997);
		final LatLng ma = new LatLng(17.544241, 78.575599);
		final LatLng me = new LatLng(17.544630, 78.574429);
		Marker TP = googleMap.addMarker(new MarkerOptions().position(gn).title("Gandhi")); 
		Marker TP1 = googleMap.addMarker(new MarkerOptions().position(bu).title("Budh"));
		Marker TP2 = googleMap.addMarker(new MarkerOptions().position(vy).title("Vyas"));
		Marker TP3 = googleMap.addMarker(new MarkerOptions().position(kr).title("Krishna"));
		Marker TP4 = googleMap.addMarker(new MarkerOptions().position(ra).title("Ram"));
		Marker TP5 = googleMap.addMarker(new MarkerOptions().position(sh).title("Shankar"));
		Marker TP6 = googleMap.addMarker(new MarkerOptions().position(ma).title("Malviya"));
		Marker TP7 = googleMap.addMarker(new MarkerOptions().position(me).title("Meera"));
		CameraUpdate center = CameraUpdateFactory.newLatLng(vy);
		CameraUpdate zoom = CameraUpdateFactory.zoomTo(18);
		googleMap.moveCamera(center);
		googleMap.animateCamera(zoom);

		
		return view;
	}
	public void onDestroyView() 
	{ 
		super.onDestroyView(); 
	    Fragment fragment = (getFragmentManager().findFragmentById(R.id.map6));  
	    FragmentTransaction ft = getActivity().getFragmentManager().beginTransaction();
	    ft.remove(fragment);
	    ft.commit();
	    

	}

	
	
	
	
	
	
	
}
