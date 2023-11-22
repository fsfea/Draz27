package drz.example.draz27;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import java.util.List;

import drz.example.draz27.data.AppDatabase;
import drz.example.draz27.data.SubjectTable.MySubject;
import drz.example.draz27.data.SubjectTable.MySubjectQuery;
import drz.example.draz27.data.mytasksTable.MyTasks;

public class AddTaskActivity extends AppCompatActivity {
    private Button btnUpdate;
    private Button BTNCancel;
    private SeekBar skbrImportance;
    private TextView tvImpoertance;
    private TextInputEditText etShortTitle;
    private TextInputEditText etText;
    private TextView textView;
    private AutoCompleteTextView autoEtSubj;


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
        autoEtSubj = findViewById(R.id.autoEtSubj);
        initAutoEtSubjects();
    }
private void initAutoEtSubjects()
{

      AppDatabase db =AppDatabase.getDB(getApplicationContext());
      MySubjectQuery subjectQuery=db.getMySubjectQuery();
    List<MySubject>allSubjects=subjectQuery.getAllSubjects();
    ArrayAdapter<MySubject> adapter=new ArrayAdapter<MySubject>(this, android.R.layout.simple_dropdown_item_1line);
    adapter.addAll(allSubjects);
    autoEtSubj.setAdapter(adapter);

    autoEtSubj.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            autoEtSubj.showDropDown();
        }
    });

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

    public void onClickSave(View v) {
        checkEmailPassw();

    }



}

