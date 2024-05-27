package com.example.bored_zhanara.ui.notifications;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bored_zhanara.Prefs;
import com.example.bored_zhanara.R;
import com.example.bored_zhanara.databinding.ItemBoardBinding;

public class BoardAdapter extends RecyclerView.Adapter<BoardAdapter.ViewHolder> {
    ItemBoardBinding binding;
    NavController navController;


    private int [] images = new int [] {R.drawable.welc3,
            R.drawable.welc2,
            R.drawable.welc3};
    private String [] titles = new String[]  {
            "Are you bored and don't know what to do?",
            "Then I can help you!",
            "Then WELCOME!" };

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding = ItemBoardBinding
                .inflate(LayoutInflater.from(parent.getContext()),parent, false);
        return new ViewHolder(binding);
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(position);

    }


    @Override
    public int getItemCount() {
        return images.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(@NonNull ItemBoardBinding itemView) {
            super(itemView.getRoot());


        }


        public void bind(int position) {
            binding.textBoard.setText(titles[position]);
            binding.imageBoard.setImageResource(images[position]);

            if(position == images.length-1){
                binding.btnStart.setVisibility(View.VISIBLE);
            }else{
                binding.btnStart.setVisibility(View.INVISIBLE);
            }

            binding.btnStart.setOnClickListener(v->{

                new Prefs((Activity)itemView.getContext()).saveBoardState();

                navController = Navigation.findNavController((Activity) itemView.getContext(),
                        R.id.nav_host);
                navController.navigate(R.id.action_navigation_notifications_to_navigation_home);
            });

        }
    }
}
