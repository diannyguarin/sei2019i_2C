package com.example.tournaments.ui;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.tournaments.BussinesLogic.RegisterController;
import com.example.tournaments.R;

public class RegisterActivity extends AppCompatActivity {
     EditText name;
     EditText nick;
    EditText pass1;
    EditText pass2;
    Button regButton;
    ImageView cancelButton;

    RegisterController controller = new RegisterController();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        name = (EditText) findViewById(R.id.etName);//Text Name
        nick = (EditText) findViewById(R.id.etUsername);//Text Username
        pass1 = (EditText) findViewById(R.id.etPassword1);//Text Password 1
        pass2 = (EditText) findViewById(R.id.etPassword2);//Text Password 1
        regButton = (Button) findViewById(R.id.bRegister);//Register Button
        cancelButton = (ImageView) findViewById(R.id.bcancelReg);//Cancel Register  Button


        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
            }
        });

        regButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(pass1.getText().toString().equals(pass2.getText().toString())){

                    //Insertar en base de datos
                    controller.Register(name.getText().toString(),nick.getText().toString(), pass1.getText().toString());

                    Toast.makeText(getApplicationContext(), "Registrado Exitosamente", Toast.LENGTH_SHORT).show();

                }else{
                    Toast.makeText(getApplicationContext(), "Contraseña no Coincide", Toast.LENGTH_SHORT).show();
                }
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
            }
        });
    }



    public void regComplete(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, LoginActivity.class);

        startActivity(intent);
    }
}
