package com.spentas.javad.securechat.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.spentas.javad.securechat.R;
import com.spentas.javad.securechat.model.User;
import com.spentas.javad.securechat.sqlite.DbHelper;

import java.util.List;
import java.util.zip.Inflater;

import javax.inject.Inject;

import butterknife.Bind;

/**
 * Created by javad on 11/11/2015.
 */
public class FriendListAdapter extends RecyclerView.Adapter<FriendListAdapter.ViewHolder> {


    private Context mContext;
    private List<User> mUsers;

    public FriendListAdapter(Context mContext, List<User> mUsers) {
        this.mContext = mContext;
        this.mUsers = mUsers;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.raw_friendlist,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.username.setText(mUsers.get(position).getUsername());

    }

    @Override
    public int getItemCount() {
        return mUsers.size();
    }

  protected static class ViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.frienlist_profile_image)
        de.hdodenhof.circleimageview.CircleImageView profileImage;
        TextView username;

        public ViewHolder(View itemView) {
            super(itemView);
            username = (TextView)itemView.findViewById(R.id.friendlist_username);


        }
    }


}



