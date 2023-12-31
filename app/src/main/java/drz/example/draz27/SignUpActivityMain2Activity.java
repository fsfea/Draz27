package drz.example.draz27;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import drz.example.draz27.data.AppDatabase;
import drz.example.draz27.data.usersTable.MyUser;
import drz.example.draz27.data.usersTable.MyuserQuery;

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
        etPassword = findViewById(R.id.etPassword);
        etre_password = findViewById(R.id.etre_password);

    }

    public void onClickCancel(View v) {

        finish();
    }

    private void checkEmailPassw() {
        boolean isAllOK = true;
        String email = etShortTitle.getText().toString();
        String password = etPassword.getText().toString();
        String re_password = etre_password.getText().toString();
        String name = etname.getText().toString();
        String phone = etphone.getText().toString();

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
            etre_password.setError("Wrong re_Password");
        }
        if (name.length() < 3 || name.contains(" ") == true) {

            isAllOK = false;
            etname.setError("Wrong name");
        }
        if (phone.length() < 10 || phone.contains(" ") == true) {

            isAllOK = false;
            etphone.setError("Wrong phone");
        }

        if (isAllOK) {
            Toast.makeText(this, "All OK", Toast.LENGTH_SHORT).show();
            AppDatabase db = AppDatabase.getDB(getApplicationContext());
            MyuserQuery userQuery =db.getMyUserQuery();
            if (userQuery.checkEmail(email)!= null)
            {
                etShortTitle.setError("found email");
            }
            else
            {
                MyUser myUser=new MyUser();
                myUser.email=email; myUser.fullName=name;
                myUser.phone=phone; myUser.passw=password;
                userQuery.insert(myUser);
                finish();
            }
        }
    }

        public void onClickSignUp (View v)
        {
            checkEmailPassw();


        }

    }
