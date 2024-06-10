package com.example.mynewsblog.ui

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewSpacingItems(private val verticalSpaceHeight: Int) : RecyclerView.ItemDecoration() {
    override fun getItemOffsets(outRect: Rect,view: View,parent: RecyclerView,state: RecyclerView.State) {
        outRect.bottom = verticalSpaceHeight
    }
}