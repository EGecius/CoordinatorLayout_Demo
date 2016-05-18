package com.egecius.coordinatorlayout_demo.behaviors;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import java.util.List;

public class RotateBehavior extends CoordinatorLayout.Behavior<FloatingActionButton> {

	private static final String TAG = ShrinkBehavior.class.getSimpleName();
	public static final int DEGREES_TO_TURN = -270;

	public RotateBehavior(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	@Override
	public boolean layoutDependsOn(CoordinatorLayout parent, FloatingActionButton child, View dependency) {
		return dependency instanceof Snackbar.SnackbarLayout;
	}

	@Override
	public boolean onDependentViewChanged(CoordinatorLayout parent, FloatingActionButton fab, View dependency) {
		float translationY = getFabTranslationYForSnackbar(parent, fab);

		float percentComplete = -translationY / dependency.getHeight();
		fab.setRotation(DEGREES_TO_TURN * percentComplete);
		fab.setTranslationY(translationY);
		return false;
	}

	private float getFabTranslationYForSnackbar(CoordinatorLayout parent, FloatingActionButton fab) {
		float minOffset = 0;
		final List<View> dependencies = parent.getDependencies(fab);

		for (int i = 0, z = dependencies.size(); i < z; i++) {
			final View view = dependencies.get(i);
			if (view instanceof Snackbar.SnackbarLayout && parent.doViewsOverlap(fab, view)) {
				float translationY = ViewCompat.getTranslationY(view);

				int height = view.getHeight();
				minOffset = Math.min(minOffset, translationY - height);
			}
		}

		return minOffset;
	}
}
