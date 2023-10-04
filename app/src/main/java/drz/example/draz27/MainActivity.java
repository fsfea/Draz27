package drz.example.draz27;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import drz.example.draz27.data.AppDatabase;
import drz.example.draz27.data.SubjectTable.MySubject;
import drz.example.draz27.data.SubjectTable.MySubjectQuery;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("draz","onCreate");
        Toast.makeText(this, "onCreate", Toast.LENGTH_SHORT).show();

        //بناء قاعدة البيانات وارجاع مؤشر عليها
      AppDatabase db= AppDatabase.getDB(getApplicationContext());
        // مؤشر لجدول
        MySubjectQuery mySubjectQuery = db.getMySubjectQuery();
        // بناء كائن من نوع الجدول وتحديد قيم الصفات
        MySubject s1=new MySubject();
        s1.setTitle("Math");
        MySubject s2=new MySubject();
        s2.title="Computers";
        //اضافة كائن للجدول
       MySubjectQuery.insert(s1);
        MySubjectQuery.insert(s2);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("draz","ez");

    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, "onCreate", Toast.LENGTH_SHORT).show();
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
}