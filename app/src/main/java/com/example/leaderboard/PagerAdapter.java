package com.example.leaderboard;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class PagerAdapter extends FragmentStatePagerAdapter {
   int mNumOfTabs;
   public PagerAdapter(FragmentManager fm, int mNumOfTabs){
       super(fm);
       this.mNumOfTabs = mNumOfTabs;
   }
    @NonNull
    @Override
    public Fragment getItem(int position) {
       switch (position){
           case 0: return new SkillIQTabLayoutFragment();
           case 1: return new LeadersBoardTabLayoutFragment();
       }
        return null;
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}
