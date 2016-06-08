package com.example.android.popularmovies;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        GridView gridView = (GridView) findViewById(R.id.movie_grid_view);


//        View[] views = {findViewById(R.id.movie_image)};
//        ArrayAdapter<View> arrayAdapter =
//                new ArrayAdapter<View>(this, R.layout.single_grid_item, views);
//
        List<MovieData> data = new ArrayList<MovieData>() {
            {
                add(new MovieData("Spotlight",
                        "http://image.tmdb.org/t/p/w342/NvHyDLUwOlFGaXYidabJzhmiqi.jpg"));
                add(new MovieData("The Martian",
                        "http://image.tmdb.org/t/p/w342/NvHyDLUwOlFGaXYidabJzhmiqi.jpg"));
                add(new MovieData("The Revenant",
                        "http://image.tmdb.org/t/p/w342/NvHyDLUwOlFGaXYidabJzhmiqi.jpg"));
                add(new MovieData("Room",
                        "http://image.tmdb.org/t/p/w342/NvHyDLUwOlFGaXYidabJzhmiqi.jpg"));
                add(new MovieData("Spotlight",
                        "http://image.tmdb.org/t/p/w342/NvHyDLUwOlFGaXYidabJzhmiqi.jpg"));
                add(new MovieData("Spotlight",
                        "http://image.tmdb.org/t/p/w342/NvHyDLUwOlFGaXYidabJzhmiqi.jpg"));
            }
        };
        gridView.setAdapter(new MovieAdapter(this, data));
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
