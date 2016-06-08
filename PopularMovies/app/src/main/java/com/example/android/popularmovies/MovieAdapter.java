package com.example.android.popularmovies;

import android.content.Context;
import android.content.Intent;
import android.support.v4.widget.ContentLoadingProgressBar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by vikram.rathi on 6/6/16.
 */
public class MovieAdapter extends BaseAdapter {

    private Context mContext;
    private List<MovieData> data;

    private static LayoutInflater layoutInflater;


    public MovieAdapter(Context context, List<MovieData> data) {
        mContext = context;
        layoutInflater = (LayoutInflater) context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return data.get(position).getId();
    }

    public class Holder {
        TextView tv;
        ImageView img;
        ProgressBar progressBar;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final Holder holder = new Holder();
        final MovieData movieData = data.get(position);

//        DisplayMetrics displaymetrics = new DisplayMetrics();
//        ((WindowManager) mContext.getSystemService(Context.WINDOW_SERVICE))
//                .getDefaultDisplay().getMetrics(displaymetrics);
//
//        int screenHeight = displaymetrics.heightPixels;
//        int screenWidth = displaymetrics.widthPixels;
//
//        int imageHeight =  (int) (screenHeight * 0.5);
//        int imageWidth =  (int) (screenWidth * 0.5);

        if (convertView == null) {
            View movieView = layoutInflater.inflate(R.layout.single_grid_item, null);
            holder.tv = (TextView) movieView.findViewById(R.id.movie_text);
            holder.img = (ImageView) movieView.findViewById(R.id.movie_image);
            holder.progressBar = (ProgressBar) movieView.findViewById(R.id.movie_loader);

            holder.tv.setText(movieData.getName());


            holder.progressBar.setVisibility(View.VISIBLE);
            Picasso.with(mContext)
                    .load(movieData.getPosterUrl())
                    .into(holder.img, new Callback() {
                        @Override
                        public void onSuccess() {
//                            Toast.makeText(mContext,"Success: " + movieData.getName(), Toast.LENGTH_SHORT).show();
                            holder.progressBar.setVisibility(View.INVISIBLE);
                        }

                        @Override
                        public void onError() {
                            Toast.makeText(mContext,"Error: " + movieData.getName(), Toast.LENGTH_SHORT).show();
//                            holder.progressBar.setVisibility(View.INVISIBLE);
                        }
                    });
            movieView.setOnClickListener(new MovieClickListener(movieData));
            return movieView;
        } else {
            holder.tv=(TextView) convertView.findViewById(R.id.movie_text);
            holder.img=(ImageView) convertView.findViewById(R.id.movie_image);
            holder.progressBar = (ProgressBar) convertView.findViewById(R.id.movie_loader);

            holder.tv.setText(movieData.getName());
            holder.progressBar.setVisibility(View.VISIBLE);
            Picasso.with(mContext)
                    .load(movieData.getPosterUrl())
                    .into(holder.img, new Callback() {
                        @Override
                        public void onSuccess() {
//                            Toast.makeText(mContext,"Success: " + movieData.getName(), Toast.LENGTH_SHORT).show();
                            holder.progressBar.setVisibility(View.INVISIBLE);
                        }

                        @Override
                        public void onError() {
                            Toast.makeText(mContext,"Error: " + movieData.getName(), Toast.LENGTH_SHORT).show();
//                            holder.progressBar.setVisibility(View.INVISIBLE);
                        }
                    });
//            LinearLayout.LayoutParams params =
//                    new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.FILL_PARENT);
//            convertView.setLayoutParams(new GridView.LayoutParams(params));
            convertView.setOnClickListener(new MovieClickListener(movieData));
            return convertView;
        }
    }

    public class MovieClickListener implements View.OnClickListener {
        private final MovieData data;

        public MovieClickListener(MovieData movieData) {
            data = movieData;
        }

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(mContext, MovieDetailActivity.class);
            intent.putExtra("data", data);
            mContext.startActivity(intent);
        }
    }

}
