package com.example.chint.internalstorage;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    Button save1, next1;
    EditText user, pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        save1 = (Button)findViewById(R.id.save);
        next1 = (Button)findViewById(R.id.next);
        user = (EditText)findViewById(R.id.uname);
        pass = (EditText)findViewById(R.id.psw);

        save1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String a = user.getText().toString();
                String b = pass.getText().toString();
                a = a+" ";
                FileOutputStream fos=null;
                try {
                    fos = openFileOutput("file.txt", Context.MODE_PRIVATE);
                    fos.write(a.getBytes());
                    fos.write(b.getBytes());
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                finally {
                    try {
                        fos.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                Toast.makeText(MainActivity.this, "Successfully Saved", Toast.LENGTH_LONG).show();
            }

        });
        next1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), SecondActivity.class);
                startActivity(i);
            }
        });
    }
}
