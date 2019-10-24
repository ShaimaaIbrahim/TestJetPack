package com.google.testjetback.view.activity;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;

import com.google.testjetback.view.adapters.MainAdapter;
import com.google.testjetback.viewModel.MainNavigator;
import com.google.testjetback.R;
import com.google.testjetback.databinding.ActivityMainBinding;
import com.google.testjetback.model.User;
import com.google.testjetback.viewModel.MainViewModel;

public class MainActivity extends AppCompatActivity  implements MainNavigator {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

      //  https://stackoverflow.com/questions/40575112/android-spinner-setting-selection-with-2-way-binding
        
        // tool used to bind data into xml files
        final ActivityMainBinding binding = DataBindingUtil.
                setContentView(MainActivity.this, R.layout.activity_main);

        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));


        final MainViewModel viewModel = ViewModelProviders.of(this).get(MainViewModel.class);


        viewModel.setUser();
        viewModel.setNavigator(this);

        //Pattern to show data
        viewModel.getUser().observe(this,
                users -> binding.recyclerView.setAdapter(new MainAdapter(users, viewModel)));
                /*
                #Button in xml file
                binding.setViewModel(viewModel);
                */
                /*
                if we set single text in layout
               binding.setUser(user);
                 */
    }


    @Override
    public void onItemClick(User user) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(user.getName());
        if (user.isMark.get()) {
            builder.setPositiveButton("UNMARK", (dialog, which) -> {
                user.isMark.set(false);
                dialog.dismiss();

            });
        }else {
            builder.setPositiveButton("MARK", (dialog, which) -> {
                user.isMark.set(true);
                dialog.dismiss();

            });

        }
        builder.show();
    }
}