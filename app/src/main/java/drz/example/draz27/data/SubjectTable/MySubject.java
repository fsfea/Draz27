package drz.example.draz27.data.SubjectTable;


import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class MySubject
{

    @PrimaryKey
    public long keyid;
    public String title;

    @Override
    public String toString() {
        return "MySubject{" +
                "keyid=" + keyid +
                ", title='" + title + '\'' +
                '}';
    }
}
