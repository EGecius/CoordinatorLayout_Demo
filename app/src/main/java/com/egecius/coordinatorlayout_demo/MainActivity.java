package com.egecius.coordinatorlayout_demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

	private RecyclerView recyclerView;

	private static List<ViewModel> items = new ArrayList<>();

	static {
		for (int i = 1; i <= 10; i++) {
			items.add(new ViewModel("Item " + i, "http://lorempixel.com/500/500/animals/" + i));
		}
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		initUi();
	}

	private void initUi() {
		setContentView(R.layout.activity_main);
		initRecyclerView();
		setRecyclerAdapter();
	}


	private void initRecyclerView() {
		recyclerView = (RecyclerView) findViewById(R.id.recycler);
		recyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(), 2));

	}

	private void setRecyclerAdapter() {

		Log.d("Eg:MainActivity:45", "setRecyclerAdapter items.size() " + items.size());

		Log.i("Eg:MainActivity:44", "setRecyclerAdapter items " + items);


		RecyclerViewAdapter adapter = new RecyclerViewAdapter(items);
		recyclerView.setAdapter(adapter);
	}
}
