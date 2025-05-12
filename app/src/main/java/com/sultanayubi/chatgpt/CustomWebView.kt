package com.sultanayubi.chatgpt

import android.content.Context
import android.util.AttributeSet
import android.view.KeyEvent
import android.view.MotionEvent
import android.view.inputmethod.BaseInputConnection
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputConnection
import android.webkit.WebView


class CustomWebView(context: Context, attrs: AttributeSet?) : WebView(context, attrs) {
    var loggedIn : Boolean = false

    override fun onCreateInputConnection(outAttrs: EditorInfo): InputConnection {
        val inputConnection = super.onCreateInputConnection(outAttrs)
        if (!loggedIn || inputConnection == null) {
            return BaseInputConnection(this, false)
        }

        outAttrs.inputType = EditorInfo.TYPE_TEXT_VARIATION_SHORT_MESSAGE
        outAttrs.imeOptions = EditorInfo.IME_ACTION_GO

        return inputConnection
    }

    override fun dispatchKeyEvent(event: KeyEvent): Boolean {
        val dispatchFirst = super.dispatchKeyEvent(event)
        // Listening here for whatever key events you need
        if (event.getAction() === KeyEvent.ACTION_UP) when (event.getKeyCode()) {
            KeyEvent.KEYCODE_SPACE, KeyEvent.KEYCODE_ENTER -> {

            }
        }
        return dispatchFirst
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        requestDisallowInterceptTouchEvent(true)
        return super.onTouchEvent(event)
    }

    override fun onCheckIsTextEditor(): Boolean {
        return true
    }

}