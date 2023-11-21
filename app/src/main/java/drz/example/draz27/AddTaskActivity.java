package drz.example.draz27;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class AddTaskActivity extends AppCompatActivity {
    private Button btnUpdate;
    private Button BTNCancel;
    private SeekBar skbrImportance;
    private TextView tvImpoertance;
    private TextInputEditText etShortTitle;
    private TextInputEditText etText;
    private TextView textView ;
    private AutoCompleteTextView etSubject ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);
        btnUpdate = findViewById(R.id.btnUpdate);
        BTNCancel = findViewById(R.id.BTNCancel);
        skbrImportance = findViewById(R.id.skbrImportance);
        tvImpoertance = findViewById(R.id.tvImpoertance);
        etShortTitle = findViewById(R.id.etShortTitle);
        etText = findViewById(R.id.etPassword);
        etSubject = findViewById(R.id.etSubject);
    }

    private void checkEmailPassw() {
        boolean isAllOK = true;
        String short_title = etShortTitle.getText().toString();
        String Text = etText.getText().toString();
        String importance = tvImpoertance.getText().toString();
        if (short_title.length() < 8 || short_title.contains(" ") == true) {

            isAllOK = false;
            etShortTitle.setError("Wrong short_title");
        }
        if (Text.length() < 8 || Text.contains(" ") == true) {

            isAllOK = false;
            etText.setError("Wrong text");
        }

        if (importance.length() < 8 || importance.contains(" ") == true) {

            isAllOK = false;
            tvImpoertance.setError("Wrong importance");
        }


        if (isAllOK) {
            Toast.makeText(this, "All OK", Toast.LENGTH_SHORT).show();
        }


    }
    public void onClickSave(View v)
    {
        checkEmailPassw();

    }
    private AutoCompleteTextView etSubject;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);
        etSubject =findViewByld(R.id.etSubject);

