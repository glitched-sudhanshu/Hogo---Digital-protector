package com.example.digitalteacher;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

public class LeakedVideoActivity extends AppCompatActivity {

    private Spinner spinner;
    private Button btnWebsite;
    private TextView txtDisclaimer;
    private ImageView imgSiteLogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leaked_video);

        initViews();

        txtDisclaimer.setMovementMethod(new ScrollingMovementMethod());

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.Porn_websites));
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_list_item_1);
        spinner.setAdapter(arrayAdapter);


        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                String website = adapterView.getItemAtPosition(i).toString();
                Intent dmcaWebpage = new Intent(Intent.ACTION_VIEW);
                String weblink;

                if (website.equals("Redtube")) {
                    weblink = "https://www.redtube.com/content_removal";
                    imgSiteLogo.setImageResource(R.drawable.redtube_logo);
                    imgSiteLogo.setVisibility(View.VISIBLE);
                } else if (website.equals("Google")) {
                    weblink = "https://support.google.com/legal/troubleshooter/1114905?hl=en";
                    imgSiteLogo.setImageResource(R.drawable.google_logo);
                    imgSiteLogo.setVisibility(View.VISIBLE);
                } else if (website.equals("Pornhub")) {
                    weblink = "https://www.pornhub.com/information/dmcaform";
                    imgSiteLogo.setImageResource(R.drawable.pornhub_logo);
                    imgSiteLogo.setVisibility(View.VISIBLE);
                } else if (website.equals("Youporn")) {
                    weblink = "https://www.youporn.com/content-removal/";
                    imgSiteLogo.setImageResource(R.drawable.youporn_logo);
                    imgSiteLogo.setVisibility(View.VISIBLE);
                } else if (website.equals("Xhamster")) {
                    weblink = "https://xhamster3.com/info/dmca";
                    imgSiteLogo.setImageResource(R.drawable.xhamster_logo);
                    imgSiteLogo.setVisibility(View.VISIBLE);
                } else if (website.equals("Xvideos")) {
                    weblink = "https://info.xvideos.com/takedown";
                    imgSiteLogo.setImageResource(R.drawable.xvideos_logo);
                    imgSiteLogo.setVisibility(View.VISIBLE);
                } else {
                    weblink = "https://multi.xnxx.com/takedown/";
                    imgSiteLogo.setImageResource(R.drawable.xnxx_logo);
                    imgSiteLogo.setVisibility(View.VISIBLE);
                }

                btnWebsite.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        /**
                        String website = adapterView.getItemAtPosition(i).toString();
                        Intent dmcaWebpage = new Intent(Intent.ACTION_VIEW);
                        String weblink;
                        if (website.equals("Redtube")) {
                            weblink = "https://www.redtube.com/content_removal";
                            imgSiteLogo.setImageResource(R.drawable.redtube_logo);
                            imgSiteLogo.setVisibility(View.VISIBLE);
                        } else if (website.equals("Google")) {
                            weblink = "https://support.google.com/legal/troubleshooter/1114905?hl=en";
                            imgSiteLogo.setImageResource(R.drawable.google_logo);
                            imgSiteLogo.setVisibility(View.VISIBLE);
                        } else if (website.equals("Pornhub")) {
                            weblink = "https://www.pornhub.com/information/dmcaform";
                            imgSiteLogo.setImageResource(R.drawable.pornhub_logo);
                            imgSiteLogo.setVisibility(View.VISIBLE);
                        } else if (website.equals("Youporn")) {
                            weblink = "https://www.youporn.com/content-removal/";
                            imgSiteLogo.setImageResource(R.drawable.youporn_logo);
                            imgSiteLogo.setVisibility(View.VISIBLE);
                        } else if (website.equals("Xhamster")) {
                            weblink = "https://xhamster3.com/info/dmca";
                            imgSiteLogo.setImageResource(R.drawable.xhamster_logo);
                            imgSiteLogo.setVisibility(View.VISIBLE);
                        } else if (website.equals("Xvideos")) {
                            weblink = "https://info.xvideos.com/takedown";
                            imgSiteLogo.setImageResource(R.drawable.xvideos_logo);
                            imgSiteLogo.setVisibility(View.VISIBLE);
                        } else {
                            weblink = "https://multi.xnxx.com/takedown/";
                            imgSiteLogo.setImageResource(R.drawable.xnxx_logo);
                            imgSiteLogo.setVisibility(View.VISIBLE);
                        }
                         **/
                        dmcaWebpage.setData(Uri.parse(weblink));
                        startActivity(dmcaWebpage);
                    }
                });

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

    private void initViews() {
        spinner = findViewById(R.id.spinner);
        btnWebsite = findViewById(R.id.btnWebsite);
        txtDisclaimer = findViewById(R.id.txtDisclaimer);
        imgSiteLogo = findViewById(R.id.imgSiteLogo);
    }
}