package drz.example.draz27;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

import com.google.android.material.textfield.TextInputLayout;

public class SignUpActivityMain2Activity extends AppCompatActivity {

    private Button btnUpdate ;
    private Button BTNCancel ;
    private TextInputLayout etname ;
    private TextInputLayout etphone ;
    private TextInputLayout etShortTitle ;
    private TextInputLayout etPassword ;
    private TextInputLayout etre_password ;
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
}