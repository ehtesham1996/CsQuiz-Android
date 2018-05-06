package pk.edu.comsats.csquiz;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.view.View.OnClickListener;

public class MainMenu extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main_menu);
    }
    public void ShiftToGame(View play) {
        Button play1=(Button) play;
        startActivity(new Intent(getApplicationContext(), Game.class));
        finish();
    }
    public void GotoRules(View rules){
        startActivity(new Intent(getApplicationContext(), Rules.class));
        finish();
    }
    public void GotoAbout(View about){
        startActivity(new Intent(getApplicationContext(), About.class));
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
