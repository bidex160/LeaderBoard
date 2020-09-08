package com.example.leaderboard;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.leaderboard.Adapters.LeaderBoardRecyclerviewAdapter;
import com.example.leaderboard.Model.LeaderBoard;
import com.example.leaderboard.Services.LeaderBoardFetchService;
import com.example.leaderboard.Services.ServiceBuilder;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.ContentValues.TAG;

public class LeadersBoardTabLayoutFragment extends Fragment {
    private RecyclerView recyclerView;
    private LeaderBoardRecyclerviewAdapter leaderBoardRecyclerviewAdapter;
    private List<LeaderBoard> leaderBoard;

    //add a public constructor
    public LeadersBoardTabLayoutFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.leadersboard_fragment, container, false);
        recyclerView = view.findViewById(R.id.RecView);
        leaderBoard = new ArrayList<>();
         return view;
    }

    @Override
    public void onViewCreated(@NonNull final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        LeaderBoardFetchService leaderBoardFetchService= ServiceBuilder.buildService(LeaderBoardFetchService.class);
        Call<List<LeaderBoard>> leaderBoardRequest = leaderBoardFetchService.getHours();

        leaderBoardRequest.enqueue(new Callback<List<LeaderBoard>>() {
            @Override
            public void onResponse(Call<List<LeaderBoard>> call, Response<List<LeaderBoard>> response) {
                /**
                 * @see i added the {@link androidx.recyclerview.widget.LinearLayoutManager} via
                 * the xml file.
                 * Your MAJOR error = you forgot to add you response body to your adaptor
                 */
                leaderBoardRecyclerviewAdapter = new LeaderBoardRecyclerviewAdapter();
                leaderBoardRecyclerviewAdapter.setLeaderBoard( response.body());
                recyclerView.setAdapter(leaderBoardRecyclerviewAdapter);

            }

            @Override
            public void onFailure(Call<List<LeaderBoard>> call, Throwable t) {
                Log.d(TAG, "onFailure: unable to load data"+ t.getMessage());
            }
        });
    }
}
