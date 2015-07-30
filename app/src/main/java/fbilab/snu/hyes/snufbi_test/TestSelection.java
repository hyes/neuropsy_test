package fbilab.snu.hyes.snufbi_test;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class TestSelection extends ActionBarActivity {
    private String id, name, savepath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_selection);

        Intent intent = getIntent();
        id = intent.getStringExtra("id");
        name = intent.getStringExtra("name");
        savepath = intent.getStringExtra("savepath");


        Button flanker_btn = (Button)findViewById(R.id.flanker_btn);
        flanker_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.putExtra("id", id);
                intent.putExtra("name", name);
                intent.putExtra("savepath", savepath);
                startActivity(intent);
            }
        });

//        Button d2_btn = (Button)findViewById(R.id.d2_btn);
//        d2_btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(getApplicationContext(), PreD2Test.class);
//                intent.putExtra("id", id);
//                intent.putExtra("name", name);
//                intent.putExtra("savepath", savepath);
//                startActivity(intent);
//            }
//        });

        Button tmt_btn = (Button)findViewById(R.id.tmt_a_btn);
        tmt_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //class 추가 할 것!
                Intent intent = new Intent(getApplicationContext(), TMTPracticeA.class);
                intent.putExtra("id", id);
                intent.putExtra("name", name);
                intent.putExtra("savepath", savepath);
                startActivity(intent);
            }
        });

        Button raven_odd_btn = (Button)findViewById(R.id.raven_a_btn);
        raven_odd_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), RavenTestOdd.class);
                intent.putExtra("id", id);
                intent.putExtra("name", name);
                intent.putExtra("savepath", savepath);
                startActivity(intent);
            }
        });

        Button raven_even_btn = (Button)findViewById(R.id.raven_b_btn);
        raven_even_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), RavenTestEven.class);
                intent.putExtra("id", id);
                intent.putExtra("name", name);
                intent.putExtra("savepath", savepath);
                startActivity(intent);
            }
        });
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
