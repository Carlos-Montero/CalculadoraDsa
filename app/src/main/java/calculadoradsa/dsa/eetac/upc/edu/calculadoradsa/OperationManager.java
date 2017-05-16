package calculadoradsa.dsa.eetac.upc.edu.calculadoradsa;

import android.content.Intent;
import android.os.Debug;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Carlos on 15/05/2017.
 */


public class OperationManager extends AppCompatActivity {

    private String tag = "Events";
    private String operation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_operation_manager);
        Bundle extra = getIntent().getExtras();
        if (extra != null) {
            operation = extra.getString("op");
        }
        TextView op = (TextView) findViewById(R.id.op);
        op.setText(operation);
    }

    public void onStart() {
        super.onStart();
        Log.d(tag, "event onStart()");

    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(tag, "event onResume()");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(tag, "event onPause()");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(tag, "event onStop()");

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(tag, "event onRestart()");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(tag, "event onDestroy()");
        Debug.stopMethodTracing();
    }


    public void edit(View v) {  //funcío per editat l'operació
        Intent intent = getIntent();
        intent.putExtra("op", operation);
        setResult(200, intent);
        finish();
    }


    public void delete(View v) {  //funció per esborrar l'operacío de l'historial
        Intent intent = getIntent();
        intent.putExtra("op", operation);
        setResult(201, intent);
        finish();
    }
}