package com.example.daniel.contactlist_proj.ui;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.example.daniel.contactlist_proj.R;
import com.example.daniel.contactlist_proj.adapters.CustomAdapter;
import com.example.daniel.contactlist_proj.data.Contact;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.SimpleType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.spothero.volley.JacksonNetwork;
import com.spothero.volley.JacksonRequest;
import com.spothero.volley.JacksonRequestListener;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class RecyclerFragment extends Fragment {

    private static final String URL_CONTACTS = "https://s3.amazonaws.com/technical-challenge/Contacts.json";

    private CustomAdapter customAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<Contact> contacts;

    private RecyclerView recyclerView;


    public RecyclerFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_recycler, container, false);
        View view = inflater.inflate(R.layout.fragment_recycler, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        recyclerView = (RecyclerView) getView().findViewById(R.id.fr_contactsList);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);


        RequestQueue mRequestQue = JacksonNetwork.newRequestQueue(getActivity().getApplicationContext());
        mRequestQue.add(new JacksonRequest<ArrayList<Contact>>(Request.Method.GET, URL_CONTACTS,
                new JacksonRequestListener<ArrayList<Contact>>() {
            @Override
            public void onResponse(ArrayList<Contact> response, int statusCode, VolleyError error) {
                if (response != null) {
                    customAdapter = new CustomAdapter(response);
                    recyclerView.setAdapter(customAdapter);
                    Toast.makeText(getContext(), "Worked", Toast.LENGTH_SHORT).show();
                }else{

                    Toast.makeText(getContext(), "Error" + statusCode, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public JavaType getReturnType() {
                //return SimpleType.constructUnsafe(Contact.class);
                return TypeFactory.defaultInstance().constructCollectionType(List.class, Contact.class);
            }
        }));
    }

}
