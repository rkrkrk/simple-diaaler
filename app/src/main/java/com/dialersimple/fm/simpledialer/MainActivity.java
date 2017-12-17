package com.dialersimple.fm.simpledialer;

import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    private Button dialBtn, HangupBtn, clearBtn, delBtn;
    private Button[] dialBtns;
    private TextView tvDialNumber;
    String dialNumber = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dialBtn = (Button) findViewById(R.id.buttonDial);
        HangupBtn = (Button) findViewById(R.id.buttonHangUp);

        clearBtn = (Button) findViewById(R.id.buttonClear);
        clearBtn.setOnClickListener(clearClickListener);
        delBtn = (Button) findViewById(R.id.buttonDel);
        delBtn.setOnClickListener(deleteClickListener);

        tvDialNumber = (TextView) findViewById(R.id.tvDialNum);


        dialBtns = new Button[10];
        for (int i = 0; i < 10; i++) {
            dialBtns[i] = (Button) findViewById(getResources().getIdentifier(
                    "button" + String.format("%02d", i), "id",
                    "com.dialersimple.fm.simpledialer"));
            dialBtns[i].setOnClickListener(dialBtnClickListener);
        }
        dialBtn = (Button) findViewById(R.id.buttonDial);
    }


    View.OnClickListener dialBtnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View w) {
            Button b = (Button) w;
            dialNumber = dialNumber + b.getText();
            tvDialNumber.setText(dialNumber);
        }
    };

    View.OnClickListener deleteClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View w) {
            if (dialNumber.length() > 0) {
                dialNumber = deleteEnd(dialNumber);
                tvDialNumber.setText(dialNumber);
            }

        }
    };

    View.OnClickListener clearClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View w) {
            dialNumber = "";
            tvDialNumber.setText(dialNumber);
        }
    };

    public String deleteEnd(String str) {
        if (str != null && str.length() > 0 ) {
            str = str.substring(0, str.length() - 1);
        }
        return str;
    }
}
