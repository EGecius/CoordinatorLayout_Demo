package com.egecius.coordinatorlayout_demo;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> implements View.OnClickListener {

	private List<ViewModel> items;
	private OnItemClickListener onItemClickListener;

	public RecyclerViewAdapter(List<ViewModel> items) {
		this.items = items;
	}

	public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
		this.onItemClickListener = onItemClickListener;
	}

	@Override public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycler, parent, false);
		v.setOnClickListener(this);
		return new ViewHolder(v);
	}

	@Override public void onBindViewHolder(ViewHolder holder, int position) {
		ViewModel item = items.get(position);
		holder.text.setText(item.getText());
		holder.image.setImageBitmap(null);
		Picasso.with(holder.image.getContext()).load(item.getImage()).into(holder.image);
		holder.itemView.setTag(item);
	}

	@Override public int getItemCount() {

		Log.w("Eg:RecyclerViewAdapter:43", "getItemCount items.size() " + items.size());

		return items.size();
	}

	@Override public void onClick(final View v) {
		onItemClickListener.onItemClick(v, (ViewModel) v.getTag());
	}

	protected static class ViewHolder extends RecyclerView.ViewHolder {
		public ImageView image;
		public TextView text;

		public ViewHolder(View itemView) {
			super(itemView);
			image = (ImageView) itemView.findViewById(R.id.image);
			text = (TextView) itemView.findViewById(R.id.text);
		}
	}

	public interface OnItemClickListener {

		void onItemClick(View view, ViewModel viewModel);

	}
}