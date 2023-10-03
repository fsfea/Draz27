package drz.example.draz27.data;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import drz.example.draz27.data.mytasksTable.MyTasks;
import drz.example.draz27.data.mytasksTable.MyTasksQuery;
import drz.example.draz27.data.usersTable.MyUser;
import drz.example.draz27.data.usersTable.MyuserQuery;

public class appDataBase
{
        @Database(entities = {MyUser.class, MySubject.class, MyTasks.class},version = 5)
        public abstract class AppDatabase extends RoomDatabase
        {
                private static AppDatabase db;
                public abstract MyuserQuery.MyUserQuery getMyUserQuery();
                public abstract MySubjectQuery getMySubjectQuery();
                public abstract MyTasksQuery getMyTaskQuery();

                public static AppDatabase getDB(Context context)
                {
                        if(db==null)
                        {
                                db = Room.databaseBuilder(context,
                                                AppDatabase.class, "database-name")
                                        .fallbackToDestructiveMigration()
                                        .allowMainThreadQueries()
                                        .build();
                        }
                        return db;



                }
