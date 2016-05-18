package com.egecius.coordinatorlayout_demo;

import java.util.ArrayList;
import java.util.List;

final class Utils {
	public static List<ViewModel> getItems() {

		ArrayList<ViewModel> items = new ArrayList<>();

		for (int i = 1; i <= 10; i++) {
			items.add(new ViewModel("Item " + i, "http://lorempixel.com/500/500/animals/" + i));
		}

		return items;
	}

}
