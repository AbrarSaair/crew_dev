package test.com.lexin.dewcrew.ui.activities;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.InflateException;
import android.view.View;

import org.json.JSONObject;

import java.util.ArrayList;

import test.com.lexin.dewcrew.R;
import test.com.lexin.dewcrew.listeners.IResultListener;
import test.com.lexin.dewcrew.model.User;
import test.com.lexin.dewcrew.parser.UserParser;
import test.com.lexin.dewcrew.ui.adapters.UserAdapter;
import test.com.lexin.dewcrew.ui.fragments.FragmentDialog;

public class MainActivity extends AppCompatActivity implements IResultListener {
    public static final String TAG = "tag";
    private FloatingActionButton actionButton;
    private UserAdapter userAdapter;
    private ArrayList<User> users;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initComponents();
        setListener();
        loadUserData();
        initAdapter();
    }

    private void initAdapter() {
        userAdapter = new UserAdapter(users);
        recyclerView.setAdapter(userAdapter);
    }

    private void updateAdapter() {
        if (userAdapter != null) {
            userAdapter.setData(users);
            userAdapter.notifyDataSetChanged();
        } else if (users != null) {
            initAdapter();
        }
    }

    private void loadUserData() {
        users = (ArrayList<User>) new UserParser().parseData(new JSONObject());
    }

    private void initComponents() {
        try {
            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);
            actionButton = (FloatingActionButton) findViewById(R.id.fab);
            recyclerView = (RecyclerView) findViewById(R.id.users_recycler_view);
            layoutManager = new LinearLayoutManager(this);
            recyclerView.setLayoutManager(layoutManager);
        } catch (InflateException e) {
            e.printStackTrace();
        }
    }

    private void setListener() {
        if (actionButton != null) {
            actionButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    showDialog();
                }
            });
        }
    }

    private void showDialog() {
        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        Fragment previous = fm.findFragmentByTag(TAG);
        if (previous != null) {
            ft.remove(previous);
        }
        ft.addToBackStack(null);

        FragmentDialog fragmentDialog = new FragmentDialog();
        fragmentDialog.show(fm, TAG);
        ft.commit();
    }


    @Override
    public void onActionDone(User user) {
        if (user != null) {
            users.add(user);
            updateAdapter();
        }
    }
}
