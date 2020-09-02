package com.example.moneyup.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.moneyup.data.CategoryItem
import com.example.moneyup.R
import com.example.moneyup.adapter.MyAdapter
import com.example.moneyup.ui.WrapperActivity
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.components.Legend
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import java.util.*

class OverviewFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val rootView: View =  inflater.inflate(R.layout.fragment_overview, container, false)

        val wrapperActivity: WrapperActivity = activity as WrapperActivity

        wrapperActivity.bottomNav.menu.getItem(1).isChecked = true

        val pieChart = rootView.findViewById<PieChart>(R.id.pieChart)
        var expenses = 0



        val sampleRecyclerList = arrayListOf<CategoryItem>()
        //val categoryItem = CategoryItem("red","sda","asdas",123,"askjdal")
        sampleRecyclerList.add(
            CategoryItem(
                "#25BD37",
                "ic_shopping_basket",
                "Shopping",
                110,
                "Some note"
            )
        )
        sampleRecyclerList.add(
            CategoryItem(
                "#2562BD",
                "ic_movie_filter",
                "Leisure",
                0,
                "Some note"
            )
        )
        sampleRecyclerList.add(
            CategoryItem(
                "#BD258A",
                "ic_shopping_cart",
                "Groceries",
                0,
                "Some note"
            )
        )
        sampleRecyclerList.add(
            CategoryItem(
                "#BD9725",
                "ic_restaurant",
                "Restaurant",
                0,
                "Some note"
            )
        )
        sampleRecyclerList.add(
            CategoryItem(
                "#B8BD25",
                "ic_card_giftcard",
                "Gifts",
                0,
                "Some note"
            )
        )
        sampleRecyclerList.add(
            CategoryItem(
                "#BD2553",
                "ic_people_outline",
                "Family",
                0,
                "Some note"
            )
        )
        sampleRecyclerList.add(
            CategoryItem(
                "#6725BD",
                "ic_beach_access",
                "Vacation",
                0,
                "Some note"
            )
        )

        val colorsArr = IntArray(sampleRecyclerList.size)
        val defColorsArr = IntArray(1)
        defColorsArr[0] = R.color.colorDefaultSlice
        val savedColorsArr = intArrayOf(
            R.color.colorAlt,
            R.color.colorMain,
            R.color.colorCategoryOne,
            R.color.colorCategoryTwo,
            R.color.colorCategoryThree,
            R.color.colorCategoryFour,
            R.color.colorCategoryFive,
            R.color.colorCategorySix
        )
        viewManager = LinearLayoutManager(context)
        viewAdapter = MyAdapter(sampleRecyclerList)

        recyclerView = rootView.findViewById<RecyclerView>(R.id.recyclerView).apply {
            // use this setting to improve performance if you know that changes
            // in content do not change the layout size of the RecyclerView
            setHasFixedSize(true)

            // use a linear layout manager
            layoutManager = viewManager

            // specify an viewAdapter (see also next example)
            adapter = viewAdapter

        }

        val pieList = arrayListOf<PieEntry>()
        for(x in 0 until sampleRecyclerList.size){
            var colorToAdd = 0
            pieList.add(PieEntry(sampleRecyclerList[x].mSum.toFloat(), sampleRecyclerList[x].mTitle))
            expenses += sampleRecyclerList[x].mSum
            val colorFromCategories = sampleRecyclerList[x].mColor
            val colorFromCatTrimmed = colorFromCategories.toLowerCase().replace("#","").trim()
            for(x in savedColorsArr.indices) {
                val colorConverted = resources.getString(savedColorsArr[x]).substring(3,resources.getString(
                    R.color.colorAlt.toString().toInt()).length)
                if(colorFromCatTrimmed == colorConverted){
                    colorToAdd = savedColorsArr[x]
                } else {
                    continue
                }
            }

            colorsArr[x] = colorToAdd
        }
        val colorRes: String = resources.getString(R.color.colorAlt.toString().toInt()).substring(3,resources.getString(
            R.color.colorAlt.toString().toInt()).length)
        val colorTrim: String = "#25BD37".toLowerCase(Locale.ROOT).replace("#","").trim()
        println("COLOR RES $colorRes")
        println("COLOR TRIMMED $colorTrim")
        println("Equal: " + (colorRes == colorTrim))


        val pieDataSet = PieDataSet(pieList, "pieList")

        pieDataSet.setColors(colorsArr,context)

        pieDataSet.valueTextSize = 16f
        pieDataSet.sliceSpace = 2f

        val pieData = PieData(pieDataSet)

        pieChart.data = pieData

        pieChart.setDrawEntryLabels(false)
        pieChart.description.isEnabled = false
        pieChart.centerText = "Expenses " + "\n" +
                "$expenses"

        pieChart.setCenterTextSize(20f)

        val overviewPieLegend: Legend = pieChart.legend
        overviewPieLegend.isEnabled = false
        //overviewPieLegend.setDrawInside(false)

        pieChart.animate()


        return rootView
    }
}