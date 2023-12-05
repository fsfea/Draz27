package drz.example.draz27;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class Edit_Task_Activity extends AppCompatActivity {
    private Button btnUpdate ;
    private Button BTNCancel ;
    private SeekBar skbrImportance ;
    private TextView tvImpoertance ;
    private TextInputEditText etShortTitle ;
    private TextInputEditText etText ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_task);

        btnUpdate = findViewById(R.id.btnUpdate);
        BTNCancel = findViewById(R.id.  BTNCancel);
        skbrImportance = findViewById(R.id.skbrImportance);
        tvImpoertance = findViewById(R.id.tvImpoertance);
        etShortTitle = findViewById(R.id.etShortTitle);
        etText = findViewById(R.id.etPassword);
    }
    private void onClickUpdate(View v){
        Intent i = new Intent(Edit_Task_Activity.this, MainActivity.class);
        startActivity(i);
        finish();
    }
    public void onClickCancel2(View v) {

        finish();
    }
}