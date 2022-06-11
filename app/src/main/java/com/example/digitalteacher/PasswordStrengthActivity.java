package com.example.digitalteacher;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class PasswordStrengthActivity extends AppCompatActivity {

    private EditText editTxtPw;
    private TextView txtResultPw, txtPwTip, txtPwResult;
    private ImageView imgResultPw;
    private Button btnCheckPw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password_strength);

        //initializing views
        initViews();

        //button listener
        btnCheckPw.setOnClickListener(view -> {
            checkPassword();
        });

    }

    //checking password
    void checkPassword(){
        txtResultPw.setVisibility(View.VISIBLE);
        String userPw = editTxtPw.getText().toString();
        editTxtPw.setText("");
        imgResultPw.setVisibility(View.INVISIBLE);

        int length = userPw.length();

        boolean containsNum = false;
        boolean containsUpperCaseLetter = false;
        boolean containsLowerCaseLetter = false;
        boolean containsSpecialChar = false;

        for (int i=0; i<length; i++){
            if (userPw.charAt(i)>=48 && userPw.charAt(i)<=57){
                containsNum = true;
            }
            else if (userPw.charAt(i)>=65 && userPw.charAt(i)<=90){
                containsUpperCaseLetter = true;
            }
            else if (userPw.charAt(i)>=97 && userPw.charAt(i)<=122){
                containsLowerCaseLetter = true;
            }
            else{
                containsSpecialChar = true;
            }
        }

        if (length<=8 && length>=6 && containsLowerCaseLetter && containsNum && containsUpperCaseLetter && containsSpecialChar){
            txtPwResult.setText("Your password is moderate. Add more characters to make it strong.");
            txtPwResult.setVisibility(View.VISIBLE);
            imgResultPw.setVisibility(View.VISIBLE);
            imgResultPw.setImageResource(R.drawable.thumbs_up_icon);
            txtPwTip.setText("Tip:\n\nDo not set the same password on multiple accounts/sites.");
            txtPwTip.setVisibility(View.VISIBLE);
        }
        else if (length>=6 && containsLowerCaseLetter && containsNum && containsUpperCaseLetter && !containsSpecialChar){
            txtPwResult.setText("Your password is moderate. Add some special characters to make it strong.");
            txtPwResult.setVisibility(View.VISIBLE);
            imgResultPw.setVisibility(View.VISIBLE);
            imgResultPw.setImageResource(R.drawable.thumbs_up_icon);
            txtPwTip.setText("Tip:\n\nDo not store your passwords on apps which are not encrypted.");
            txtPwTip.setVisibility(View.VISIBLE);
        }
        else if (length>8 && containsLowerCaseLetter && containsNum && containsUpperCaseLetter && containsSpecialChar){
            txtPwResult.setText("You are safe. Your password is very strong.");
            txtPwResult.setVisibility(View.VISIBLE);
            imgResultPw.setVisibility(View.VISIBLE);
            imgResultPw.setImageResource(R.drawable.thumbs_up_icon);
            txtPwTip.setText("Tip:\n\nChange your password on regular intervals.");
            txtPwTip.setVisibility(View.VISIBLE);
        }
        else if (length<6){
            txtPwResult.setText("Your password is too weak. Add more numeric, letters or special characters to make it strong.");
            txtPwResult.setVisibility(View.VISIBLE);
            imgResultPw.setVisibility(View.VISIBLE);
            imgResultPw.setImageResource(R.drawable.bad_password_icon);
            txtPwTip.setText("Do not share your passwords with anyone!");
            txtPwTip.setVisibility(View.VISIBLE);

        }
    }

    private void initViews() {
        editTxtPw = findViewById(R.id.editTxtPw);
        txtResultPw = findViewById(R.id.txtResultPw);
        txtPwTip = findViewById(R.id.txtPwTip);
        imgResultPw = findViewById(R.id.imgResultPw);
        btnCheckPw = findViewById(R.id.btnCheckPw);
        txtPwResult = findViewById(R.id.txtPwResult);
    }
}