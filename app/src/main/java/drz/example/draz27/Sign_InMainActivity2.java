package drz.example.draz27;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class Sign_InMainActivity2 extends AppCompatActivity {
    private TextInputEditText etShortTitle;
    private TextInputEditText etPassword;
    private Button btnSignUP;
    private Button btnsignin;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in_main2);
        etShortTitle = findViewById(R.id.etShortTitle);
        etPassword = findViewById(R.id.etPassword);
        btnSignUP = findViewById(R.id.btnSignUP);
        btnsignin = findViewById(R.id.btnsignin);

    }

    public void onClickSignUp(View v) {
        Intent i = new Intent(Sign_InMainActivity2.this, SignUpActivityMain2Activity.class);
        startActivity(i);
    }

    private void checkEmailPassw() {
        boolean isAllOK = true;
        String email = etShortTitle.getText().toString();
        String password = etPassword.getText().toString();
        if (email.length() < 6 | email.contains("@") == false) {
            isAllOK = false;

            etShortTitle.setError("Wrong Email");
        }
        if (password.length() < 8 || password.contains(" ") == true) {

            isAllOK = false;
            etPassword.setError("Wrong Password");
        }
        if (isAllOK) {
            Toast.makeText(this, "All OK", Toast.LENGTH_SHORT).show();
        }
    }
    public void onClickSignin(View v)
    {

    }
}