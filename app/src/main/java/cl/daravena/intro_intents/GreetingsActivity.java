package cl.daravena.intro_intents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GreetingsActivity extends AppCompatActivity {

    Button btnLogout;
    TextView txtUsername;
    String mensaje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_greetings);

        btnLogout = findViewById(R.id.btnLogout);
        txtUsername = findViewById(R.id.txtUsername);

        Intent intent = getIntent();
        mensaje = intent.getStringExtra("Username");

        txtUsername.setText(mensaje);

        btnLogout.setOnClickListener(view -> cerrarSesion(view));
    }

    public void cerrarSesion(View view) {
        Intent intent = new Intent();
        intent.putExtra("Despedida", "Adios, " + mensaje);
        setResult(RESULT_OK, intent);
        finish();
    }
}