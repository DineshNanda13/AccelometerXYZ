package com.meterstoinches.accelometerxyz;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SensorEventListener {
    SensorManager sm;
    Sensor mysensor;
    LinearLayout ln;
    TextView t1,t2,t3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity1);
        t1=findViewById(R.id.textView1);
        t2=findViewById(R.id.textView2);
        t3=findViewById(R.id.textView3);
        ln=findViewById(R.id.mylayout);
        sm=(SensorManager) getSystemService(SENSOR_SERVICE);
        mysensor=sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
    }

    @Override
    protected void onResume() {
        super.onResume();
        sm.registerListener(this,mysensor,sm.SENSOR_DELAY_NORMAL);

    }

    @Override
    protected void onStop() {
        super.onStop();
        sm.unregisterListener(this,mysensor);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        float [] values = event.values;
        float accx = values[0];
        float accy = values[1];
        float accz = values[2];
        t1.setText("X: "+(int)accx);
        t2.setText("Y: "+(int)accy);
        t3.setText("Z: "+(int)accz);

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
