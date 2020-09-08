package com.example.leaderboard.Adapters;

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
import java.util.List;

public class LeaderBoardRecyclerviewAdapter extends RecyclerView.Adapter<LeaderBoardRecyclerviewAdapter.ViewHolder> {

    //initialize the array list
    private List<LeaderBoard> leaderBoard = new ArrayList<>();

    /**
     * I removed all unnecessary constructors  
     */
    public  LeaderBoardRecyclerviewAdapter(){

     }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_leaderboard, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        /**
         * @see I moved all the logic to [{@link ViewHolder} class
         */
        holder.bind( leaderBoard.get(position));
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

        public void bind(LeaderBoard leaderBoard){
            txtStudentName.setText(leaderBoard.getName());
            txtHoursEngaged.setText(leaderBoard.getHours());

            /**
             * @see add Glide dependency then uncomment below
             * Glide takes an image URl and loads it to an ImageView
             */
//            Glide.with( image.getContext())
//                    .load( leaderBoard.getImage())
//                    .centerCrop()
//                    .into(image);
        }
    }
}