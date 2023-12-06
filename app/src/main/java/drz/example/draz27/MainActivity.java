package drz.example.draz27;

import static android.os.Build.VERSION_CODES.S;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;

import android.content.Intent;
import android.os.Bundle;
import android.service.controls.actions.FloatAction;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

import drz.example.draz27.data.AppDatabase;
import drz.example.draz27.data.SubjectTable.MySubject;
import drz.example.draz27.data.SubjectTable.MySubjectQuery;
import drz.example.draz27.data.mytasksTable.MyTasks;
import drz.example.draz27.data.mytasksTable.MyTasksQuery;

public class MainActivity extends AppCompatActivity {

    private FloatingActionButton fabAdd ;
    private Spinner spnrSubject ;
    private SearchView srchV ;
    private ListView lstvTasks ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        fabAdd = findViewById(R.id.fabAdd);
        fabAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { Intent i = new Intent(MainActivity.this, AddTaskActivity.class);
                startActivity(i);

            }
        });
        spnrSubject = findViewById(R.id.spnrSubject);
        srchV = findViewById(R.id.srchV);
        lstvTasks = findViewById(R.id.lstvTasks);


        Log.d("draz","onCreate");
        Toast.makeText(this, "", Toast.LENGTH_SHORT).show();

        //بناء قاعدة البيانات وارجاع مؤشر عليها1
      AppDatabase db= AppDatabase.getDB(getApplicationContext());
        //مؤشر لجدول2
        MySubjectQuery mySubjectQuery = db.getMySubjectQuery();
        //بناء كائن من نوع الجدول وتحديد قيم الصفات3
        MySubject s1=new MySubject();
        s1.setTitle("Math");
        MySubject s2=new MySubject();
        s2.title="Computers";
        //اضافة كائن للجدول4
       MySubjectQuery.insert(s1);
        MySubjectQuery.insert(s2);
        // فحص هل تم حفظ ما سبق5
        // استخراج وطباعة جميع معطيات الجدول المواضيع6
        List<MySubject> allSubjects = mySubjectQuery.getAll();
        for (MySubject e :allSubjects )
        {
            Log.d( " "," ");
            Toast.makeText(this, " ", Toast.LENGTH_SHORT).show();
        }


    }
    @Override
    public boolean onCreateOptionsMenu(android.view.Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.itmSettings) {
            Toast.makeText(this, "Settings", Toast.LENGTH_SHORT).show();
        }

        if (item.getItemId() == R.id.itmlogOut) {
            Toast.makeText(this, "LogOut", Toast.LENGTH_SHORT).show();
        }
        return true;
    }
    public void ShowPopUpMenu (View v)
    {
        PopupMenu popup = new PopupMenu(this,v);
        popup.inflate(R.menu.popup_menu);
        popup.show();
    }
    /**
     * عملية تجهيز السبنر بالمواضيع
     */

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("draz","ez");

    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, "onCreate", Toast.LENGTH_SHORT).show();
        initSubjectSpnr();
        initAllListView();
    }
        private void initSubjectSpnr()
        {
            AppDatabase db =AppDatabase.getDB((getApplicationContext()));
             MySubjectQuery subjectQuery =db.getMySubjectQuery();
             List<MySubject>allSubjects =subjectQuery.getAllSubjects();
            ArrayAdapter<String>subjectAdabter= new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line);
            subjectAdabter.add("All");
            for(MySubject subject : allSubjects){
                subjectAdabter.add((subject.title));
            }
            spnrSubject.setAdapter((subjectAdabter));
            spnrSubject.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    //استخراج الموضوع حسب رقمه الترتيبي i
                    String item=subjectAdabter.getItem(i);
                    if (item.equals("All"))//  الكلمة ALL تعني عرض جميع المهمات
                    {
                        initAllListView();
                    }
                    else
                    {
                        MySubject subject=subjectQuery.checkSubject(item);
                        //
                        initListBySubjId(subject.getKeyid());
                    }
                }
                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {

                }
            });
    }



    private void initAllListView()
    {
        AppDatabase db =AppDatabase.getDB((getApplicationContext()));
        MyTasksQuery tasksQuery=db.getMyTaskQuery();
        List<MyTasks>allTasks =tasksQuery.getAllTasks();
        ArrayAdapter<MyTasks>tsksAdapter = new ArrayAdapter<MyTasks>(this, android.R.layout.simple_dropdown_item_1line);
        tsksAdapter.addAll(allTasks);
        lstvTasks.setAdapter((tsksAdapter));
        
    }
    @Override
    protected void onPause() {
        super.onPause();
        Log.d("EZ","onpause");
        Toast.makeText(this,"onpause",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("EZ","onstop");
        Toast.makeText(this,"onstop",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("EZ","ondestroy");
        Toast.makeText(this,"ondestroy",Toast.LENGTH_SHORT).show();
    }
    private void initListBySubjId(long key_id)
    {
        AppDatabase db =AppDatabase.getDB((getApplicationContext()));
        MyTasksQuery tasksQuery=db.getMyTaskQuery();
        List<MyTasks>allTasks=tasksQuery.getTasksBySubjid(key_id);
        ArrayAdapter<MyTasks>tsksAdapter = new ArrayAdapter<MyTasks>(this, android.R.layout.simple_dropdown_item_1line);
        tsksAdapter.addAll(allTasks);
        lstvTasks.setAdapter((tsksAdapter));

    }
}