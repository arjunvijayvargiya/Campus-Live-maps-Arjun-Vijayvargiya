package com.tutecentral.navigationdrawer;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Help extends Fragment {
public Help(){
		
	}
@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
		Bundle savedInstanceState) {

	View view = inflater.inflate(R.layout.help, container,
			false);
	
	
	
	return view;
}
	
}
