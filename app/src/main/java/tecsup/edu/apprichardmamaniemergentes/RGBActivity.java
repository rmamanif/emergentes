package tecsup.edu.apprichardmamaniemergentes;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.slider.Slider;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import tecsup.edu.apprichardmamaniemergentes.modelo.Leds;
import tecsup.edu.apprichardmamaniemergentes.modelo.RGB;
import tecsup.edu.apprichardmamaniemergentes.modelo.Sensor;

public class RGBActivity extends AppCompatActivity {

    private FirebaseDatabase database;
    private DatabaseReference myRef;
    private RGB RGB;

    private Slider red;
    private Slider green;
    private Slider blue;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rgb);

        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("RGB");

        red=(Slider)findViewById(R.id.red);
        green=(Slider)findViewById(R.id.green);
        blue=(Slider)findViewById(R.id.blue);

        red.addOnSliderTouchListener(new Slider.OnSliderTouchListener() {
            @Override
            public void onStartTrackingTouch(@NonNull Slider slider) {

            }

            @Override
            public void onStopTrackingTouch(@NonNull Slider slider) {
                    float value=slider.getValue();
                    RGB.Rojo= (int) value;
                    myRef.setValue(RGB);
                    Log.d("LEDROJO = ",value + "");
            }
        });

        green.addOnSliderTouchListener(new Slider.OnSliderTouchListener() {
            @Override
            public void onStartTrackingTouch(@NonNull Slider slider) {

            }

            @Override
            public void onStopTrackingTouch(@NonNull Slider slider) {
                float value=slider.getValue();
                RGB.Verde= (int) value;
                myRef.setValue(RGB);
                Log.d("LEDVERDE = ",value + "");
            }
        });

        blue.addOnSliderTouchListener(new Slider.OnSliderTouchListener() {
            @Override
            public void onStartTrackingTouch(@NonNull Slider slider) {

            }

            @Override
            public void onStopTrackingTouch(@NonNull Slider slider) {
                float value=slider.getValue();
                RGB.Azul= (int) value;
                myRef.setValue(RGB);
                Log.d("LEDAZUL = ",value + "");
            }
        });

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                RGB = dataSnapshot.getValue(RGB.class);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.w("firebase", "Failed to read value.", error.toException());
            }
        });

    }
}



