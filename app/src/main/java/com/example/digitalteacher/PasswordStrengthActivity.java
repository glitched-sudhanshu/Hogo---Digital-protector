package com.example.digitalteacher;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;


//password strength activity
public class PasswordStrengthActivity extends AppCompatActivity {

    private EditText editTxtPassword;
    private TextView txtPwResult, txtPwTip, txtResults;
    private ImageView imgBadPw, imgModeratePw, imgGoodPw;
    private Button btnCheck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password_strength);

        //initializing views
        initViews();

        //button listener
        btnCheck.setOnClickListener(view -> {
            checkPassword();
        });

    }

    //checking password
    void checkPassword(){
        txtResults.setVisibility(View.VISIBLE);
        String userPw = editTxtPassword.getText().toString();
        editTxtPassword.setText("");
        imgModeratePw.setVisibility(View.INVISIBLE);
        imgBadPw.setVisibility(View.INVISIBLE);
        imgGoodPw.setVisibility(View.INVISIBLE);

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
            imgModeratePw.setVisibility(View.VISIBLE);
            txtPwTip.setText("Tip:\n\nDo not set the same password on multiple accounts/sites.");
            txtPwTip.setVisibility(View.VISIBLE);
        }
        else if (length>=6 && containsLowerCaseLetter && containsNum && containsUpperCaseLetter && !containsSpecialChar){
            txtPwResult.setText("Your password is moderate. Add some special characters to make it strong.");
            txtPwResult.setVisibility(View.VISIBLE);
            imgModeratePw.setVisibility(View.VISIBLE);
            txtPwTip.setText("Tip:\n\nDo not store your passwords on apps which are not encrypted.");
            txtPwTip.setVisibility(View.VISIBLE);
        }
        else if (length>8 && containsLowerCaseLetter && containsNum && containsUpperCaseLetter && containsSpecialChar){
            txtPwResult.setText("You are safe. Your password is very strong.");
            txtPwResult.setVisibility(View.VISIBLE);
            imgGoodPw.setVisibility(View.VISIBLE);
            txtPwTip.setText("Tip:\n\nChange your password on regular intervals.");
            txtPwTip.setVisibility(View.VISIBLE);
        }
        else if (length<6){
            txtPwResult.setText("Your password is too weak. Add more numeric, letters or special characters to make it strong.");
            txtPwResult.setVisibility(View.VISIBLE);
            imgBadPw.setVisibility(View.VISIBLE);
            txtPwTip.setText("Do not share your passwords with anyone!");
            txtPwTip.setVisibility(View.VISIBLE);

        }
    }

    private void initViews() {
        editTxtPassword = findViewById(R.id.editTxtPassword);
        txtPwResult = findViewById(R.id.txtPwResult);
        txtPwTip = findViewById(R.id.txtPwTip);
        imgBadPw = findViewById(R.id.imgBadPw);
        imgModeratePw = findViewById(R.id.imgModeratePw);
        imgGoodPw = findViewById(R.id.imgGoodPw);
        btnCheck = findViewById(R.id.btnCheck);
        txtResults = findViewById(R.id.txtResults);
    }
}