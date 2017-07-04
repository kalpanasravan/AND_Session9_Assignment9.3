package com.kalpana.user.and_session9_assignment93;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

import static java.security.AccessController.getContext;

public class MainActivity extends AppCompatActivity {

    EditText textmsg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textmsg = (EditText) findViewById(R.id.editText1);
    }

    // write text to file
    public void WriteBtn(View v) {
        // add-write text into file
        try {
            FileOutputStream fileout = openFileOutput("mytextfile.txt", MODE_PRIVATE);
            OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
            outputWriter.write(textmsg.getText().toString());
            outputWriter.close();

            //display file saved message
            Toast.makeText(getBaseContext(), "File saved successfully!",
                    Toast.LENGTH_SHORT).show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // check if file exists
    public void CheckBtn(View v) {
        String path = getFilesDir().getAbsolutePath() + "/mytextfile.txt";
        File file = new File(path);

        if (file.exists()) {
            // Toast File is exists
            Toast.makeText(MainActivity.this, "File exist !!", Toast.LENGTH_SHORT).show();
        } else {
            // Toast File is not exists
            Toast.makeText(MainActivity.this, "File not exist !!", Toast.LENGTH_SHORT).show();
        }
    }
}

