package drz.example.draz27.data.mytasksTable;


import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity

    public class MyTasks {

    @PrimaryKey(autoGenerate = true)
    public long keyid;//رقم المهمة
    public int importance;//درجة الاهمية 1-5
    public String Text;//نص المهمة
    public long time;//زمن بناء المهمة
    public long subjId;//رقم موضوع المهمة
    public long userId;//رقم المستعمل الذي اضاف المهمة

    public long getKeyid() {
        return keyid;
    }

    public void setKeyid(long keyid) {
        this.keyid = keyid;
    }

    public int getImportance() {
        return importance;
    }

    public void setImportance(int importance) {
        this.importance = importance;
    }

    public String getText() {
        return Text;
    }

    public void setText(String text) {
        Text = text;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public long getSubjId() {
        return subjId;
    }

    public void setSubjId(long subjId) {
        this.subjId = subjId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "MyTasks{" +
                "keyid=" + keyid +
                ", importance=" + importance +
                ", Text='" + Text + '\'' +
                ", time=" + time +
                ", subjId=" + subjId +
                ", userId=" + userId +
                '}';
    }
}
