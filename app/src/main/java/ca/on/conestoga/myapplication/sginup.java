package ca.on.conestoga.myapplication;

import android.content.Intent;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class sginup extends AppCompatActivity {
    RadioGroup radgp;

    private int id;


    private EditText ed_email,ed_password,ed_user;
    private  String  email, password,user;
    Button Createbtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sginup);


        radgp = (RadioGroup) findViewById (R.id.Radiogp1);
        id = radgp.getCheckedRadioButtonId();

        radgp.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int i) {
                validate();



            }
        });


        ed_email = (EditText) findViewById(R.id.EmailAdress);
        ed_user = (EditText) findViewById(R.id.UserName);
        ed_password = (EditText) findViewById(R.id.word);
        Createbtn = (Button) findViewById(R.id.Createbtn);
        Createbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Reg();
            }

        });
    }
    public  void Reg(){
        intialise();
        if (!validate()){
            Toast.makeText(this, "Sgin in Failed", Toast.LENGTH_SHORT).show();
        }
        else {
            onSigninSuccess();
        }

    }
    public void onSigninSuccess(){
        Intent intent = new Intent(sginup.this ,MainActivity.class);
        startActivity(intent);
    }
    public boolean validate(){
        boolean valid = true;
        if( email.isEmpty()||!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            ed_email.setError("Plese Enter a Vaild Email Address");
            valid = false;
        }
        if (password.isEmpty()){
            ed_password.setError("Please enter in a password ");
            valid = false;
        }

        if (user.isEmpty()){
            ed_user.setError("Please enter in a Username ");
            valid = false;
        }
        if( id == -1){
            valid = false;
        }

        return valid;

    }
    public void intialise(){
        email = ed_email.getText().toString().trim();
        password = ed_password.getText().toString().trim();
        user = ed_user.getText().toString().trim();




    }


}
