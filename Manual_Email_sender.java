package com.arashad96.andoriddeveloperadvancedkit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Manual_Email_sender extends AppCompatActivity {
    Button github;
    Button info;
    Button send_msg;
    EditText subject;
    EditText body;
    EditText email_to_send_for;
    String subject_string = "";
    String body_string = "";
    String emailTo = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_manual__email_sender);

        subject = findViewById(R.id.subject);
        body = findViewById(R.id.body);
        email_to_send_for = findViewById(R.id.email_to_send_for);

        subject_string = subject.getText().toString();
        body_string = body.getText().toString();
        emailTo = email_to_send_for.getText().toString();

        send_msg = findViewById(R.id.send_msg);
        send_msg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (subject_string.equals("") || body_string.equals("") || emailTo.equals("")) {
                    Toast.makeText(Manual_Email_sender.this, "Please fill in the required fields", Toast.LENGTH_SHORT).show();
                }else {
                    //send email manually
                    Intent i = new Intent(Intent.ACTION_SEND);
                    i.setType("message/rfc822");
                    i.putExtra(Intent.EXTRA_EMAIL, new String[]{emailTo});
                    i.putExtra(Intent.EXTRA_SUBJECT, subject_string);
                    i.putExtra(Intent.EXTRA_TEXT, body_string);
                    try {
                        startActivity(Intent.createChooser(i, "Send mail..."));
                    } catch (android.content.ActivityNotFoundException ex) {
                        Toast.makeText(Manual_Email_sender.this, "There are no email clients installed.", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        github = findViewById(R.id.github);
        github.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/ARashad96/Manual_Email_sender_All_API_Levels-including-pie"));
                startActivity(intent);
            }
        });
        info = findViewById(R.id.info);
        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new android.app.AlertDialog.Builder(Manual_Email_sender.this)
                        .setIcon(R.drawable.profile)
                        .setTitle("App info")
                        .setMessage("This app is performing an manual message using textview, email, button, toast, edittext and linearlayout.")
                        .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                            }
                        })
                        .show();
            }
        });
    }
}
