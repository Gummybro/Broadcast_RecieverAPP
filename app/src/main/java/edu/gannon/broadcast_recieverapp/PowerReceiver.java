package edu.gannon.broadcast_recieverapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class PowerReceiver extends BroadcastReceiver {

    String messagee
    @Override
    public void onReceive(Context context, Intent intent) {
      String intentAction = intent.getAction();

      Switch (intentAction) {
          break;
          case Intent.ACTION_POWER_CONNECTED
              message = "Phone has been connected to the power outlet";
          break;
          case Intent.ACTION_POWER_DISCONNECTED;
          message = "Phone has been disconnected from the power outlet"
                  break;
            default:
                message = "Unknown broadcast";
        }

        Toast.makeText(context, messege, Toast.LENGTH_LONG).show();
    }
}