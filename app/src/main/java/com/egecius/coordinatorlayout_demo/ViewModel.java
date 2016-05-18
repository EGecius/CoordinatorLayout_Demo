package com.egecius.coordinatorlayout_demo;

public class ViewModel {
	private String text;
	private String image;

	public ViewModel(String text, String image) {
		this. text = text;
		this.image = image;
	}

	public String getText() {
		return text;
	}

	public String getImage() {
		return image;
	}

	@Override
	public String toString() {
		return "ViewModel{" +
				"text='" + text + '\'' +
				", image='" + image + '\'' +
				'}';
	}
}
