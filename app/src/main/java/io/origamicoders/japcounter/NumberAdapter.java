package io.origamicoders.japcounter;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import io.origamicoders.japcounter.Classes.JapWord;

/**
 * Created by DM036497 on 1/3/2017.
 */

public class NumberAdapter extends RecyclerView.Adapter<NumberAdapter.ViewHolder> {
    private ArrayList<JapWord> mDataset;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public View mView;


        public ViewHolder(View v) {
            super(v);
            mView = v;

            final Intent intent = new Intent(v.getContext(), DetailsActivity.class);


            mView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
//                    int res = mDataset.get(getLayoutPosition()) instanceof Header ? 1 : 2;
//                    if(res == 1){
//                        Toast.makeText(mView.getContext(), "RADA", Toast.LENGTH_LONG).show();
//
//                    } else {
//                        String item = mDataset.get(getLayoutPosition()).name.kanji;
//                        Toast.makeText(mView.getContext(), item, Toast.LENGTH_LONG).show();
//                        intent.putExtra("ITEM_POS",getLayoutPosition());
//                        mView.getContext().startActivity(intent);
//                    }
                }


            });
        }


    }




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
        // set the view's size, margins, paddings and layout parameters
        NumberAdapter.ViewHolder vh = new NumberAdapter.ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(NumberAdapter.ViewHolder holder, int position) {

            TextView title = (TextView) holder.mView.findViewById(R.id.number_list_item_kanji);
            TextView num = (TextView) holder.mView.findViewById(R.id.number_list_item_num);


            JapWord item= mDataset.get(position);

            title.setText(item.getKanji());
            num.setText(item.english);



    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.size();
    }



}
