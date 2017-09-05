package kr.co.tjeit.instacopyproject02;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by the on 2017-09-05.
 */

public abstract class BaseAcitivity extends AppCompatActivity {

    Context mContext = this;

    public abstract void setEvents();

    public abstract void setValues();

    public abstract void bindViews();
}
