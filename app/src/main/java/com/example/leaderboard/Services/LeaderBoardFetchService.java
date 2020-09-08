package com.example.leaderboard.Services;

import com.example.leaderboard.Model.LeaderBoard;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface LeaderBoardFetchService {
    @GET("/api/hours")
    Call<List<LeaderBoard>> getHours();
}
