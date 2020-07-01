package com.example.moneyup

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.components.Legend
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry


class OverviewActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_overview)

        supportActionBar?.hide()

        val pieChart = findViewById<PieChart>(R.id.pieChart)
        var expenses = 0



        var sampleRecyclerList = arrayListOf<CategoryItem>()
        //val categoryItem = CategoryItem("red","sda","asdas",123,"askjdal")
        sampleRecyclerList.add(CategoryItem("#25BD37","ic_shopping_basket","Shopping",250,"Some note"))
        sampleRecyclerList.add(CategoryItem("#2562BD","ic_person_outline","Leisure",75,"Some note"))
        sampleRecyclerList.add(CategoryItem("#2562BD","ic_lock_outline","Bills",111,"Some note"))
        sampleRecyclerList.add(CategoryItem("#25BD37","ic_shopping_basket","Vacation",444,"Some note"))

        var colorsArr = IntArray(sampleRecyclerList.size)
        var savedColorsArr = intArrayOf(R.color.colorAlt,R.color.colorMain)
        viewManager = LinearLayoutManager(this)
        viewAdapter = MyAdapter(sampleRecyclerList)

        recyclerView = findViewById<RecyclerView>(R.id.recyclerView).apply {
            // use this setting to improve performance if you know that changes
            // in content do not change the layout size of the RecyclerView
            setHasFixedSize(true)

            // use a linear layout manager
            layoutManager = viewManager

            // specify an viewAdapter (see also next example)
            adapter = viewAdapter

        }

        var pieList = arrayListOf<PieEntry>()
        for(x in 0 until sampleRecyclerList.size){
            var colorToAdd = 0
            pieList.add(PieEntry(sampleRecyclerList.get(x).mSum.toFloat(),sampleRecyclerList.get(x).mTitle))
            expenses += sampleRecyclerList.get(x).mSum
            var colorFromCategories = sampleRecyclerList.get(x).mColor
            var colorFromCatTrimmed = colorFromCategories.toLowerCase().replace("#","").trim()
            for(x in savedColorsArr.indices) {
                var colorConverted = resources.getString(savedColorsArr[x]).substring(3,resources.getString(R.color.colorAlt.toString().toInt()).length)
                if(colorFromCatTrimmed.equals(colorConverted)){
                    colorToAdd = savedColorsArr[x]
                } else {
                    continue
                }
            }

            colorsArr[x] = colorToAdd
        }
        var colorRes: String = resources.getString(R.color.colorAlt.toString().toInt()).substring(3,resources.getString(R.color.colorAlt.toString().toInt()).toString().length)
        var colorTrim: String = "#25BD37".toLowerCase().replace("#","").trim()
        println("COLOR RES " + colorRes)
        println("COLOR TRIMMED " + colorTrim)
        println("Equal: " + colorRes.equals(colorTrim))


        val pieDataSet = PieDataSet(pieList, "pieList")
        pieDataSet.setColors(colorsArr,this)
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
    }
}
