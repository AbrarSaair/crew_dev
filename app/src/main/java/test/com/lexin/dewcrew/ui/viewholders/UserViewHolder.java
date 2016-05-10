package test.com.lexin.dewcrew.ui.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import test.com.lexin.dewcrew.R;
import test.com.lexin.dewcrew.model.User;
import test.com.lexin.dewcrew.utils.CommonUtility;

/**
 * Created by Sair on 5/3/2016.
 */
public class UserViewHolder extends RecyclerView.ViewHolder {
    public TextView textView;

    public UserViewHolder(View v) {
        super(v);
        initComponents(v);
    }

    private void initComponents(View v) {
        textView = (TextView) v.findViewById(R.id.text_view);
    }

    public void updateView(User user) {
        if (user != null) {
            textView.setText(CommonUtility.capitalize(user.getLastName()) + ", " + CommonUtility.capitalize(user.getFirstName()));
        }
    }


}



