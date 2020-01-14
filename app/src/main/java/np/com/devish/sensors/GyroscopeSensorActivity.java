package np.com.devish.sensors;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class GyroscopeSensorActivity extends AppCompatActivity {

    public SensorManager sensorManager;
    public TextView tvShowGyro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gyroscope_sensor);

        setTitle("Gyroscope Sensor position");
        tvShowGyro = findViewById(R.id.tvShowGyro);

        //Used for receiving notification from the SensorManager when dynamic sensors
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        Sensor sensor = sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE);

        SensorEventListener gyrolistner = new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent event) {
                if (event.values[1] <0){
                    tvShowGyro.setText("Left");
                }else if(event.values[1] > 0){
                    tvShowGyro.setText("Right");
                }
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int accuracy) {

            }
        };
        if (sensor != null){
            sensorManager.registerListener(gyrolistner, sensor, SensorManager.SENSOR_DELAY_NORMAL);
        }else {
            Toast.makeText(this, "No sensor found", Toast.LENGTH_SHORT).show();
        }
    }
}
