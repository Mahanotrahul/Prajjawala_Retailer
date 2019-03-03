package com.iitbbs.prajjwala;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;


public class BlankFragment9 extends Fragment {

        EditText name_cust, email_cust, aadhaar_cust, phone_cust, dob_cust, state_cust, city_cust, address_cust, pin_cust;
        String username_ret, pass_ret;
        Button register_cust;




        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.fragment_blank_fragment9,container,false);

            name_cust = ((EditText)view.findViewById(R.id.name));

            email_cust = ((EditText)view.findViewById(R.id.email));
            aadhaar_cust = ((EditText)view.findViewById(R.id.aadhar));
            phone_cust = ((EditText)view.findViewById(R.id.phone));
            dob_cust = ((EditText)view.findViewById(R.id.dob));
            state_cust = ((EditText)view.findViewById(R.id.state));
            city_cust = (EditText)view.findViewById(R.id.city);
            address_cust = (EditText) view.findViewById(R.id.address);
            pin_cust = (EditText) view.findViewById(R.id.pin_code);

            SharedPreferences mPrefs = getActivity().getSharedPreferences("MyPreferences",0);
            username_ret = mPrefs.getString("UserName", "");

            pass_ret = mPrefs.getString("Password","");








            register_cust = view.findViewById(R.id.register_button);


            register_cust.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    if(sanitizeInput()) {
                        add_customer();
                    }
                }
            });




            return view;

        }

        private boolean sanitizeInput() {
            return true;
        }

        private void add_customer() {

            Log.d("huhu",name_cust.getText().toString());
            try {
                String op = new RegisterToDB().execute().get();

            }
            catch (Exception e) {

            }

        }

        private class RegisterToDB extends AsyncTask<String, Void, String> {
            String line = "We sense that your connection might be weak...";
            @Override
            protected String doInBackground(String... strings) {
                BufferedReader reader = null;
                try {

                    String link = "https://vasitars.com/old/prajjawala/APP/Register_New_Customer.php";
                    URL url = new URL(link);

                    String data = URLEncoder.encode("SUBMIT_CONSUMER_NAME", "UTF-8")
                            + "=" + URLEncoder.encode(name_cust.getText().toString(), "UTF-8");

                    data += "&" + URLEncoder.encode("SUBMIT_CONSUMER_EMAIL", "UTF-8")
                            + "=" + URLEncoder.encode(email_cust.getText().toString(), "UTF-8");

                    data += "&" + URLEncoder.encode("SUBMIT_DATE_OF_BIRTH", "UTF-8")
                            + "=" + URLEncoder.encode(dob_cust.getText().toString(), "UTF-8");

                    data += "&" + URLEncoder.encode("SUBMIT_PHONE_NUMBER", "UTF-8")
                            + "=" + URLEncoder.encode(phone_cust.getText().toString(), "UTF-8");

                    data += "&" + URLEncoder.encode("SUBMIT_CONSUMER_AADHAAR_NUMBER", "UTF-8")
                            + "=" + URLEncoder.encode(aadhaar_cust.getText().toString(), "UTF-8");

                    data += "&" + URLEncoder.encode("SUBMIT_CITY", "UTF-8")
                            + "=" + URLEncoder.encode(city_cust.getText().toString(), "UTF-8");

                    data += "&" + URLEncoder.encode("SUBMIT_STATE", "UTF-8")
                            + "=" + URLEncoder.encode(state_cust.getText().toString(), "UTF-8");

                    data += "&" + URLEncoder.encode("SUBMIT_COMPLETE_ADDRESS", "UTF-8")
                            + "=" + URLEncoder.encode(address_cust.getText().toString(), "UTF-8");

                    data += "&" + URLEncoder.encode("SUBMIT_PIN", "UTF-8")
                            + "=" + URLEncoder.encode(pin_cust.getText().toString(), "UTF-8");

                    data += "&" + URLEncoder.encode("Username", "UTF-8")
                            + "=" + URLEncoder.encode(username_ret, "UTF-8");

                    data += "&" + URLEncoder.encode("Password", "UTF-8")
                            + "=" + URLEncoder.encode(pass_ret, "UTF-8");





                    Log.d("here", data);

                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();

                    conn.setRequestMethod("POST");
                    OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
                    wr.write(data);
                    wr.flush();
                    reader = new BufferedReader(new
                            InputStreamReader(conn.getInputStream()));


                    line = reader.readLine();

                    Log.i("huhu", line);



                } catch (Exception e) {
                    e.printStackTrace();
                }

                return line;
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                Toast.makeText(getActivity().getApplicationContext(), line, Toast.LENGTH_LONG).show();
            }
        }
    }

