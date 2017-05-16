package calculadoradsa.dsa.eetac.upc.edu.calculadoradsa;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.widget.ListView;
import android.widget.ArrayAdapter;
import android.util.Log;
import android.os.Debug;
import android.view.View;
import android.app.Activity;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Carlos on 15/05/2017.
 */


public class History extends AppCompatActivity {

    private String tag = "Events";
    private List<Operation> list;
    private List<String> l;
    private ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        lv = (ListView) findViewById(R.id.listV);
        Intent i = getIntent();
        list = (List<Operation>) i.getSerializableExtra("list");
        l = new ArrayList<>();
        for (int j = 0; j < list.size(); j++) {
            String item = list.get(j).toString();
            l.add(item);
        }
        ArrayAdapter<String> arrayAdapter =
                new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, l);
        // Set The Adapter
        lv.setAdapter(arrayAdapter);

        // register onClickListener to handle click events on each item
        lv.setOnItemClickListener(new OnItemClickListener() {
            // argument position gives the index of item which is clicked
            public void onItemClick(AdapterView<?> arg0, View v, int position, long arg3) {
                opManager(position);
            }
        });
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

    public void delete(View v) {
        Intent intent = new Intent(getApplicationContext(), DeleteHistory.class);
        startActivityForResult(intent, 101);

    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if ((requestCode == 101) && (resultCode == Activity.RESULT_OK)) {//borrar historial
            this.list.clear();
            this.l.clear();
            setResult(222);
            finish();

        } else if (requestCode == 102) {//mensaje de OperationManager activity
            Bundle extra = data.getExtras();

            if (extra != null) {
                Intent intent = getIntent();
                String temp = extra.getString("op");
                ;
                int i = l.indexOf(temp);
                intent.putExtra("op", i);

                if (resultCode == 200) {//editar operación
                    setResult(200, intent);
                    finish();

                } else if (resultCode == 201) {//eliminar opearion del historial
                    list.remove(i);
                    l.remove(i);
                    setResult(201, intent);
                    finish();
                }
            }
        }
    }

    private void opManager(int position) {
        Intent intent = new Intent(getApplicationContext(), OperationManager.class);
        intent.putExtra("op", l.get(position));
        startActivityForResult(intent, 102);
    }
}
