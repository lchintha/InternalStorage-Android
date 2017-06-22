package com.example.chint.internalstorage;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by chint on 6/20/2017.
 */

public class SecondActivity extends AppCompatActivity {
    Button get, previous;
    EditText user, pass;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        get = (Button)findViewById(R.id.next);
        previous = (Button)findViewById(R.id.save);

        get.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user = (EditText)findViewById(R.id.uname);
                pass = (EditText)findViewById(R.id.psw);
                FileInputStream fis = null;
                try {
                    fis = openFileInput("file.txt");
                    int read = -1;
                    StringBuffer sb = new StringBuffer();
                    while((read = fis.read())!= -1){
                        sb.append((char)read);
                    }
                    String text1 = sb.substring(0, sb.indexOf(" "));
                    String text2 = sb.substring(sb.indexOf(" ")+1);

                    user.setText(text1);
                    pass.setText(text2);

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                finally {
                    try {
                        fis.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), MainActivity.class);
                startActivity(i);
            }
        });

    }
}
