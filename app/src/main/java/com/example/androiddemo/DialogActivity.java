package com.example.androiddemo;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.PopupWindow;

public class DialogActivity extends AppCompatActivity implements View.OnClickListener {
    Button dialog1 = null;
    Button customDialog = null;
    Button popup = null;
    LayoutInflater li = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);
        li = LayoutInflater.from(this);
        dialog1 = findViewById(R.id.dialog1);
        dialog1.setOnClickListener(this);
        customDialog = findViewById(R.id.customDialog);
        customDialog.setOnClickListener(this);
        popup = findViewById(R.id.popup);
        popup.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.dialog1:
                new AlertDialog.Builder(this)
                        .setTitle("dialog1")
                        .setPositiveButton("确定",null)
                        .create()
                        .show();
                break;
            case R.id.customDialog:
                View dialogView = li.inflate(R.layout.custom_dialog,null);
                final AlertDialog dialog = new AlertDialog.Builder(this)
                        .setView(dialogView)
                        .create();
                dialogView.findViewById(R.id.ok).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });
                dialog.show();
                break;
            case R.id.popup:
                View dialogView2 = li.inflate(R.layout.custom_dialog,null);
                final PopupWindow popupWindow = new PopupWindow(dialogView2,400,600);
                popupWindow.setOutsideTouchable(true);
                dialogView2.findViewById(R.id.ok).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        popupWindow.dismiss();
                    }
                });
                popupWindow.showAsDropDown(view);
                break;
            default:
        }
    }
}