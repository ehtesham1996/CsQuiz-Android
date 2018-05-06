package pk.edu.comsats.csquiz;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Result extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        TextView result1=(TextView) findViewById(R.id.tvout);
        Bundle bundle = getIntent().getExtras();
        String stuff = bundle.getString("money");
        result1.setText("You won $" + stuff);
    }
    public void ShiftToGame(View play) {
        Button play1=(Button) play;
        startActivity(new Intent(getApplicationContext(), Game.class));
        finish();
    }
    public void GotoMenu(View mainmenu){
        Button play1=(Button) mainmenu;
        startActivity(new Intent(getApplicationContext(), MainMenu.class));
        finish();
    }
    @Override
    public void onBackPressed() {
        startActivity(new Intent(getApplicationContext(), MainMenu.class));
        finish();
    }
    public void Exit(View exit){
        Button exit1=(Button) exit;
        new AlertDialog.Builder(this)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setTitle("Exit")
                .setMessage("Are you sure you want to close this game?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                        System.exit(0);
                    }

                })
                .setNegativeButton("No", null)
                .show();
    }

}
