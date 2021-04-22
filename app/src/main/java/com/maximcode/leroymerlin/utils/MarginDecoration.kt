package com.maximcode.leroymerlin.utils

import android.content.Context
import android.graphics.Rect
import android.util.DisplayMetrics
import android.util.TypedValue
import android.view.View
import androidx.recyclerview.widget.RecyclerView

fun interface MarginStrategy {
    fun applyMargins(margin: Int, position: Int, lastPosition: Int, viewItem: Rect)
}

class HorizontalMarginStrategy: MarginStrategy {
    override fun applyMargins(margin: Int, position: Int, lastPosition: Int, viewItem: Rect) {
        when (position) {
            0 -> {
                viewItem.left = margin * 2
                viewItem.right = margin
            }
            lastPosition -> {
                viewItem.left = margin
                viewItem.right = margin * 2
            }
            else -> {
                viewItem.left = margin
                viewItem.right = margin
            }
        }
    }
}

class MarginDecoration(
    private val context: Context,
    private val margin: Int,
    private val strategy: MarginStrategy = HorizontalMarginStrategy()
): RecyclerView.ItemDecoration() {

    override fun getItemOffsets(
        outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        super.getItemOffsets(outRect, view, parent, state)
        val position = parent.getChildAdapterPosition(view)

        if(position.hasItemPositionInAdapter()) {
            val metrics: DisplayMetrics = context.resources.displayMetrics
            strategy.applyMargins(margin.applyDimension(metrics), position,
                state.itemCount - 1, outRect)
        }
    }

    private fun Int.hasItemPositionInAdapter() = this != RecyclerView.NO_POSITION

    private fun Int.applyDimension(metrics: DisplayMetrics) =
        TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, this.toFloat(), metrics).toInt()
}
