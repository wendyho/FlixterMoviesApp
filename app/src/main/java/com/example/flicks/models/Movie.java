package com.example.flicks.models;

import org.json.JSONException;
import org.json.JSONObject;
import org.parceler.Parcel;

@Parcel
public class Movie {
    // values from API
     String title;
     String overview;
     String posterPath; // only the path
     String backdropPath; // only the path
    Double voteAverage;

    public Movie() {}

   // initialize from JSON data
   public Movie(JSONObject object) throws JSONException {
       title = object.getString("title");
       overview = object.getString("overview");
       posterPath = object.getString("poster_path");
       backdropPath = object.getString("backdrop_path");
       voteAverage = object.getDouble("vote_average");
   }

    public Double getVoteAverage() {
        return voteAverage;
    }

    public String getBackdropPath() {
        return backdropPath;
    }

    public String getTitle() {
        return title;
    }

    public String getOverview() {
        return overview;
    }

    public String getPosterPath() {
        return posterPath;
    }
}
