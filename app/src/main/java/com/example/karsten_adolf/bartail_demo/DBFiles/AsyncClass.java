package com.example.karsten_adolf.bartail_demo.DBFiles;

import android.content.Context;
import android.os.AsyncTask;

import com.j256.ormlite.support.ConnectionSource;

/**
 * Created by jonas on 26.05.15.
 */
public abstract class AsyncClass extends AsyncTask<Void, Void, Boolean> {
    protected Context aContext;
    protected ConnectionSource connectionSource;

    public AsyncClass(Context aContext) {
        this.aContext = aContext;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        connectionSource = Database.makeConnection();
    }

    @Override
    protected Boolean doInBackground(Void... params) {
        return makeDAO();
    }

    @Override
    protected void onPostExecute(Boolean aBoolean) {
        super.onPostExecute(aBoolean);
        onResult(aBoolean);
    }

    protected void onResult(Boolean aBoolean) {
        if(aBoolean)
            success();
        else
            fail();
    }

    protected abstract void success();

    protected abstract void fail();

    protected abstract boolean makeDAO();

}
