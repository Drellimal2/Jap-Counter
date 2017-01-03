package io.origamicoders.japcounter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import io.origamicoders.japcounter.Classes.Header;
import io.origamicoders.japcounter.Classes.JapCounter;

/**
 * Created by DM036497 on 1/3/2017.
 */

public class CounterAdapter extends RecyclerView.Adapter<CounterAdapter.ViewHolder> {
    private ArrayList<JapCounter> mDataset;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public View mView;
        public ViewHolder(View v) {
            super(v);
            mView = v;
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public CounterAdapter(ArrayList<JapCounter> myDataset) {
        mDataset = myDataset;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public CounterAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        // create a new view
        View v;
        if(viewType == 1){
            v = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.header_list_item, parent, false);
        } else {
            v = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.counter_list_item_2, parent, false);
        }

        // set the view's size, margins, paddings and layout parameters
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
//        holder.mView.setText(mDataset.get(position).name.kana);
        if (getItemViewType(position) == 1){
            TextView headerTitle = (TextView) holder.mView.findViewById(R.id.header_list_item_tv);
            headerTitle.setText(((Header) mDataset.get(position)).title);
        } else {
            TextView title = (TextView) holder.mView.findViewById(R.id.counter_list_item_title);
            TextView kana = (TextView) holder.mView.findViewById(R.id.counter_list_item_kana);
            TextView romaji = (TextView) holder.mView.findViewById(R.id.counter_list_item_romaji);
            TextView uses = (TextView) holder.mView.findViewById(R.id.counter_list_item_info_text);
            ImageView icon = (ImageView) holder.mView.findViewById(R.id.counter_list_item_icon);


            JapCounter item= mDataset.get(position);

            title.setText(item.name.kanji);
            kana.setText(item.name.kana);
            romaji.setText(item.name.romaji);
            String useslist = item.uses.get(0);

            int s = item.uses.size();
            if (s > 1) {
                for (String use : item.uses.subList(1, s)) {
                    useslist = useslist.concat(", " + use);
                }
            }
            uses.setText(useslist);
        }

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    @Override
    public int getItemViewType(int position) {
        int res = mDataset.get(position) instanceof Header ? 1 : 2;
        return res;
    }
    
}