package pk.edu.comsats.csquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Rules extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rules);
    }
    public void onBackPressed() {
        startActivity(new Intent(getApplicationContext(), MainMenu.class));
        finish();
    }
}
