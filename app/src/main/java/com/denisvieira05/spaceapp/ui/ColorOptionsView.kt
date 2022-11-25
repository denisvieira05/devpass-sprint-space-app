package com.denisvieira05.spaceapp.ui

import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout
import androidx.annotation.ColorRes
import androidx.core.content.ContextCompat
import com.denisvieira05.spaceapp.R
import com.denisvieira05.spaceapp.databinding.ColorOptionsViewBinding


class ColorOptionsView @JvmOverloads constructor(
    context: Context,
    private val attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    private val binding by lazy {
        ColorOptionsViewBinding.bind(this)
    }

    init {
        inflate(context, R.layout.color_options_view, this)

        layoutParams = LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT)
        orientation = HORIZONTAL

        setCustomAttributes()
    }

    fun onBoxClick(text: String, event: () -> Unit) {
        binding.mainSquare.setOnClickListener { event() }
    }

    fun setColorBox(@ColorRes color: Int) {
        binding.mainSquare.setBackgroundColor(ContextCompat.getColor(context, color))
    }

    private fun setCustomAttributes() {
        val customAttrs = context.obtainStyledAttributes(
            attrs,
            R.styleable.ColorOptionsView,
        )

        val title = customAttrs.getString(R.styleable.ColorOptionsView_titleText)
//        val state = customAttrs.getValue(R.styleable.ColorOptionsView_state)
        val color = customAttrs.getColor(
            R.styleable.ColorOptionsView_colorValue,
            ContextCompat.getColor(context, R.color.purple_200)
        )

//        setState(state)

        customAttrs.recycle()

        binding.mainTitle.text = title
        binding.mainSquare.setBackgroundColor(color)
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()

    }
}