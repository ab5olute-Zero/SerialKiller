package xyz.z3ro.serialkiller;

import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;

public class CreditsFragment extends DialogFragment {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), R.style.AppCompatAlertDialogStyle);
        builder.setIcon(R.drawable.ic_info_white_24dp);
        builder.setTitle("Credits");
        builder.setMessage(R.string.credits_message);
        builder.setPositiveButton(R.string.dialog_okay,null);
        builder.create();
        return builder.create();
    }
}
