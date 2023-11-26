package drz.example.draz27;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

public class Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    @Override
    public boolean onCreateOptionsMenu(android.view.Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.itmSettings) {
            Toast.makeText(this, "Settings", Toast.LENGTH_SHORT).show();
        }

        if (item.getItemId() == R.id.itmlogOut) {
            Toast.makeText(this, "LogOut", Toast.LENGTH_SHORT).show();
        }
        return true;
    }
}