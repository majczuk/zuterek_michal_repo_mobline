package com.example.zapis;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.content.Context;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button_save = findViewById(R.id.button_save);
        Button button_load = findViewById(R.id.button_load);
        EditText editTextName = findViewById(R.id.editTextName);
        Context context = this;
        button_save.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v){
               String filename = "test";
               File file = new File(context.getFilesDir(), filename);
               String text = editTextName.getText().toString();
               try {
                   FileWriter fw = new FileWriter(file);
                   fw.write(text);
                   fw.close();
               } catch (IOException e){
                   e.printStackTrace();
               }
           }
        });
    }
}