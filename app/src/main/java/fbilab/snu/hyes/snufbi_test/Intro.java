package fbilab.snu.hyes.snufbi_test;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Intro extends Activity {

    public static final String SAVEPATH = Environment.getExternalStorageDirectory()+"/SNUFBILab_tests/";
    private SimpleDateFormat timestamp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intro_activity);
        final EditText id_et = (EditText)findViewById(R.id.id_et);
        final EditText name_et = (EditText)findViewById(R.id.name_et);
        Button start_btn = (Button)findViewById(R.id.start_btn);

        start_btn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            String id = String.valueOf(id_et.getText());
            String name = String.valueOf(name_et.getText());

            if(id.length() == 0){
                Toast.makeText(getApplicationContext(), "id를 입력하세요", Toast.LENGTH_SHORT).show();
                return;
            }

            Intent intent = new Intent(getApplicationContext(), TestSelection.class);
            intent.putExtra("id", id);
            intent.putExtra("name", name);

            File root_dir = makeDirectory(SAVEPATH);


            timestamp = new SimpleDateFormat("yyyyMMdd");
            File dir = makeDirectory(SAVEPATH+id+"_"+timestamp.format(new Date()).toString() + "/");
            intent.putExtra("savepath", dir.toString());

            startActivity(intent);
        }
    });
}

    private File makeDirectory(String dir_path){
        File dir = new File(dir_path);
        if (!dir.exists())
        {
            dir.mkdirs();
            Log.i("test", "!dir.exists");
        }else{
            Log.i("test", "dir.exists" );
        }

        return dir;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_intro, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
