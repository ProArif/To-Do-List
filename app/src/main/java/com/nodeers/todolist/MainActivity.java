package com.nodeers.todolist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.nodeers.todolist.AddToDo.AddTaskFragment;

public class MainActivity extends AppCompatActivity {

     private FloatingActionButton fabAddTask;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fabAddTask = findViewById(R.id.addTask);

        fabAddTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                AddTaskFragment fragment = new AddTaskFragment();
                ft.setCustomAnimations(R.anim.slide_in_left, R.anim.slide_out_right);
                //ft.replace(R.id.main, fragment, "fragment");
                ft.replace(R.id.main,fragment,"fr");
                ft.addToBackStack("fr");
                fabAddTask.hide();
                // Start the animated transition.
                ft.commit();
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        fabAddTask.show();
    }
}
