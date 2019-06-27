package com.example.flicks.models;

import org.json.JSONException;
import org.json.JSONObject;

public class Movie {
    // values from API
    private String title;
    private String overview;
    private String posterPath; // only the path
    private String backdropPath; // only the path

   // initialize from JSON data
   public Movie(JSONObject object) throws JSONException {
       title = object.getString("title");
       overview = object.getString("overview");
       posterPath = object.getString("poster_path");
       backdropPath = object.getString("backdrop_path");
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
