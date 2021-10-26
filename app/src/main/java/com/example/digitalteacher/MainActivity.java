package com.example.digitalteacher;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ImageButton btnPwStrength, btnLeakedVideos;
    private TextView txtTOTD;
    private Button btnPwned;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

        txtTOTD.setMovementMethod(new ScrollingMovementMethod());

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
    }

    private void initViews() {
        btnPwStrength = findViewById(R.id.btnPwStrength);
        btnLeakedVideos = findViewById(R.id.btnLeakedVideos);
        txtTOTD = findViewById(R.id.txtTOTD);
        btnPwned = findViewById(R.id.btnPwned);
    }
}