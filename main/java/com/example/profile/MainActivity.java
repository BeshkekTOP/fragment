package com.example.profile;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ServiceConfigurationError;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        bottomNavigationView = findViewById(R.id.bottom_nav);
        setFragment(new FirstFragment());
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                if (id == R.id.first_item){
                    setFragment(new FirstFragment());
                    return true;
                }
                else if(id == R.id.second_item){
                    setFragment(new SecondFragment());
                    return true;

                }
                else if(id == R.id.third_item){
                    setFragment(new ThirdFragment());
                    return true;
                }
                else {
                    return false;
                }

            }

        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.option_menu,menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        if(id ==R.id.action_settings){
            Toast.makeText(this, "Настройки выполнены", Toast.LENGTH_SHORT).show();
            return true;
        }else if(id == R.id.firstFrag){
            setFragment(new Firstgragment());
            return true;
        }else if(id == R.id.twoFrag){
            setFragment(new BlankFragment());
            return true;
        }else{
            return super.onOptionsItemSelected(item);
        }


    }

    public void setFragment(Fragment fragment){
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_layout, fragment, null)
                .commit();
    }


}
