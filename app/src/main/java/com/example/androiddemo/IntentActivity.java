package com.example.androiddemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Contacts;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;

public class IntentActivity extends AppCompatActivity implements View.OnClickListener {
    Button contact = null;
    Button browser = null;
    Button setting = null;
    Button album = null;
    Button camera = null;
    Intent i = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent);
        contact = findViewById(R.id.contact);
        contact.setOnClickListener(this);
        browser = findViewById(R.id.browser);
        browser.setOnClickListener(this);
        setting = findViewById(R.id.setting);
        setting.setOnClickListener(this);
        album = findViewById(R.id.album);
        album.setOnClickListener(this);
        camera = findViewById(R.id.camera);
        camera.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.contact:
                i = new Intent(Intent.ACTION_PICK);
                i.setType(String.valueOf(ContactsContract.Contacts.CONTENT_TYPE));
                startActivityForResult(i,1);
                break;
            case R.id.browser:
                i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse("http://www.baidu.com"));
                startActivity(i);
                break;
            case R.id.setting:
                i = new Intent(Settings.ACTION_SETTINGS);
                startActivity(i);
                break;
            case R.id.album:
                i = new Intent(Intent.ACTION_PICK);
                i.setType("image/*");
                startActivityForResult(i,2);
                break;
            case R.id.camera:
                i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(i,3);
                break;
        }
    }
}