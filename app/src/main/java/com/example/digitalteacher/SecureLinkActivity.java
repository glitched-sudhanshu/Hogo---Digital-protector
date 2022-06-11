package com.example.digitalteacher;

import static com.android.volley.VolleyLog.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class SecureLinkActivity extends AppCompatActivity {

    private EditText editTxtWeb;
    private Button btnCheckLink;
    private TextView txtResultWeb, txtLinkResult;
    private ImageView imgLinkStatus;
    boolean unsafe, suspicious;
    int riskScore;
    String web;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secure_link);

        initViews();

        txtResultWeb.setVisibility(View.INVISIBLE);
        imgLinkStatus.setVisibility(View.INVISIBLE);


        btnCheckLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                web = editTxtWeb.getText().toString();
                editTxtWeb.setText("");

                RequestQueue queue = Volley.newRequestQueue(SecureLinkActivity.this);
                String url = "https://ipqualityscore.com/api/json/url/KTvmkc2ixB9GAa2OL29fIecC45vMaevK/";
                url = url.concat(web);

                Log.d(TAG, "onClick: " + url);

                String finalUrl = url;
                JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                        (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                            @Override
                            public void onResponse(JSONObject response) {
                                try {

                                    unsafe = response.getBoolean(("unsafe"));
                                    suspicious = response.getBoolean("suspicious");
                                    riskScore = response.getInt("risk_score");
                                    onResult();

                                    Log.d(TAG, "onResponse: url " + finalUrl + " unsafe "+ unsafe + " riskScore " + riskScore);
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }

                            }
                        }, new Response.ErrorListener() {

                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Log.d(TAG, "onErrorResponse: Error");
                            }
                        });
                queue.add(jsonObjectRequest);
            }
        });

    }

    public void onResult(){
        txtResultWeb.setVisibility(View.VISIBLE);
        if (riskScore>=75){
            imgLinkStatus.setImageResource(R.drawable.thumb_down_icon);
            imgLinkStatus.setVisibility(View.VISIBLE);
            txtLinkResult.setText("Suspicious URL, marked with a high chance for being involved in abusive behavior.");
            txtLinkResult.setVisibility(View.VISIBLE);
        }
        else if (riskScore>=85){
            imgLinkStatus.setImageResource(R.drawable.bad_password_icon);
            imgLinkStatus.setVisibility(View.VISIBLE);
            txtLinkResult.setText("High risk - strong confidence the URL is malicious");
            txtLinkResult.setVisibility(View.VISIBLE);
        }
        else if (riskScore == 100){
            imgLinkStatus.setImageResource(R.drawable.bad_password_icon);
            imgLinkStatus.setVisibility(View.VISIBLE);
            txtLinkResult.setText("confirmed involvement in malware or phishing activity in the past 24-48 hours.");
            txtLinkResult.setVisibility(View.VISIBLE);
        }
        else if (unsafe && riskScore<75){
            imgLinkStatus.setImageResource(R.drawable.thumb_down_icon);
            imgLinkStatus.setVisibility(View.VISIBLE);
            txtLinkResult.setText("This link might be unsafe.");
            txtLinkResult.setVisibility(View.VISIBLE);
        }
        else if(!unsafe){
            imgLinkStatus.setImageResource(R.drawable.thumbs_up_icon);
            imgLinkStatus.setVisibility(View.VISIBLE);
            txtLinkResult.setText("This link is completely safe");
            txtLinkResult.setVisibility(View.VISIBLE);
        }
        else if(web.contains("http:") || web.contains("bit.ly")){
            imgLinkStatus.setImageResource(R.drawable.thumb_down_icon);
            imgLinkStatus.setVisibility(View.VISIBLE);
            txtLinkResult.setText("This link might be unsafe.");
            txtLinkResult.setVisibility(View.VISIBLE);
        }
    }

    private void initViews() {
        editTxtWeb = findViewById(R.id.editTxtWeb);
        btnCheckLink = findViewById(R.id.btnCheckLink);
        txtResultWeb = findViewById(R.id.txtResultWeb);
        imgLinkStatus = findViewById(R.id.imgLinkStatus);
        txtLinkResult = findViewById(R.id.txtLinkResult);
    }
}