package com.example.karsten_adolf.bartail_demo.DBFiles;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.example.karsten_adolf.bartail_demo.BrowseActivity;
import com.example.karsten_adolf.bartail_demo.LoginActivity;
import com.example.karsten_adolf.bartail_demo.R;
import com.example.karsten_adolf.bartail_demo.helper.Variables;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by jonas on 26.05.15.
 */
public class AsyncLogin extends AsyncClass {
    private static final String TAG = "AsyncLogin";
    private ProgressDialog progress;
    private User aUser;

    public AsyncLogin(Context aContext, User aUser) {
        super(aContext);
        this.aUser = aUser;
        progress = new ProgressDialog(this.aContext);
        progress.setIndeterminate(true);
        progress.setMessage(this.aContext.getString(R.string.progress_login));
        progress.setProgressStyle(ProgressDialog.STYLE_SPINNER);
    }

    protected void success() {
        Intent intent = new Intent(aContext, BrowseActivity.class);
        aContext.startActivity(intent);
        Toast toast = Toast.makeText(aContext, R.string.login_success, Toast.LENGTH_SHORT);
        toast.show();
    }

    protected void fail() {
        Toast toast = Toast.makeText(aContext, R.string.login_fail, Toast.LENGTH_LONG);
        toast.show();
    }

    protected boolean makeDAO() {
        List<User> users = null;
        Dao<User, Integer> userDAO;
        boolean result = false;
        LoginActivity aLogin = (LoginActivity) this.aContext;
        aLogin.runOnUiThread(new Runnable() {
            public void run() {
                progress.show();
            }
        });


        try {
            userDAO = DaoManager.createDao(connectionSource, User.class);
            users = userDAO.queryForMatching(aUser);
            result = users.size() == 1;
        }
        catch (SQLException | NullPointerException e) {
            assert users != null: "UserList ist leer! Vielleicht ein Fehler in der Warteschlange oder keine User gefunden";
            Variables.user = users.get(0);
        }
        return result;
    }

}
