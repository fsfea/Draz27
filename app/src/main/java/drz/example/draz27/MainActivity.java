package drz.example.draz27;

import static android.os.Build.VERSION_CODES.S;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.List;

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
            Log.d( "Ez ",e.title);
            Toast.makeText(this, e.title, Toast.LENGTH_SHORT).show();
        }


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