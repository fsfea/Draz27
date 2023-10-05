package drz.example.draz27.data.SubjectTable;


import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;
@Dao
public interface MySubjectQuery
{
    @Query("SELECT * FROM MyUser")
    List<MySubject> getAll();
    @Insert
    void insertAll(MySubject... users);

    @Delete
    void delete(MySubject user);

    @Query("Delete From MyUser WHERE keyid=:id ")
    void delete(int id);

    @Insert
    static void insert(MySubject myUser) {

    }

    @Update
    void update(MySubject... values);
}





