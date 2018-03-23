package xyz.z3ro.serialkiller;

import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button newGame = (Button)findViewById(R.id.new_game);
        Button joinGame = (Button)findViewById(R.id.join_game);
        Button settings = (Button)findViewById(R.id.settings);
        Button contactMe = (Button)findViewById(R.id.contact_me);
        Button about = (Button)findViewById(R.id.about);
        Button credits = (Button)findViewById(R.id.credits);
        newGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent host = new Intent(MainActivity.this,Host.class);
                startActivity(host);
            }
        });
        joinGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent join = new Intent(MainActivity.this,Join.class);
                startActivity(join);
            }
        });
        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent settings = new Intent(MainActivity.this,SettingsActivity.class);
                startActivity(settings);
            }
        });
        contactMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent contact = new Intent(MainActivity.this,Contact.class);
                startActivity(contact);
            }
        });
        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent aboutApp = new Intent(MainActivity.this,About.class);
                startActivity(aboutApp);
            }
        });
        credits.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogFragment newFrag = new CreditsFragment();
                newFrag.show(getFragmentManager(),"credits");
            }
        });
    }

    @Override
    public void onBackPressed() {
        DialogFragment newFrag2 = new ExitFragment();
        newFrag2.show(getFragmentManager(),"exit");
    }
    public class ExitFragment extends DialogFragment {
        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), R.style.AppCompatAlertDialogStyle);
            builder.setIcon(R.drawable.ic_exit_to_app_white_24dp);
            builder.setTitle("Exit App");
            builder.setMessage(R.string.exit_message);
            builder.setPositiveButton(R.string.dialog_okay, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    finish();
                }
            });
            builder.setNegativeButton(R.string.dialog_cancel,null);
            builder.create();
            return builder.create();
        }
    }
    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            getWindow().getDecorView().setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        }
    }
}
