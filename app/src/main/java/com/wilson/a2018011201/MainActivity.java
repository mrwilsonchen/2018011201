package com.wilson.a2018011201;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void click1(View v)
    {
        RequestQueue queue = Volley.newRequestQueue(MainActivity.this);
        final StringRequest request = new StringRequest("http://data.ntpc.gov.tw/od/data/api/BF90FA7E-C358-4CDA-B579-B6C84ADC96A1?$format=json",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("NET", response);
                        Gson gson = new Gson();
                        Animal[] houses = gson.fromJson(response, Animal[].class);

                        for (Animal a : houses)
                        {
                            Log.d("NET", a.district + "," + a.address);
                            Log.d("NET", "Done");
                        }
                        /*
                                           try {
                                           JSONArray array = new JSONArray(response);
                                               int i;
                                              for (i=0;i<array.length();i++)
                                             {
                                                 JSONObject obj = array.getJSONObject(i);
                                                String str = obj.getString("district");
                                                Log.d("NET", str);
                                             }
                                          }
                                          catch (JSONException e) {
                                             e.printStackTrace();
                                          }
                                         */
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        queue.add(request);
        queue.start();



    }

}
