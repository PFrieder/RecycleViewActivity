package com.example.pinchasfrieder.recycleviewactivity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import static android.graphics.Color.RED;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUpGui();
    }

    private void setUpGui() {
        Log.d("SetUpGUI", "was invoked");
        recyclerView = (RecyclerView)findViewById(R.id.my_recycler_view);
        adapter = new MyAdapter(MainActivity.this, getData());
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        recyclerView.setAdapter(adapter);


    }
    public static List<Info>getData(){
        Log.d("getData","was invoked");
        List<Info>data = new ArrayList<>();
        int[] icon = {R.drawable.burj_dubai_553368, R.drawable.dubai_553378, R.drawable.dubai_553380, R.drawable.dubai_august_2011_553385,
                R.drawable.dubai_august_2011_553388, R.drawable.dubai_creek_553384, R.drawable.dubai_marina_553387, R.drawable.emirates_towers_553377, R.drawable.emirates_towers_dubai_553370, R.drawable.kempinski_palm_jumeirah_dubai_553386};
        String[]titles = {"number 1","number 2","number 3","number 4","number 5","number 6","number 7","number 8",
                "number 9","number 10"};
        Info current;
        for (int i = 0; i < icon.length && i < titles.length; i++) {
            Log.d("for loop " + i,"was invoked");
            current = new Info();
            current.iconId = icon[i];
            current.title = titles[i];

            data.add(current);
        }
        return data;


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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