package xyz.z3ro.serialkiller;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.support.v7.app.ActionBar;
import android.view.MenuItem;
import android.util.Log;

public class About extends AppCompatPreferenceActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupActionBar();
        getFragmentManager().beginTransaction().replace(android.R.id.content, new AboutFragment()).commit();
    }
    private void setupActionBar() {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            // Show the Up button in the action bar.
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            navigateUpTo(new Intent(this, SettingsActivity.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public static class AboutFragment extends PreferenceFragment {
        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            addPreferencesFromResource(R.xml.about);
            Preference checkUpdate = findPreference("app_update");
            if(checkUpdate!=null){
                checkUpdate.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
                    @Override
                    public boolean onPreferenceClick(Preference preference) {
                        Context context=getActivity();
                        if (context != null) {
                            new CheckUpdateTask(context, xyz.z3ro.serialkiller.UpdateChecker.Constants.TYPE_DIALOG, true).execute();
                        } else {
                            Log.e(xyz.z3ro.serialkiller.UpdateChecker.Constants.TAG, "The arg context is null");
                        }
                        return false;
                    }
                });
            }
            setHasOptionsMenu(true);
        }
    }
}