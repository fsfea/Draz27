package drz.example.draz27.data.mytasksTable;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao//واجهة استعلامات على جدول المعطيات
public interface MyTasksQuery
{
    /**
     * اعادة جميع معطيات جدول المهمات
     * @return **قائمة من المهمات
     */
    @Query("SELECT * FROM MYTASKS")
    List<MyTasks>getAllTasks();

    @Query("SELECT * FROM MyTasks WHERE userId=:userid_p  " +
            " ORDER BY time DESC")
    List<MyTasks>getAllTaskQrderBy(Long userid_p);

    /**
     * قائمة من المهمات الغير مكتملة بترتيب او حسب الاهمية
     * @param userid_p رقم الهوية ال
     * @param isCompleted_p المهمات غير مكتملة
     * @return
     */
    @Query("SELECT * FROM MyTasks WHERE userId=:userid_p AND importance=:isCompleted_p " +
        "ORDER BY importance DESC")
    List<MyTasks> getAllTaskQrderBy(Long userid_p , boolean isCompleted_p);

    /**
     * ادخال مهمات
     * @param t مجموعة مهمات
     */
    @Insert
    void insertTask(MyTasks...t);//استطيع ادخال كائن او مجموعة

    /**
     * تعديل المهمات
     * @param tasks مجموعة مهمات للتعديل (التعديل حسب المفتاح الرئيسي)
     */
    @Update
    void updateTask(MyTasks ...tasks);

    /**
     * حذف مهمة او مهمات
     * @param tasks حذف المهمات (حسب المفتاح الرئيسي )
     */
    @Delete
    void delereTasks(MyTasks...tasks);

    @Query("DELETE FROM MyTasks WHERE keyid=:id")
    void delTaskById(long id);

}
