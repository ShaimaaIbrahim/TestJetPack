package com.google.testjetback.view.adapters;


import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.google.testjetback.R;
import com.google.testjetback.databinding.ListItemBinding;
import com.google.testjetback.model.User;
import com.google.testjetback.viewModel.MainViewModel;

import java.util.List;

public class MainAdapter  extends RecyclerView.Adapter<MainAdapter.MainViewHolder> {

private List<User>users;
private MainViewModel viewModel;

    public MainAdapter(List<User> users , MainViewModel viewModel) {
        this.users = users;
        this.viewModel=viewModel;
    }

    @NonNull
    @Override
    public MainViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater= LayoutInflater.from(viewGroup.getContext());

        ListItemBinding itemBinding= DataBindingUtil.inflate(layoutInflater, R.layout.list_item
        ,viewGroup ,false);

     return new MainViewHolder(itemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull MainViewHolder mainViewHolder, int i) {
        User user=users.get(i);

        mainViewHolder.setBinding(user , viewModel);
    }

    @Override
    public int getItemCount() {

        return  users.size();
    }

    class MainViewHolder extends RecyclerView.ViewHolder{

        ListItemBinding binding;

        public MainViewHolder(@NonNull ListItemBinding  binding) {
            super(binding.getRoot());
            this.binding=binding;
        }

        void setBinding(User user ,MainViewModel viewModel){
            binding.setUser(user);
            binding.setViewModel(viewModel);
            binding.executePendingBindings();
        }

    }
}
