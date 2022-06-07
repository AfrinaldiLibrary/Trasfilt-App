package com.example.trafilt.activity.customview

import android.content.Context
import android.graphics.Canvas
import android.text.method.PasswordTransformationMethod
import android.util.AttributeSet
import android.view.View
import androidx.appcompat.widget.AppCompatEditText
import com.example.trafilt.R

class PasswordEditText : AppCompatEditText, View.OnFocusChangeListener {
    constructor(context: Context) : super(context) {
        init()
    }
    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init()
    }
    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        init()
    }

    private fun init(){
        onFocusChangeListener = this
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        hint = context.getString(R.string.password)
        transformationMethod = PasswordTransformationMethod.getInstance()
    }

    override fun onFocusChange(v: View?, hasFocus: Boolean) {
        if (!hasFocus){
            if (!text.isNullOrEmpty() && text!!.length < 8){
                error = context.getString(R.string.invalid_password)
            }
        }
    }
}