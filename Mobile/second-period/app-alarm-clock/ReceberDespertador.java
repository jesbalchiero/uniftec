package com.uniftec.despertador;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Vibrator;

public class ReceberDespertador extends BroadcastReceiver {
    protected static Vibrator vibrar = null;
    public void onReceive(Context c, Intent i)
    {
        vibrar = (Vibrator) c.getSystemService(Context.VIBRATOR_SERVICE);
        long[] vibracao = new long[]{0,5000,10000};
        vibrar.vibrate(vibracao,0);
        try
        {
            MainActivity.notificationManager.cancel(R.drawable.ic_launcher_background);
        }catch(Exception e){}
    }
}
