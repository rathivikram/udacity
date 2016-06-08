package com.example.android.popularmovies;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Random;
import java.util.UUID;

/**
 * Created by vikram.rathi on 6/6/16.
 */
public class MovieData implements Parcelable {
    private final long id;
    private final String name;
    private final String posterUrl;

    public MovieData(String name, String posterUrl) {
        this.id = new Random().nextLong();
        this.name = name;
        this.posterUrl = posterUrl;
    }

    public MovieData(Parcel in) {
        this.id = in.readLong();
        this.name = in.readString();
        this.posterUrl = in.readString();
    }


    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPosterUrl() {
        return posterUrl;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(id);
        dest.writeString(name);
        dest.writeString(posterUrl);
    }

    public static final Parcelable.Creator<MovieData> CREATOR = new Parcelable.Creator<MovieData>() {
        @Override
        public MovieData createFromParcel(Parcel source) {
            return new MovieData(source);
        }

        @Override
        public MovieData[] newArray(int size) {
            return new MovieData[size];
        }
    };
}
