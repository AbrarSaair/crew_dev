package test.com.lexin.dewcrew.ui.fragments;

import android.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import test.com.lexin.dewcrew.R;
import test.com.lexin.dewcrew.listeners.IResultListener;
import test.com.lexin.dewcrew.model.User;

/**
 * Created by Sair on 5/4/2016.
 */
public class FragmentDialog extends DialogFragment implements View.OnClickListener {

    private EditText editTextFirstName;
    private EditText editTextLastName;
    private Button cancelButton;
    private Button addButton;
    private IResultListener listener;

    public FragmentDialog() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dialog, container);
        initComponents(view);
        setListeners();
        return view;
    }

    private void setListeners() {
        cancelButton.setOnClickListener(this);
        addButton.setOnClickListener(this);
    }

    private void initComponents(View view) {
        editTextFirstName = (EditText) view.findViewById(R.id.edit_text_first_name);
        editTextLastName = (EditText) view.findViewById(R.id.edit_text_last_name);
        addButton = (Button) view.findViewById(R.id.button_add);
        cancelButton = (Button) view.findViewById(R.id.button_cancel);
        getDialog().setTitle(R.string.fragment_dialog_title);
        listener = (IResultListener) getActivity();
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.button_cancel) {
            this.dismiss();
        } else if (v.getId() == R.id.button_add) {
            onActionAdd();
        }
    }

    private void onActionAdd() {
        String firstName = editTextFirstName.getText().toString().trim();
        if (firstName.isEmpty()) {
            editTextFirstName.setError(getResources().getString(R.string.dialog_first_name_error_message));
            return;
        }
        String lastName = editTextLastName.getText().toString().trim();
        if (lastName.isEmpty()) {
            editTextLastName.setError(getResources().getString(R.string.dialog_last_name_error_message));
            return;
        }
        User user = new User(firstName, lastName);
        if (listener != null) {
            listener.onActionDone(user);
        }
        this.dismiss();
    }
}
