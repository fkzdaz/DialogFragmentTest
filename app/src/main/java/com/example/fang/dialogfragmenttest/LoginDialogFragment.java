package com.example.fang.dialogfragmenttest;

import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

/**
 * Created by Fkz on 2017/4/26.
 */

public class LoginDialogFragment extends DialogFragment {

    private EditText mUsername;
    private EditText mPassword;

    public interface LoginInputListener
    {
        void onLoginInputComplete(String username, String password);
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());

        LayoutInflater inflater=getActivity().getLayoutInflater();
        View view=inflater.inflate(R.layout.login,null);
        mUsername = (EditText) view.findViewById(R.id.id_txt_username);
        mPassword = (EditText) view.findViewById(R.id.id_txt_password);
        builder.setView(view);
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                LoginInputListener listener = (LoginInputListener) getActivity();
                listener.onLoginInputComplete(mUsername
                        .getText().toString(), mPassword
                        .getText().toString());
            }
        }).setNegativeButton("取消",null);
        return builder.create();
    }
}
