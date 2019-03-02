package com.iitbbs.prajjwala;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.app.Fragment;
import android.support.design.widget.NavigationView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;

import org.w3c.dom.Text;


public class BlankFragment2 extends Fragment {

    String email, link_uri, retailer_name, ret_id, ret_dob, phone, aadhaar, city, state, username, num_consumers, license;

    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {


        SharedPreferences mPrefs = getActivity().getSharedPreferences("MyPreferences",0);
        retailer_name = mPrefs.getString("Retailer_name", "");
        Log.d("huhu",retailer_name);

        email = mPrefs.getString("Retailer_email","");
        Log.d("huhu",email);

        link_uri = mPrefs.getString("Profile_pic","");
        Log.d("huhu",link_uri);

        Uri imageUri = Uri.parse(link_uri);

        ret_id = mPrefs.getString("Retailer_id","");

        Log.d("huhu", imageUri.toString());

        ret_dob = mPrefs.getString("DOB","");

        phone = mPrefs.getString("Phone_retailer","");

        aadhaar = mPrefs.getString("Aadhaar_retailer","");

        city = mPrefs.getString("City_retailer","");

        state = mPrefs.getString("State_retailer","");

        username = mPrefs.getString("UserName","");

        license = mPrefs.getString("License_number","");

        num_consumers = mPrefs.getString("No_consumers","");




        View view = inflater.inflate(R.layout.fragment_blank_fragment2,container,false);




        SimpleDraweeView draweeView = (SimpleDraweeView) view.findViewById(R.id.sdvImage1);
        draweeView.setImageURI(imageUri);


        TextView name_ret= view.findViewById(R.id.retailer_name);
        name_ret.setText(retailer_name);

        TextView id_ret = view.findViewById(R.id.retailer_id);
        id_ret.setText(ret_id);

        TextView dob_ret = view.findViewById(R.id.retailer_dob);
        dob_ret.setText(ret_dob);

        TextView ph_no = view.findViewById(R.id.retailer_ph_number);
        ph_no.setText(phone);

        TextView aadhaar_no = view.findViewById(R.id.retailer_aadhar_number);
        aadhaar_no.setText(aadhaar);


        TextView city_ret = view.findViewById(R.id.retailer_city);
        city_ret.setText(city);

        TextView state_ret = view.findViewById(R.id.retailer_state);
        state_ret.setText(state);

        TextView username_ret = view.findViewById(R.id.retailer_user_name);
        username_ret.setText(username);

        TextView license_retailer = view.findViewById(R.id.retailer_license);
        license_retailer.setText(license);

        TextView num_of_consumers = view.findViewById(R.id.retailer_consumers);
        num_of_consumers.setText(num_consumers);

        return view;

    }
}
