package com.example.leaderboard;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;

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
    Context context;
    private RecyclerView recyclerView;
    private LeaderBoardRecyclerviewAdapter leaderBoardRecyclerviewAdapter;
    private List<LeaderBoard> leaderBoard;
    private View view;
    private Object LeaderBoardRecyclerviewAdapter;
    private  LinearLayoutManager linearLayoutManager;
   private Adapter adapter;

    //add a public constructor
    public LeadersBoardTabLayoutFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.leadersboard_fragment, container, false);
        recyclerView = (RecyclerView)view.findViewById(R.id.RecView);
       // adapter = new LeaderBoardRecyclerviewAdapter((List<LeaderBoard>) getContext());
        leaderBoard = new ArrayList<>();
      //  LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
      //  recyclerView.setLayoutManager(linearLayoutManager);
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
                List<LeaderBoard> leaderBoard = response.body();
                leaderBoardRecyclerviewAdapter = new LeaderBoardRecyclerviewAdapter(leaderBoard, getContext());
               LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
               recyclerView.setLayoutManager(linearLayoutManager);

            }

            @Override
            public void onFailure(Call<List<LeaderBoard>> call, Throwable t) {
                Log.d(TAG, "onFailure: unable to load data"+ t.getMessage());
            }
        });
    }
}
