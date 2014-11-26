package com.example.seastec.forumtec;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class RegistroActivity extends Activity {


    EditText etcorreo;
    EditText etcontraseña;
    EditText etrep_contraseña;
    EditText etuser;
    Button btregistrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        etcorreo = (EditText)findViewById(R.id.etCorreo);
        etcontraseña = (EditText)findViewById(R.id.etcontraseña);
        etrep_contraseña = (EditText)findViewById(R.id.etrep_contraseña);
        etuser = (EditText)findViewById(R.id.etuser);
        btregistrar = (Button)findViewById(R.id.btregistrar);

        Bundle bundle = this.getIntent().getExtras();
        etcorreo.setText(bundle.getString("correo"));
        etcontraseña.setText(bundle.getString("contraseña"));

        btregistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "", Toast.LENGTH_SHORT).show();
                attemptLogin();

            }
        });
    }

    public void attemptLogin() {

        // Reset errors.

        etcorreo.setError(null);
        etcontraseña.setError(null);
        etrep_contraseña.setError(null);
        etuser.setError(null);


        // Store values at the time of the login attempt.
        String email = etcorreo.getText().toString();
        String password = etcontraseña.getText().toString();
        String rep_password = etrep_contraseña.getText().toString();
        String username = etuser.getText().toString();

        boolean cancel = false;
        View focusView = null;


        // Check for a valid password, if the user entered one.
        if (!TextUtils.isEmpty(password) && !isPasswordValid(password)) {
            etcontraseña.setError(getString(R.string.error_invalid_password));
            focusView = etcontraseña;
            cancel = true;
        }

        // Check for a valid email address.
        if (TextUtils.isEmpty(email)) {
            etcorreo.setError(getString(R.string.error_field_required));
            focusView = etcorreo;
            cancel = true;
        }
        else if (!isEmailValid(email)) {
            etcorreo.setError(getString(R.string.error_invalid_email));
            focusView = etcorreo;
            cancel = true;
        }
        if (!TextUtils.isEmpty(rep_password) && !isRepPasswordValid(rep_password)) {
            etrep_contraseña.setError("contraseña invalida");
            focusView = etrep_contraseña;
            cancel = true;
        }
        if (TextUtils.isEmpty(username)){
            etuser.setError("this field is required");
            focusView = etuser;
            cancel = true;
        }
        else if (!isusernameValid(username)) {
            etuser.setError("nombre de usuario ya existe");
            focusView = etuser;
            cancel = true;
        }

        if (cancel) {
            // There was an error; don't attempt login and focus the first
            // form field with an error.
            focusView.requestFocus();
        } else {
            // perform the user login attempt.
            Intent i = new Intent(RegistroActivity.this,PreguntasActivity.class);
            startActivity(i);
        }
    }
    private boolean isEmailValid(String email) {
        //TODO: Replace this with your own logic
        return email.contains("@");
    }

    private boolean isPasswordValid(String password) {
        //TODO: Replace this with your own logic
        return password.length() > 4;
    }

    private boolean isRepPasswordValid(String rep_password) {
        //TODO: Replace this with your own logic
        return rep_password.equalsIgnoreCase(etcontraseña.getText().toString());
    }

    private boolean isusernameValid(String username) {
        //TODO: Replace this with your own logic
        return true;
    }

}
