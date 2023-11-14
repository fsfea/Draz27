package drz.example.draz27;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class SignUpActivityMain2Activity extends AppCompatActivity {

    private Button btnUpdate;
    private Button BTNCancel;
    private TextInputEditText etname;
    private TextInputEditText etphone;
    private TextInputEditText etShortTitle;
    private TextInputEditText etPassword;
    private TextInputEditText etre_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up_activity_main2);
        btnUpdate = findViewById(R.id.btnUpdate);
        BTNCancel = findViewById(R.id.BTNCancel);
        etname = findViewById(R.id.etname);
        etphone = findViewById(R.id.etphone);
        etShortTitle = findViewById(R.id.etShortTitle);
        etPassword= findViewById(R.id.etPassword);
        etre_password = findViewById(R.id.etre_password);

    }

    public void onClickCancel(View v) {

        finish();
    }

    private void checkEmailPassw() {
        boolean isAllOK = true;
        String email = etShortTitle.getText().toString();
        String password =etPassword.getText().toString();
        String re_password = etre_password.getText().toString();
        String name = etname.getText().toString();
        String phone =  etphone.getText().toString();

        if (email.length() < 6 | email.contains("@") == false) {
            isAllOK = false;

            etShortTitle.setError("Wrong Email");
        }
        if (password.length() < 8 || password.contains(" ") == true) {

            isAllOK = false;
            etPassword.setError("Wrong Password");
        }
          if (re_password.length() < 8 || re_password.contains(" ") == true) {

              isAllOK = false;
              etre_password.setError("Wrong Password");
          }

        if (isAllOK) {
            Toast.makeText(this, "All OK", Toast.LENGTH_SHORT).show();
        }

    }

    public void onClickSignIn(View v) {


    }
}