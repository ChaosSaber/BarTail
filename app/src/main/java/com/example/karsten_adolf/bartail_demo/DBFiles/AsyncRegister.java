package com.example.karsten_adolf.bartail_demo.DBFiles;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import com.example.karsten_adolf.bartail_demo.BrowseActivity;
import com.example.karsten_adolf.bartail_demo.R;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;

import java.sql.SQLException;

/**
 * Created by jonas on 28.05.15.
 */
public class AsyncRegister extends AsyncClass {
    private static final String TAG = "AsyncRegister";
    private User aUser;

    public AsyncRegister(Context aContext, User aUser) {
        super(aContext);
        this.aUser = aUser;
    }

    protected void success() {
        Intent intent = new Intent(this.aContext, BrowseActivity.class);
        aContext.startActivity(intent);
        Toast toast = Toast.makeText(aContext, R.string.register_success, Toast.LENGTH_SHORT);
        toast.show();
    }

    protected  void fail() {
        Toast toast = Toast.makeText(aContext, R.string.register_fail, Toast.LENGTH_SHORT);
        toast.show();
    }

    protected boolean makeDAO() {
        Dao<User, Integer> userDAO;
        try {
                userDAO = DaoManager.createDao(connectionSource, User.class);
                if (userDAO.queryForEq("email", aUser.getE_mail()).isEmpty()) {
                    if (userDAO.queryForEq("name", aUser.getUsername()).isEmpty()) {
                        userDAO.create(aUser);
                        return true;
                    }
                 }
            } catch (SQLException e) {
                e.printStackTrace();
                Log.d(TAG, "makeDAO() failed while creating USER: " + e.getMessage());
            }
            return false;
        }
}
