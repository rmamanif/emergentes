package tecsup.edu.apprichardmamaniemergentes;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import tecsup.edu.apprichardmamaniemergentes.modelo.Sensor;

public class SensorActivity extends AppCompatActivity {
    //1. DECLARANDO VARIABLES
    private TextView lblTemperatura;
    private TextView lblHumedad;

    //variables de Firebase
    private FirebaseDatabase database;
    private DatabaseReference myRef;
    private Sensor sensor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor);

        //2.ASIGNAR VARIABLE CON DISEÑO
        lblTemperatura = findViewById(R.id.lblTemperatura);
        lblHumedad = findViewById(R.id.lblHumedad);

        // Accesing to the database
        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("Sensor");

        



        //3. OPERACIONES Y METODOS
        // Read from the database
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                sensor = dataSnapshot.getValue(Sensor.class);
                lblTemperatura.setText(String.valueOf(sensor.Temperatura));
                lblHumedad.setText(String.valueOf(sensor.Humedad));
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
            }
        });
    }
}