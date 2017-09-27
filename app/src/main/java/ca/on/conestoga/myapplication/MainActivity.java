package ca.on.conestoga.myapplication;

import android.content.Intent;
import android.media.MediaCodec;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText ed_email,ed_password;
    private  String  email, password;
    Button Sgininbtn;
    Button Sginupbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ed_email = (EditText) findViewById(R.id.Email);
        ed_password = (EditText) findViewById(R.id.Password);
        Sgininbtn = (Button) findViewById(R.id.Sgininbtn);
        Sginupbtn = (Button) findViewById(R.id.Sginupbtn);
        Sgininbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Reg();
            }
        });
        Sginupbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this ,sginup.class);
                startActivity(intent);
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
        Intent intent = new Intent(MainActivity.this ,homepage.class);
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
        return valid;

    }
    public void intialise(){
        email = ed_email.getText().toString().trim();
        password = ed_password.getText().toString().trim();

    }


}
