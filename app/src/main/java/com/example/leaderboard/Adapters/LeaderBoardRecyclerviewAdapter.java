package com.example.leaderboard.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.leaderboard.Model.LeaderBoard;
import com.example.leaderboard.R;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class LeaderBoardRecyclerviewAdapter extends RecyclerView.Adapter<LeaderBoardRecyclerviewAdapter.ViewHolder> {
     Context context;
    //initialize the array list
    private List<LeaderBoard> leaderBoard = new ArrayList<>();
    //initialize the constructor
     public  LeaderBoardRecyclerviewAdapter(Context context, List<LeaderBoard> body){
       }

    public LeaderBoardRecyclerviewAdapter(List<LeaderBoard> body) {

    }

    public LeaderBoardRecyclerviewAdapter(List<LeaderBoard> leaderBoard, Context context) {
         this.context = context;
         this.leaderBoard = new ArrayList<>();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_leaderboard, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.txtStudentName.setText(leaderBoard.get(position).getName());
        holder.txtHoursEngaged.setText(leaderBoard.get(position).getHours());
        holder.image.setImageResource(leaderBoard.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        return leaderBoard.size();
    }

    public void setLeaderBoard(List<LeaderBoard> leaderBoard) {
        this.leaderBoard = leaderBoard;
        notifyDataSetChanged();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
       //initialize the text views
        private TextView txtStudentName, txtHoursEngaged;
        private ImageView image;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txtStudentName =itemView.findViewById(R.id.student_name);
            txtHoursEngaged =itemView.findViewById(R.id.hours_engaged);
            image = itemView.findViewById(R.id.image);
        }
    }
}