package xyz.z3ro.serialkiller;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.preference.PreferenceScreen;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.view.MenuItem;

public class Contact extends AppCompatPreferenceActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupActionBar();
        getFragmentManager().beginTransaction().replace(android.R.id.content, new ContactFragment()).commit();
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


    public static class ContactFragment extends PreferenceFragment {
        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            addPreferencesFromResource(R.xml.contact);
            Preference email = findPreference("contact_email");
            Preference facebook = findPreference("contact_facebook");
            Preference telegram = findPreference("contact_telegram");
            if (facebook != null) {
                facebook.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
                    @Override
                    public boolean onPreferenceClick(Preference preference) {
                        Uri my_facebook;
                        try {
                            getActivity().getPackageManager().getPackageInfo("com.facebook.katana",0);
                            my_facebook = Uri.parse("fb://facewebmodal/f?href=https://facebook.com/emo.darkvampir3");
                        } catch(PackageManager.NameNotFoundException e){
                            my_facebook = Uri.parse("https://facebook.com/emo.darkvampir3");
                        }
                        Intent i = new Intent(Intent.ACTION_VIEW,my_facebook);
                        startActivity(i);
                        return true;
                    }
                });
            }
            if (email != null) {
                email.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
                    @Override
                    public boolean onPreferenceClick(Preference preference) {
                        String[] emailadress = {"shahnawaz@z3ro.xyz"};
                        final Intent emailIntent = new Intent(Intent.ACTION_SEND);
                        emailIntent.setType("plain/text");
                        emailIntent.putExtra(Intent.EXTRA_EMAIL,emailadress);
                        startActivity(emailIntent);
                        return true;
                    }
                });
            }
            if (telegram != null) {
                telegram.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
                    @Override
                    public boolean onPreferenceClick(Preference preference) {
                        Uri my_telegram = Uri.parse("https://t.me/ab5olute_zero");
                        Intent t = new Intent(Intent.ACTION_VIEW,my_telegram);
                        startActivity(t);
                        return true;
                    }
                });
            }

            setHasOptionsMenu(true);
        }
    }
}
