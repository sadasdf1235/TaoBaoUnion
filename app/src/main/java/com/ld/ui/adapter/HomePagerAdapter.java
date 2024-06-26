package com.ld.ui.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.ld.model.domain.Categories;
import com.ld.ui.fragment.HomePagerFragment;

import java.util.ArrayList;
import java.util.List;

public class HomePagerAdapter extends FragmentPagerAdapter {
    List<Categories.DataDTO> categoriesList = new ArrayList<>();
    public HomePagerAdapter(@NonNull FragmentManager fm) {
        super(fm,BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        Categories.DataDTO dataDTO = categoriesList.get(position);
        HomePagerFragment homePagerFragment = HomePagerFragment.newInstance(dataDTO);
        return homePagerFragment;
    }

    @Override
    public int getCount() {
        return categoriesList.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return categoriesList.get(position).getTitle();
    }
    public void setCategoriesList(Categories categories){
        categoriesList.clear();
        List<Categories.DataDTO> data = categories.getData();
        categoriesList.addAll(data);
        notifyDataSetChanged();
    }
}
