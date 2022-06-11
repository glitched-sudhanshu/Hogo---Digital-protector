package com.example.digitalteacher;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ImageButton btnPwStrength, btnLeakedVideos,btnSecureLink, btnPiracy, btnMoreTips;
    private TextView txtTOTD;
    private Button btnPwned;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

        totd();

        btnsListner();

        txtTOTD.setMovementMethod(new ScrollingMovementMethod());




    }

    private void initViews() {
        btnPwStrength = findViewById(R.id.btnPwStrength);
        btnLeakedVideos = findViewById(R.id.btnLeakedVideos);
        txtTOTD = findViewById(R.id.txtTOTD);
        btnPwned = findViewById(R.id.btnPwned);
        btnSecureLink = findViewById(R.id.btnSecureLink);
        btnPiracy = findViewById(R.id.btnPiracy);
        btnMoreTips = findViewById(R.id.btnMoreTips);
    }

    public void btnsListner(){
        btnPwStrength.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, PasswordStrengthActivity.class);
            startActivity(intent);
        });

        btnLeakedVideos.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, LeakedVideoActivity.class);
            startActivity(intent);
        });

        btnPwned.setOnClickListener(view -> {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("https://haveibeenpwned.com/"));
            startActivity(intent);
        });

        btnSecureLink.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, SecureLinkActivity.class);
            startActivity(intent);
        });

        btnPiracy.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, SecureLinkActivity.class);
            startActivity(intent);
        });

        btnMoreTips.setOnClickListener(view -> {

        });
    }

    public void totd(){
        ArrayList<String> tips = new ArrayList<>();
        tips.add("Always log out from a website when your work is done if you don't believe that site is safe or not.");
        tips.add("Use a VPN to add an extra layer of personal privacy on internet.");
        tips.add("Do not scan a QR code to receive payment via UPI unless you trust that person. A lot of scams nowadays take place with the help(money from you account would be deducted) of is method due to lack of awareness.");
        tips.add("Do not download third party anti-virus mobile applications as these applications make a smartphone slow and consume a lot of battery and ram.");
        tips.add("Be careful about publicly sharing your identity, location, and your date of birth.");
        tips.add("Use two-step authentication for verification of you email ID's on various applications.");
        tips.add("Always bit erase your old mobile after formatting it, before selling it. BitRaser is one of such app.");

        Random rand = new Random();
        int randomIndex = rand.nextInt(tips.size());

        txtTOTD.setText(tips.get(randomIndex));
    }

}