package com.example.myrxapp.UI.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myrxapp.POJO.PostsModel;
import com.example.myrxapp.R;

import java.util.ArrayList;
import java.util.List;

public class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.PostViewHolder> {
    private List<PostsModel> postsModels= new ArrayList<>();
    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PostViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.post_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {

        holder.titletv.setText(postsModels.get(position).getTitle());
        holder.usertv.setText(postsModels.get(position).getUserId()+" ");
        holder.bodytv.setText(postsModels.get(position).getBody());

    }

    @Override
    public int getItemCount() {
        return postsModels.size();
    }
    public void setList(List<PostsModel> postList){
        postsModels=postList;
        notifyDataSetChanged();
    }

    public class PostViewHolder extends RecyclerView.ViewHolder {
        TextView usertv,titletv,bodytv;
        public PostViewHolder(@NonNull View itemView) {

            super(itemView);
            titletv=itemView.findViewById(R.id.titletv);
            usertv=itemView.findViewById(R.id.useridtv);
            bodytv=itemView.findViewById(R.id.bodytv);

        }
    }
}
