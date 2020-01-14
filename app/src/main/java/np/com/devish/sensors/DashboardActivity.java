package np.com.devish.sensors;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DashboardActivity extends AppCompatActivity {

    private Button btnAllSensors, btnShowAccelerometer, btnShowGyro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        setTitle("Dashboard");
        btnAllSensors = findViewById(R.id.btnAllSensors);
        btnShowAccelerometer = findViewById(R.id.btnShowAccelerometer);
        btnShowGyro = findViewById(R.id.btnShowGyro);


        btnAllSensors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DashboardActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        btnShowAccelerometer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DashboardActivity.this, AccelerometerSensorActivity.class);
                startActivity(intent);
            }
        });

        btnShowGyro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DashboardActivity.this, GyroscopeSensorActivity.class);
                startActivity(intent);
            }
        });
    }
}
