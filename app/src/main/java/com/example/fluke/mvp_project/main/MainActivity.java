package com.example.fluke.mvp_project.main;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.example.fluke.mvp_project.R;
import com.example.fluke.mvp_project.base.BaseActivity;

/**
 * Created by Fluke on 11/1/2561.
 */

public class MainActivity extends BaseActivity implements InterMainActivity.View {
    private Button btn_minus, btn_plus, btn_submit;
    private CheckBox cream, choco;
    private EditText edt_name, edt_quan;
    private InterMainActivity.Presenter presenter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        presenter = new Presenter(this, MainActivity.this);
        init();
        ActionOnInflate();
    }


    private void init() {
        btn_minus = findViewById(R.id.btn_minus);
        btn_plus = findViewById(R.id.btn_plus);
        cream = findViewById(R.id.cb_cream);
        choco = findViewById(R.id.cb_chocolate);
        edt_name = findViewById(R.id.edt_name);
        edt_quan = findViewById(R.id.edt_quan);
        btn_submit = findViewById(R.id.btn_submit);
    }

    private void ActionOnInflate() {

        btn_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Integer.parseInt(edt_quan.getText().toString()) <= 0) {

                } else {
                    setQuan(Integer.parseInt(edt_quan.getText().toString()) - 1);
                }
            }
        });

        btn_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setQuan(Integer.parseInt(edt_quan.getText().toString()) + 1);
            }
        });

        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onButtonClick();
            }
        });

        edt_name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edt_name.setText("");
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public void setTName(String s) {
        edt_name.setText(s);
    }

    @Override
    public void setQuan(int i) {
        edt_quan.setText(i + "");
    }

    @Override
    public String getName() {
        return edt_name.getText().toString();
    }

    @Override
    public int getQunn() {
        return Integer.parseInt(edt_quan.getText().toString());
    }

    @Override
    public String getChoco() {
        if (choco.isChecked()){
            return choco.getText().toString();
        } else return "";
    }

    @Override
    public String getCream() {
        if (cream.isChecked()) {
            return cream.getText().toString();
        } else return "";
    }

    @Override
    public Context getContextx() {
        return this;
    }
}
