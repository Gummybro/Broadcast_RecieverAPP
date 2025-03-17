package edu.gannon.broadcast_recieverapp;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    PowerReceiver mPowerReciever = new PowerReceiver()
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        IntentFilter Powerfilter = new IntentFilter();
        powerfilter.addAction(Intent.ACTION_POWER_CONNECTED);
        powerfilter.addAction(Intent.ACTION_POWER_DISCONNECTED);

        registerReceiver(mPowerReciever , powerfilter)
    }
    Protected void onStop() {
        super.onStop();
        unregisterReceiver(mPowerReciever);
    }
}