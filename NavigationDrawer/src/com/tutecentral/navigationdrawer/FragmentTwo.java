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

public class FragmentTwo   extends Fragment {

	ImageView ivIcon;
	TextView tvItemName;

	public static final String IMAGE_RESOURCE_ID = "iconResourceID";
	public static final String ITEM_NAME = "itemName";

	public FragmentTwo()
	{
		
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		View view=inflater.inflate(R.layout.fragment_layout_two,container, false);
		GoogleMap googleMap = ((MapFragment) getFragmentManager().findFragmentById(R.id.map2)).getMap();
		final LatLng blocka = new LatLng(17.545698, 78.572647);
		final LatLng blockb = new LatLng(17.545271, 78.572357);
		final LatLng blockc = new LatLng(17.545003, 78.571918);
		final LatLng blockd = new LatLng(17.544379, 78.571561);
		final LatLng blocke = new LatLng(17.543818, 78.571668);
		Marker TP = googleMap.addMarker(new MarkerOptions().position(blocka).title("BLOCK-A")); 
		Marker TP1 = googleMap.addMarker(new MarkerOptions().position(blockb).title("BLOCK-B"));
		Marker TP2 = googleMap.addMarker(new MarkerOptions().position(blockc).title("BLOCK-C"));
		Marker TP3 = googleMap.addMarker(new MarkerOptions().position(blockd).title("BLOCK-D"));
		Marker TP4 = googleMap.addMarker(new MarkerOptions().position(blocke).title("BLOCK-E"));
		CameraUpdate center = CameraUpdateFactory.newLatLng(blockc);
		CameraUpdate zoom = CameraUpdateFactory.zoomTo(18);
		googleMap.moveCamera(center);
		googleMap.animateCamera(zoom);
		
		return view;
	}
	@Override
	public void onDestroyView() 
	{
		super.onDestroyView(); 
        Fragment fragment = (getFragmentManager().findFragmentById(R.id.map2));  
        FragmentTransaction ft = getActivity().getFragmentManager().beginTransaction();
        ft.remove(fragment);
        ft.commit();
	    
	   
	}
	}
	
