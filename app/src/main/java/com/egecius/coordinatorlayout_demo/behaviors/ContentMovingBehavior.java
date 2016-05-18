package com.egecius.coordinatorlayout_demo.behaviors;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.View;

import java.util.List;

/**
 * Moves view by the same amount that SnackBar has been moved
 */
public final class ContentMovingBehavior extends CoordinatorLayout.Behavior<View> {

	public ContentMovingBehavior(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	@Override
	public boolean layoutDependsOn(final CoordinatorLayout parent, final View child, final View dependency) {
		return dependency instanceof Snackbar.SnackbarLayout;
	}

	@Override
	public boolean onDependentViewChanged(final CoordinatorLayout parent, final View movingView, final View dependency) {
		float translationY = getChildTranslationYForSnackbar(parent, movingView);
		movingView.setTranslationY(translationY);
		return true;
	}

	private float getChildTranslationYForSnackbar(CoordinatorLayout parent, View movingView) {
		float minOffset = 0;
		final List<View> dependencies = parent.getDependencies(movingView);

		for (final View dependency : dependencies) {
			float translationY = ViewCompat.getTranslationY(dependency);
			int height = dependency.getHeight();
			minOffset = Math.min(minOffset, translationY - height);
		}

		return minOffset;
	}
}
