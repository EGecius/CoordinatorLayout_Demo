package com.egecius.coordinatorlayout_demo.behaviors;

import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.view.ViewGroup;

/**
 * //todo
 */
final class ContentMovingBehavior extends CoordinatorLayout.Behavior<ViewGroup> {


	@Override
	public boolean layoutDependsOn(final CoordinatorLayout parent, final ViewGroup child, final View dependency) {
		return dependency instanceof Snackbar.SnackbarLayout;
	}

	@Override
	public boolean onDependentViewChanged(final CoordinatorLayout parent, final ViewGroup child, final View dependency) {
		return super.onDependentViewChanged(parent, child, dependency);
	}
}
