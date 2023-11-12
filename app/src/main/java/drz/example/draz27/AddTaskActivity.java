package drz.example.draz27;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;

public class AddTaskActivity extends AppCompatActivity {
    private Button btnUpdate ;
    private Button BTNCancel ;
    private SeekBar skbrImportance ;
    private TextView tvImpoertance ;
    private TextInputLayout etShortTitle ;
    private TextInputLayout etText ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);
        btnUpdate = findViewById(R.id.btnUpdate);
        BTNCancel = findViewById(R.id.  BTNCancel);
        skbrImportance = findViewById(R.id.skbrImportance);
        tvImpoertance = findViewById(R.id.tvImpoertance);
        etShortTitle = findViewById(R.id.etShortTitle);
        etText = findViewById(R.id.etText);



    }
}