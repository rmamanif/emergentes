package tecsup.edu.apprichardmamaniemergentes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import tecsup.edu.apprichardmamaniemergentes.modelo.Leds;

public class MainActivity extends AppCompatActivity {

    private ImageView imgLed1;
    private Button btnLed1On;
    private Button btnLed1Off;
    private ImageView imgLed2;
    private Button btnLed2On;
    private Button btnLed2Off;
    private ImageView imgLed3;
    private Button btnLed3On;
    private Button btnLed3Off;

    private FirebaseDatabase database;
    private DatabaseReference myRef;
    private Leds luces;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgLed1 = findViewById(R.id.imgLed1);
        btnLed1On = findViewById(R.id.btnLed1On);
        btnLed1Off = findViewById(R.id.btnLed1Off);
        imgLed2 = findViewById(R.id.imgLed2);
        btnLed2On = findViewById(R.id.btnLed2On);
        btnLed2Off = findViewById(R.id.btnLed2Off);
        imgLed3 = findViewById(R.id.imgLed3);
        btnLed3On = findViewById(R.id.btnLed3On);
        btnLed3Off = findViewById(R.id.btnLed3Off);

        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("Leds");

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                luces = dataSnapshot.getValue(Leds.class);
                if(luces.led1.equals("1")){
                    imgLed1.setImageResource(R.drawable.led_on_blue);
                }else{
                    imgLed1.setImageResource(R.drawable.led_off);
                }

                if(luces.led2.equals("1")){
                    imgLed2.setImageResource(R.drawable.led_on_orange);
                }else{
                    imgLed2.setImageResource(R.drawable.led_off);
                }

                if(luces.led3.equals("1")){
                    imgLed3.setImageResource(R.drawable.led_on_yellow);
                }else{
                    imgLed3.setImageResource(R.drawable.led_off);
                }

            }
            //



            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("firebase", "Failed to read value.", error.toException());
            }
        });


        btnLed1On.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Logica de encendido
                luces.led1 = "1";
                myRef.setValue(luces);
            }
        });
        btnLed1Off.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Logica de apagado
                luces.led1 = "0";
                myRef.setValue(luces);
            }
        });
        btnLed2On.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                luces.led2 = "1";
                myRef.setValue(luces);
            }
        });
        btnLed2Off.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Logica de apagado
                luces.led2 = "0";
                myRef.setValue(luces);
            }
        });
        btnLed3On.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Logica de encendido
                luces.led3 = "1";
                myRef.setValue(luces);

            }
        });

        btnLed3Off.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Logica de encendido
                luces.led3 = "0";
                myRef.setValue(luces);
            }
        });

    }

}