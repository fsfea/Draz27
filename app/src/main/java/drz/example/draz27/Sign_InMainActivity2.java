package drz.example.draz27;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import drz.example.draz27.data.AppDatabase;

import drz.example.draz27.data.usersTable.MyUser;
import drz.example.draz27.data.usersTable.MyuserQuery;

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
        if (isAllOK)
        {
            Toast.makeText(this, "All OK", Toast.LENGTH_SHORT).show();
            AppDatabase db = AppDatabase.getDB(getApplicationContext());
            MyuserQuery userQuery = (MyuserQuery) db.getMyUserQuery();
            MyUser myUser = userQuery.checkEmailPassw(email, password);
            if (myUser == null)
            {
                Toast.makeText(this, "Wrong Email Or Password", Toast.LENGTH_LONG).show();
            }
                 else
            {
                Intent i = new Intent(Sign_InMainActivity2.this, MainActivity.class);
                startActivity(i);

            }
        }

    }
    public void onClickSign_In(View v)
    {
        checkEmailPassw();
    }
}