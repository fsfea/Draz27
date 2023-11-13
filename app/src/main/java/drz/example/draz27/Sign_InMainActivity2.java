package drz.example.draz27;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class Sign_InMainActivity2 extends AppCompatActivity
{
    private TextInputEditText etShortTitle ;
    private TextInputEditText etPassword ;
    private Button btnSignUP ;
    private Button btnsignin ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in_main2);
        etShortTitle = findViewById(R.id.etShortTitle);
        etPassword = findViewById(R.id.etText);
        btnSignUP = findViewById(R.id.btnSignUP);
        btnsignin = findViewById(R.id.btnsignin);

    }
    public void onClickSignUp (View v)
    {
        Intent i = new Intent( Sign_InMainActivity2.this,SignUpActivityMain2Activity.class );
        startActivity(i);
    }
}