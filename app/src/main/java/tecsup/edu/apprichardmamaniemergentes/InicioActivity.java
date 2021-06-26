package tecsup.edu.apprichardmamaniemergentes;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class InicioActivity extends AppCompatActivity {
    private Button btnMenu1;
    private Button btnMenu2;
    private Button btnMenu3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);

        btnMenu1 = findViewById(R.id.btnMenu1);
        btnMenu2 = findViewById(R.id.btnMenu2);
        btnMenu3 = findViewById(R.id.btnMenu3);

        btnMenu1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent act = new Intent(InicioActivity.this, MainActivity.class);
                startActivity(act);
            }
        });

        btnMenu2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent act = new Intent(InicioActivity.this, SensorActivity.class);
                startActivity(act);
            }
        });

        btnMenu3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent act = new Intent(InicioActivity.this,RGBActivity.class);
                startActivity(act);
            }
        }) ;
    }


}