package com.example.aanpc.cobasubmit2.util
import android.view.View
import java.text.SimpleDateFormat
import java.util.*

fun View.visible() {
    visibility = View.VISIBLE
}

fun View.invisible() {
    visibility = View.INVISIBLE
}

fun View.gone() {
    visibility = View.GONE
}

fun formatDate(sDate: String): String {
    val formatter = SimpleDateFormat("yyyy-MM-dd")
    var formatter2 = SimpleDateFormat("EEE, dd MMM yyyy")
    val date: Date = formatter.parse(sDate);
    return formatter2.format(date)
}