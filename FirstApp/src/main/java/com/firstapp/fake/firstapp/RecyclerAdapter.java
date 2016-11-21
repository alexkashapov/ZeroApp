package com.firstapp.fake.firstapp;

import android.graphics.PorterDuff;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Fake on 13.11.2016.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder> {

    private ArrayList<Note> items = new ArrayList<>();
    OnRecyclerCallback onRecyclerCallback;
    private String element_name_template;

    public RecyclerAdapter(OnRecyclerCallback onRecyclerCallback) {
        this.onRecyclerCallback = onRecyclerCallback;
    }

    public void addAll(List<Note> elements) {
        int pos = getItemCount();
        this.items.addAll(elements);
        notifyItemRangeInserted(pos, this.items.size());
    }

    public void addItem(Note newNote) {
        this.items.add(newNote);
        notifyItemInserted(getItemCount());
    }


    public ArrayList<Note> getElements(){
        return new ArrayList<>(items);
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.i_color, parent, false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final RecyclerViewHolder holder,int position) {
        holder.bind(items.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onRecyclerCallback.onItemClick(holder.getAdapterPosition());
            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void dismissNote(int pos){
        items.remove(pos);
        this.notifyDataSetChanged();
    }
    interface OnRecyclerCallback{
        void onItemClick(int position);
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder {
        private TextView title;
        private ImageView image;

        public RecyclerViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.title);
            image = (ImageView) itemView.findViewById(R.id.circleImage);
        }

        public void bind(Note note) {
            int color = itemView.getContext().getResources().getColor(note.getColor());
            image.getDrawable().setColorFilter(color, PorterDuff.Mode.SRC_ATOP);
            title.setText(note.getTitle());
        }
    }
}

