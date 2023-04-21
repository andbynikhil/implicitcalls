package com.example.implicitcalls;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btndial,btnmessage,btnemail,btnshare;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btndial=findViewById(R.id.btndial);
        btnmessage=findViewById(R.id.btnmessage);
        btnemail=findViewById(R.id.btnemail);
        btnshare=findViewById(R.id.btnshare);
        btndial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent dial=new Intent(Intent.ACTION_DIAL);
                dial.setData(Uri.parse("tel:+918545906155"));
                startActivity(dial);
            }
        });
        btnmessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent message=new Intent(Intent.ACTION_SENDTO);
                message.setData(Uri.parse("smsto:"+Uri.encode("8545906155")));
                message.putExtra("sms_body","do you love me");
                startActivity(message);
            }
        });
        btnemail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent email=new Intent(Intent.ACTION_SEND);
                //open email
                email.setType("message/rfc822");
                email.putExtra(Intent.EXTRA_EMAIL,new String[]{"balrambhagat2011@gmail.com"});
                email.putExtra(Intent.EXTRA_SUBJECT,"this make for sabjiwala email");
                email.putExtra(Intent.EXTRA_TEXT,"please contunies buy our sabji;"
                        );
                startActivity(Intent.createChooser(email,"email via"));



            }
        });
        btnshare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent share=new Intent(Intent.ACTION_SEND);
                share.setType("text/plain");
                share.putExtra(Intent.EXTRA_TEXT,"can you love me");
                startActivity(share);
            }
        });
    }
}