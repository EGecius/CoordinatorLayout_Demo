package com.egecius.coordinatorlayout_demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

	private RecyclerView recyclerView;

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
		RecyclerViewAdapter adapter = new RecyclerViewAdapter(Utils.getItems());
		recyclerView.setAdapter(adapter);
	}
}
