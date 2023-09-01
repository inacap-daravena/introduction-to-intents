package cl.daravena.intro_intents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    Map<String, String> baseDeDatos = new HashMap<String, String>();
    Button btnLogin;
    EditText txtEmail;
    EditText txtPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        baseDeDatos.put("diego@correo.cl", "123abc");
        baseDeDatos.put("pedro@correo.cl", "abc123");
        baseDeDatos.put("juan@correo.cl", "123ABC");

        btnLogin = findViewById(R.id.btnLogin);
        txtEmail = findViewById(R.id.txtEmail);
        txtPassword = findViewById(R.id.txtPassword);

        btnLogin.setOnClickListener(view -> validarUsuario());
    }

    @Override
    protected void onStart() {
        super.onStart();


    }


    private void validarUsuario() {
        String email = txtEmail.getText().toString();
        String password = txtPassword.getText().toString();

        if (baseDeDatos.get(email) != null && baseDeDatos.get(email).equals(password)) {
            Intent intent = new Intent(this, GreetingsActivity.class);
            intent.putExtra("Username", email);

            startActivityForResult(intent, 1);
        } else {
            Toast.makeText(this, "Correo malo", Toast.LENGTH_LONG).show();
        }

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1) {
            if  (resultCode == RESULT_OK) {
                String mensaje = data.getStringExtra("Despedida");
                Toast.makeText(this, mensaje, Toast.LENGTH_LONG).show();
            }
        }
    }

}