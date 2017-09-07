package kr.co.tjeit.instacopyproject02;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class SignupAcitivity extends BaseAcitivity {

    private android.widget.EditText idEdt;
    private android.widget.Button checkDuplBtn;
    private android.widget.EditText nameEdt;
    private android.widget.EditText pwEdt;
    private android.widget.Button signUpBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        bindViews();
        setEvents();
        setValues();
    }

    @Override
    public void setEvents() {

    }

    @Override
    public void setValues() {

    }

    @Override
    public void bindViews() {
        this.signUpBtn = (Button) findViewById(R.id.signUpBtn);
        this.pwEdt = (EditText) findViewById(R.id.pwEdt);
        this.nameEdt = (EditText) findViewById(R.id.nameEdt);
        this.checkDuplBtn = (Button) findViewById(R.id.checkDuplBtn);
        this.idEdt = (EditText) findViewById(R.id.idEdt);
    }
}
