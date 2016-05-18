package com.egecius.coordinatorlayout_demo.behaviors;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.View;

import java.util.List;

public class ShrinkBehavior extends CoordinatorLayout.Behavior<FloatingActionButton> {

	public ShrinkBehavior(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	@Override
	public boolean layoutDependsOn(CoordinatorLayout parent, FloatingActionButton child, View dependency) {
		return dependency instanceof Snackbar.SnackbarLayout;
	}

	@Override
	public boolean onDependentViewChanged(CoordinatorLayout parent, FloatingActionButton child, View dependency) {
		float translationY = getFabTranslationYForSnackbar(parent, child);
		float percentComplete = -translationY / dependency.getHeight();
		float scaleFactor = 1 - percentComplete;

		child.setScaleX(scaleFactor);
		child.setScaleY(scaleFactor);
		return false;
	}

	private float getFabTranslationYForSnackbar(CoordinatorLayout parent, FloatingActionButton fab) {
		float minOffset = 0;
		final List<View> dependencies = parent.getDependencies(fab);

		for (final View dependency : dependencies) {
			if (dependency instanceof Snackbar.SnackbarLayout && parent.doViewsOverlap(fab, dependency)) {
				minOffset = Math.min(minOffset, ViewCompat.getTranslationY(dependency) - dependency.getHeight());
			}
		}

		return minOffset;
	}

}

