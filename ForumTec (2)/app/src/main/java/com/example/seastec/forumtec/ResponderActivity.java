package com.example.seastec.forumtec;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;


public class ResponderActivity extends Activity {

    public ArrayList<String> respuesta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_responder);

        TextView pregunta = (TextView)findViewById(R.id.tvpregunta2);
        Button btResponder = (Button)findViewById(R.id.btResponder);
        final EditText respuestas = (EditText)findViewById(R.id.etResponder);
        respuesta = new ArrayList<String>();

        Bundle bundle = this.getIntent().getExtras();
        pregunta.setText(bundle.getString("Preguntas"));


        final ArrayAdapter<String> adapter;

        adapter = new ArrayAdapter<String>(ResponderActivity.this,android.R.layout.simple_list_item_1,respuesta);
        final ListView lv2 = (ListView)findViewById(R.id.lvRespuestas);
        lv2.setAdapter(adapter);

        btResponder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                respuesta.add(respuestas.getText().toString());
                respuestas.setText("");
                lv2.setAdapter(adapter);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_responder, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_sing_out:
                Intent a = new Intent(ResponderActivity.this,LoginActivity.class);
                startActivity(a);

                return true;
            case R.id.action_inicio:
                Intent iniciar = new Intent(ResponderActivity.this,PreguntasActivity.class);
                startActivity(iniciar);

                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
