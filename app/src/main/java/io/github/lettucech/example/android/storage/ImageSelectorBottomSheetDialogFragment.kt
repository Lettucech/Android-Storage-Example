package io.github.lettucech.example.android.storage

import android.graphics.Rect
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.fragment_file_selector_bottom_sheet_dialog.*

/**
 * Created by Brian Ho on 2019-05-24.
 */
class ImageSelectorBottomSheetDialogFragment : BottomSheetDialogFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_file_selector_bottom_sheet_dialog, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView.adapter = object : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

            override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
                var imageView = ImageView(parent.context)
                imageView.scaleType = ImageView.ScaleType.CENTER_INSIDE
                imageView.adjustViewBounds = true
                imageView.layoutParams = RecyclerView.LayoutParams(
                    RecyclerView.LayoutParams.WRAP_CONTENT,
                    RecyclerView.LayoutParams.MATCH_PARENT
                )
                return object : RecyclerView.ViewHolder(imageView) {}
            }

            override fun getItemCount(): Int = IMAGES.size


            override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
                (holder.itemView as ImageView).setImageResource(IMAGES[position])
            }

        }

        recyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

        recyclerView.addItemDecoration(object : RecyclerView.ItemDecoration() {
            override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
                val padding = (resources.displayMetrics.density * 8).toInt()
                outRect.top = padding
                outRect.bottom = padding
                outRect.left = if (parent.getChildAdapterPosition(view) == 0) padding else padding / 2
                outRect.right =
                    if (parent.getChildAdapterPosition(view) == parent.adapter?.itemCount?.minus(1) ) padding else padding / 2
            }
        })
    }

    companion object {
        const val TAG = "ImageSelectorBottomSheetDialogFragment"
        val IMAGES = intArrayOf(
            R.drawable.image_1,
            R.drawable.image_2,
            R.drawable.image_3,
            R.drawable.image_4,
            R.drawable.image_5
        )
    }
}