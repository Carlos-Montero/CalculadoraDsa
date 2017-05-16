package calculadoradsa.dsa.eetac.upc.edu.calculadoradsa;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.os.Debug;
import android.view.View;
import android.content.Intent;


/**
 * Created by Carlos on 15/05/2017.
 */


public class DeleteHistory extends AppCompatActivity {

    private String tag="Events";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_history);
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

    public void cancel(View v) {
        Intent intent = getIntent();
        setResult(RESULT_CANCELED, intent);
        finish();
    }

    public void delete(View v) {
        Intent intent = getIntent();
        setResult(RESULT_OK, intent);
        finish();
    }
}