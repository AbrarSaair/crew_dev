package test.com.lexin.dewcrew.ui.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import test.com.lexin.dewcrew.R;
import test.com.lexin.dewcrew.model.User;
import test.com.lexin.dewcrew.ui.viewholders.UserViewHolder;

/**
 * Created by Sair on 5/3/2016.
 */
public class UserAdapter extends RecyclerView.Adapter<UserViewHolder> {
    private ArrayList<User> users;

    public UserAdapter(ArrayList<User> users) {
        this.users = users;
    }

    @Override
    public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.user_item, parent, false);

        UserViewHolder vh = new UserViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(UserViewHolder holder, int position) {
        holder.updateView(users.get(position));

    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public void setData(ArrayList<User> users) {
        this.users = users;
    }
}
