package com.example.daniel.contactlist_proj.adapters;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.daniel.contactlist_proj.R;
import com.example.daniel.contactlist_proj.data.Contact;
import com.example.daniel.contactlist_proj.ui.DetailFragment;
import com.example.daniel.contactlist_proj.ui.RecyclerFragment;

import java.util.ArrayList;


/**
 * Created by Daniel on 11/27/16.
 */

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {

    private static final String TAG = "CustomAdapterTAG_";
    ArrayList<Contact> contacts;

    public CustomAdapter(ArrayList<Contact> contacts) {
        this.contacts = contacts;
    }

    @Override
    public CustomAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.list_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        Log.d(TAG, "onCreateViewHolder: " + viewHolder);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(CustomAdapter.ViewHolder holder, int position) {
        holder.contactName.setText(contacts.get(position).getName());
        holder.contactNumber.setText(contacts.get(position).getPhone().getWork());
        Glide.with(holder.context)
                .load(contacts.get(position).getSmallImageURL())
                .into(holder.contactImage);

        holder.contactVH = contacts.get(position);
        Log.d(TAG, "onBindViewHolder: " + position);
    }

    @Override
    public int getItemCount() {
        Log.d(TAG, "getItemCount: " + contacts.size() + contacts.get(1));
        return contacts.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        Log.d(TAG, "onAttachedToRecyclerView: " + recyclerView);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        private CardView contactCrdVw;
        private TextView contactName;
        private TextView contactNumber;
        private ImageView contactImage;

        public Context context;
        public Contact contactVH;

        public ViewHolder(View itemView) {
            super(itemView);

            contactName = (TextView) itemView.findViewById(R.id.li_contactName);
            contactNumber = (TextView) itemView.findViewById(R.id.li_contactNumber);
            contactCrdVw = (CardView) itemView.findViewById(R.id.li_contactCrdVw);
            contactImage = (ImageView) itemView.findViewById(R.id.li_contactImage);

            context = itemView.getContext();

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Bundle bundle = new Bundle();
                    bundle.putParcelable("CONTAC", contactVH);

                    DetailFragment detailFragment = new DetailFragment();
                    RecyclerFragment recyclerFragment = new RecyclerFragment();
                    detailFragment.setArguments(bundle);

                    AppCompatActivity appCompatActivity = (AppCompatActivity) view.getContext();
                    appCompatActivity
                            .getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.activity_main, detailFragment)
                            .addToBackStack(null)
                            .commit();
                }
            });

            Log.d(TAG, "ViewHolder: " + itemView);
        }
    }
}
