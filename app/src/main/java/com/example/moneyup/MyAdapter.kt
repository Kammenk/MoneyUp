package com.example.moneyup

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.text.Editable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(private val myDataset: ArrayList<CategoryItem>): RecyclerView.Adapter<MyAdapter.ViewHolder>() {

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder.
    // Each data item is just a string in this case that is shown in a TextView.
//    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//        lateinit var mItemColor: CardView
//        lateinit var mItemIcon: String
//        lateinit var mItemTitle: String
//        var mItemSum: Int = 0
//        lateinit var mItemNote: String
//
//
//
//    }

    class ViewHolder internal constructor(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        var mItemColor: CardView
        var mItemIcon: ImageView
        var mItemTitle: TextView
        var mItemSum: TextView
        var mItemNote: EditText


        init {
            mItemColor = itemView.findViewById(R.id.budgetCardBackgroundColor)
            mItemIcon = itemView.findViewById(R.id.budgetIcon)
            mItemTitle = itemView.findViewById(R.id.budgetCategoryTitle)
            mItemSum = itemView.findViewById(R.id.budgetSum)
            mItemNote = itemView.findViewById(R.id.budgetNote)

        }
    }


    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter.ViewHolder {
        // create a new view
        val textView = LayoutInflater.from(parent.context)
            .inflate(R.layout.budget_list_item, parent, false) as LinearLayout
        // set the view's size, margins, paddings and layout parameters

        return ViewHolder(textView)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element

        var currentItem: CategoryItem = myDataset.get(position)

        var mItemColor: String = currentItem.mColor
        //var colorInt:Int = holder.mItemColor.context.resources.getColor(mItemColor.toInt())
        var mItemIcon: String = currentItem.mImage
        var context: Context = holder.mItemIcon.context
        var id:Int = context.resources.getIdentifier(mItemIcon,"drawable",context.packageName)
        var mItemTitle: String = currentItem.mTitle
        var mItemSum: Int = currentItem.mSum
        var mItemNote: String = currentItem.mNote

        holder.mItemColor.setCardBackgroundColor(Color.parseColor(mItemColor))
        holder.mItemIcon.setBackgroundResource(id)
        holder.mItemTitle.text = mItemTitle
        holder.mItemSum.text = mItemSum.toString()


    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = myDataset.size
}