package com.egecius.coordinatorlayout_demo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import butterknife.Bind;
import butterknife.ButterKnife;

public final class CollapsingToolbarActivity extends AppCompatActivity {

	@Bind (R.id.imageView) ImageView imageView;

	@Override
	protected void onCreate(@Nullable final Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setUi();
	}

	private void setUi() {
		setContentView(R.layout.collapsing_toolbar_activity);
		ButterKnife.bind(this);
		setToolbar();
		setImage();
	}

	private void setImage() {
		String url = "http://lorempixel.com/500/500/animals/1";
		Picasso.with(getApplicationContext()).load(url).into(imageView);
	}

	private void setToolbar() {
		Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
		setSupportActionBar(toolbar);
	}

}
