package com.example.moneyup

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.utils.ColorTemplate

class OverviewActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_overview)

        supportActionBar?.hide()

        val pieChart = findViewById<PieChart>(R.id.pieChart)

        var pieList = arrayListOf<PieEntry>()
        pieList.add(PieEntry(200f, "2016"))
        pieList.add(PieEntry(100f, "2017"))
        pieList.add(PieEntry(300f, "2018"))
        pieList.add(PieEntry(430f, "2019"))
        pieList.add(PieEntry(230f, "2020"))


        val pieDataSet = PieDataSet(pieList, "pieList")
        pieDataSet.colors = ColorTemplate.COLORFUL_COLORS.toMutableList()
        pieDataSet.valueTextSize = 16f

        val pieData = PieData(pieDataSet)

        pieChart.data = pieData
        pieChart.description.isEnabled = true
        pieChart.centerText = "This month's overview"
        pieChart.setCenterTextSize(20f)
        pieChart.animate()

        var sampleRecyclerList = arrayOf<String>("Transport","Leisure","Groceries","Bills","Sport")

//        sampleRecyclerList.add("Transport")
//        sampleRecyclerList.add("Leisure")
//        sampleRecyclerList.add("Groceries")
//        sampleRecyclerList.add("Bills")
//        sampleRecyclerList.add("Sport")


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
    }
}
