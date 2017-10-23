package com.svp.infrastructure


import android.content.Context
import android.content.DialogInterface
import android.support.v7.app.AlertDialog

class AlertDialogManager {
    /**
     * Function to display simple Alert Dialog
     * @param context - application context
     * @param title - alert dialog title
     * @param message - alert message
     * @param status - success/failure (used to set icon)
     * - pass null if you don't want icon
     */
    fun showAlertDialog(context: Context, title: String, message: String,
                        status: Boolean?) {
        val alertDialog = AlertDialog.Builder(context).create()

        // Setting Dialog Title
        alertDialog.setTitle(title)

        // Setting Dialog Message
        alertDialog.setMessage(message)

        if (status != null)
        // Setting alert dialog icon
        // alertDialog.setIcon((status) ? R.drawable.success : R.drawable.fail);

        // Setting OK Button
        //        alertDialog.setButton("OK", title, new DialogInterface.OnClickListener() {
        //            @Override
        //            public void onClick(DialogInterface dialog, int which) {
        //
        //            }
        //        });

        // Showing Alert Message
            alertDialog.show()
    }
}
