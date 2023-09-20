package drz.example.draz27.data.mytasksTable;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao//واجهة استعلامات على جدول المعطيات
public interface MyTasksQuery
{
    @Query("SELECT * FROM MYTASKS")
    List<MyTasks>getAllTasks();
    @Insert
    void insertTask(MyTasks...t);//استطيع ادخال كائن او مجموعة
}
