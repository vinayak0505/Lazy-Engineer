package com.example.lazy_engineer.ui.main

import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.res.ResourcesCompat
import androidx.databinding.BindingAdapter
import org.w3c.dom.Text

// TextView
@BindingAdapter("text_from_resource")
fun TextView.getText(stringId: Int) {
    text = resources.getString(stringId)
}

@BindingAdapter("string_from_int")
fun TextView.getString(value: Int) {
    text = value.toString()
}


// ImageView
@BindingAdapter("image_from_resource")
fun ImageView.getImageFromResource(drawableId: Int) {
    setImageDrawable(ResourcesCompat.getDrawable(resources, drawableId, context.theme))
}
