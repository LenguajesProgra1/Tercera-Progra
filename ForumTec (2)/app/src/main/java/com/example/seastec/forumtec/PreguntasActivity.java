package com.example.seastec.forumtec;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


public class PreguntasActivity extends Activity {

    //public String[] preguntas;
    public ArrayList<String> preguntas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preguntas);


        Button btactualizar = (Button)findViewById(R.id.btactualizar);
        Button btBxCategoria = (Button)findViewById(R.id.btBxCategoria);
        preguntas = new ArrayList<String>();
        preguntas.add("q es python");
        preguntas.add("que es un lenguaje de programacion??");
        preguntas.add("como instalar android studio");

        final Bundle bundle = this.getIntent().getExtras();
        final ArrayAdapter<String> adapter;

        adapter = new ArrayAdapter<String>(PreguntasActivity.this,android.R.layout.simple_list_item_1,preguntas);

        final ListView lv = (ListView)findViewById(R.id.expandableListView);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent verPregunta = new Intent(PreguntasActivity.this,ResponderActivity.class);
                Bundle b = new Bundle();
                b.putString("Preguntas", lv.getAdapter().getItem(position).toString());
                verPregunta.putExtras(b);
                startActivity(verPregunta);
            }
        });

        btactualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                preguntas.add(0,bundle.getString("Pregunta"));
                lv.setAdapter(adapter);
            }
        });

        btBxCategoria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(PreguntasActivity.this,CategoriasActivity.class);
                startActivity(a);
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_preguntas, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_sing_out:
                Intent a = new Intent(PreguntasActivity.this,LoginActivity.class);
                startActivity(a);

                return true;
            case R.id.action_preguntar:
                Intent preguntar = new Intent(PreguntasActivity.this,PreguntarActivity.class);
                startActivity(preguntar);

                return true;

            default:
                return super.onOptionsItemSelected(item);
        }

    }
}
