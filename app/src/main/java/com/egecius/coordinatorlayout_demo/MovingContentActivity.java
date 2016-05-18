package com.egecius.coordinatorlayout_demo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Activity where all content is moved by SnackBar
 */
public final class MovingContentActivity extends AppCompatActivity {

	@Bind (R.id.rootView) View rootView;


	@Override
	protected void onCreate(@Nullable final Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.moving_content_activity);
		setToolbar();
		ButterKnife.bind(this);
	}

	private void setToolbar() {
		Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
		setSupportActionBar(toolbar);
	}


	@OnClick (R.id.moveBtn)
	void onMoveBtnClicked() {
		Snackbar.make(rootView, "Moving", Snackbar.LENGTH_SHORT).show();
	}
}
