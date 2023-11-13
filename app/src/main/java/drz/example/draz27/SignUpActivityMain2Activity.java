package drz.example.draz27;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class SignUpActivityMain2Activity extends AppCompatActivity {

    private Button btnUpdate ;
    private Button BTNCancel ;
    private TextInputEditText etname ;
    private TextInputEditText etphone ;
    private TextInputEditText etShortTitle ;
    private TextInputEditText etPassword ;
    private TextInputEditText etre_password ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up_activity_main2);
        btnUpdate = findViewById(R.id.btnUpdate);
        BTNCancel = findViewById(R.id.  BTNCancel);
        etname = findViewById(R.id.etname);
        etphone = findViewById(R.id. etphone);
        etShortTitle = findViewById(R.id.etShortTitle);
        etPassword = findViewById(R.id.etText);
        etre_password = findViewById(R.id.etre_password);

    }
    public void onClickCancel (View v)
    {

        finish();
    }
}