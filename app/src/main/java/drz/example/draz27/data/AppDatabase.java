package drz.example.draz27.data;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;


import drz.example.draz27.data.SubjectTable.MySubject;
import drz.example.draz27.data.SubjectTable.MySubjectQuery;
import drz.example.draz27.data.mytasksTable.MyTasks;
import drz.example.draz27.data.mytasksTable.MyTasksQuery;
import drz.example.draz27.data.usersTable.MyUser;
import drz.example.draz27.data.usersTable.MyuserQuery;
/*
تعريف الجداول ورقم الاصدار
version
عند تغيير اي شي يخص جدول او جداول علينا تغيير رقم الاصدار
ليتم بناء قاعدة البيانات من جديد
*/
@Database(entities = {MyUser.class, MySubject.class, MyTasks.class},version =2)
/**
 * الفئة المسؤولة عن بناء قاعدة البايانات بكل جداولها
 * وتوفر لنا كائن للتعامل مع قاعدة البيانات
 */

public abstract class  AppDatabase extends RoomDatabase
{

        /**
         * كائن للتعامل مع قاعدة البيانات
         */
        private static AppDatabase db;

        /**
         * يعيد كائن لعمليات جدول المستعملين
         * @return
         */
        public abstract MyuserQuery getMyuserQuery();

        /**
         * يعيد كائن لعمليات جدول الموضيع
         * @return
         */
        public abstract MySubjectQuery getMySubjectQuery();

        /**
         * يعيد كائن لعمليات جدول المهمات
         * @return
         */
        public abstract MyTasksQuery getMyTaskQuery();

        /**
         * بناء قاعدة البيانات واعادة كائن يؤشر عليها
         * @param context
         * @return
         */
        public static AppDatabase getDB(Context context)
        {
                if(db==null)
                {
                        db = Room.databaseBuilder(context,
                                        AppDatabase.class,
                                        "samihDataBase")//اسم قاعدة اليانات
                                .fallbackToDestructiveMigration()
                                .allowMainThreadQueries()
                                .build();
                }
                return db;
        }

}