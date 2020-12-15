package io.github.ugwulo.ussd_codes.util

import android.app.Activity
import android.content.Context
import android.view.inputmethod.InputMethodManager

class Utils {

    /**
     * function for closing android's virtual keyboard
     */
    fun hideSoftKeyboard(activity: Activity) {
        val inputMethodManager = activity.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        val currentFocusedView = activity.currentFocus
        currentFocusedView?.let {
            inputMethodManager.hideSoftInputFromWindow(currentFocusedView.windowToken, InputMethodManager.HIDE_NOT_ALWAYS)
        }
    }
}