package com.egecius.coordinatorlayout_demo;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.ViewGroup;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

	@Bind (R.id.container) ViewGroup container;
	@Bind (R.id.recycler) RecyclerView recyclerView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		initUi();
	}

	private void initUi() {
		setContentView(R.layout.activity_main);
		ButterKnife.bind(this);
		setToolbar();
		initRecyclerView();
		setRecyclerAdapter();
	}

	@OnClick ({R.id.fab, R.id.fab2})
	void onFabClicked() {
		Snackbar.make(container, "Hey there!", Snackbar.LENGTH_LONG).show();
	}

	private void setToolbar() {
		Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
		setSupportActionBar(toolbar);
	}

	private void initRecyclerView() {
		recyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(), 2));

	}

	private void setRecyclerAdapter() {
		RecyclerViewAdapter adapter = new RecyclerViewAdapter(Utils.getItems());
		recyclerView.setAdapter(adapter);
	}
}
