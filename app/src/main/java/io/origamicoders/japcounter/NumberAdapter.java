package io.origamicoders.japcounter;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatDialogFragment;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import io.origamicoders.japcounter.Classes.JapWord;
import io.origamicoders.japcounter.Classes.NumberDetails;

/**
 * Created by DM036497 on 1/3/2017.
 */

public class NumberAdapter extends RecyclerView.Adapter<NumberAdapter.ViewHolder> {
    private ArrayList<JapWord> mDataset;

    // Provide a suitable constructor (depends on the kind of dataset)
    public NumberAdapter(ArrayList<JapWord> myDataset) {
        mDataset = myDataset;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public NumberAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                        int viewType) {
        // create a new view
        View v;

        v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.number_list_item, parent, false);

        NumberAdapter.ViewHolder vh = new NumberAdapter.ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(NumberAdapter.ViewHolder holder, int position) {

            TextView title = (TextView) holder.mView.findViewById(R.id.number_list_item_kanji);
            TextView num = (TextView) holder.mView.findViewById(R.id.number_list_item_num);


            JapWord item= mDataset.get(position);

            title.setText(item.getKanji());
            num.setText(item.english);



    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public View mView;


        public ViewHolder(View v) {
            super(v);
            mView = v;


            mView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String item = mDataset.get(getLayoutPosition()).english;
                    int i = Integer.parseInt(item) - 1;
                    AppCompatDialogFragment a = NumberDetails.newInstance(i);
                    FragmentManager  frag = MainActivity.frag;
//                    FragmentManager  frag = HundredActivity.frag;
                    a.show(frag, "a");

                }


            });
        }


    }



}
