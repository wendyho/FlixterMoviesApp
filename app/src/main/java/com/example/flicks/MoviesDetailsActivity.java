package com.example.flicks;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.flicks.models.Movie;
import com.loopj.android.http.AsyncHttpClient;

import org.parceler.Parcels;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MoviesDetailsActivity extends AppCompatActivity {

    // the movie to display
    Movie movie;

    // instance fields
    AsyncHttpClient client;

    // the view objects
    @BindView (R.id.tvTitle) TextView tvTitle;
    @BindView(R.id.tvOverview) TextView tvOverview;
    @BindView(R.id.rbVoteAverage) RatingBar rbVoteAverage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies_details);
        ButterKnife.bind(this);

        // resolve the view objects
        /*
        tvTitle = (TextView) findViewById(R.id.tvTitle);
        tvOverview = (TextView) findViewById(R.id.tvOverview);
        rbVoteAverage = (RatingBar) findViewById(R.id.rbVoteAverage);
        */

        // initialize client
        client = new AsyncHttpClient();


        // unwrap the movie passed in via intent, using its simple name asa  key
        movie = (Movie) Parcels.unwrap(getIntent().getParcelableExtra(Movie.class.getSimpleName()));
        Log.d("MovieDetailsActivity", String.format("Showing details for '%s'", movie.getTitle()));

        // set the title and overview
        tvTitle.setText(movie.getTitle());
        tvOverview.setText(movie.getOverview());

        // vote average
        float voteAverage = movie.getVoteAverage().floatValue();
        rbVoteAverage.setRating(voteAverage = voteAverage > 0 ? voteAverage / 2.0f: voteAverage);
    }
    /*
    private String getVideoKey(){
        // create URL
        String url = API_BASE_URL + "/movie/" + movie.getId() + "/videos";
        // set the request parameters
        RequestParams params = new RequestParams();
        params.put(API_KEY_PARAM, getString(R.string.api_key)); // API key, always required
        client.get(url, params, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                try {
                    // load the results into movies list
                    JSONArray results = response.getJSONArray("results");
                } catch (JSONException e) {
                    Log.e("");
                }
            }
        });
        return
    }
    */
}
