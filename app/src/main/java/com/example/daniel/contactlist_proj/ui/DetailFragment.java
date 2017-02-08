package com.example.daniel.contactlist_proj.ui;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.daniel.contactlist_proj.R;
import com.example.daniel.contactlist_proj.data.Contact;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetailFragment extends Fragment {

    private ImageView contImgVw;
    private TextView nameTxtVw;
    private TextView companyTxtVw;
    private TextView phoneTxtVw;
    private TextView addressTxtVw;
    private TextView emailTxtVw;

    private Contact contact;

    public DetailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        contImgVw = (ImageView) getView().findViewById(R.id.fd_cntImgDtl);
        nameTxtVw = (TextView) getView().findViewById(R.id.fd_cntName);
        companyTxtVw = (TextView) getView().findViewById(R.id.fd_cntCompany);
        phoneTxtVw = (TextView) getView().findViewById(R.id.fd_cntPhone);
        addressTxtVw = (TextView) getView().findViewById(R.id.fd_cntAddress);
        emailTxtVw = (TextView) getView().findViewById(R.id.fd_cntEmail);

        contact = this.getArguments().getParcelable("CONTAC");

        Glide.with(getContext())
                .load(contact.getSmallImageURL())
                .into(contImgVw);

        nameTxtVw.setText(contact.getName());
        companyTxtVw.setText(contact.getCompany());
        phoneTxtVw.setText(contact.getPhone().getMobile());
        addressTxtVw.setText(contact.getAddress().getCity()
                + contact.getAddress().getState() + contact.getAddress().getStreet());
        emailTxtVw.setText(contact.getEmail());
    }
}
