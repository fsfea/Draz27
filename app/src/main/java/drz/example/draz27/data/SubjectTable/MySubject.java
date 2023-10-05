package drz.example.draz27.data.SubjectTable;


import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class MySubject
{

    @PrimaryKey
    public long keyid;
    public String title;

    public long getKeyid() {
        return keyid;
    }

    public void setKeyid(long keyid) {
        this.keyid = keyid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "MySubject{" +
                "keyid=" + keyid +
                ", title='" + title + '\'' +
                '}';

    }
}
