package com.example.seastec.forumtec;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.EditText;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.LinkedList;

public class PreguntarActivity extends Activity {
    AbstractList<String> categoria;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preguntar);

        categoria = new ArrayList<String>();
        Button btPreguntas = (Button)findViewById(R.id.btpreguntas);
        Button btEtiquetas = (Button)findViewById(R.id.btetiqueta);
        final EditText etPrguntas = (EditText)findViewById(R.id.etPregunta);
        final EditText etEqtiqueta = (EditText)findViewById(R.id.etEtiqueta);


        btPreguntas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Pregunta registrada",Toast.LENGTH_SHORT).show();
                categoria.add(0,etPrguntas.getText().toString());
                Intent i = new Intent(PreguntarActivity.this,PreguntasActivity.class);
                Bundle b = new Bundle();
                b.putString("Pregunta",etPrguntas.getText().toString());
                i.putExtras(b);
                etPrguntas.setText("");
                startActivity(i);

            }
        });
        btEtiquetas.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View W) {
                Toast.makeText(getApplicationContext(),"Etiqueta registrada",Toast.LENGTH_SHORT).show();
                categoria.add(etEqtiqueta.getText().toString());
                etEqtiqueta.setText("");


            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_preguntar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_sing_out:
                Intent a = new Intent(PreguntarActivity.this,LoginActivity.class);
                startActivity(a);

                return true;
            case R.id.action_inicio:
                Intent iniciar = new Intent(PreguntarActivity.this,PreguntasActivity.class);
                startActivity(iniciar);

                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
