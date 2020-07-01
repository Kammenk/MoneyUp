package com.example.moneyup

/*
CategoryItem is the blueprint for all categories that are created and exist on the overview/home fragment
*/

class CategoryItem {

    var mColor: String = "@color/colorAlt"
        get() = field
        set(value) {
            field = value
        }
    var mImage: String = "@drawable/ic_shopping_basket"
        get() = field
        set(value) {
            field = value
        }
    var mTitle: String = "Shopping"
        get() = field
        set(value) {
            field = value
        }
    var mSum: Int = 350
        get() = field
        set(value) {
            field = value
        }
    var mNote: String = ""
        get() = field
        set(value) {
            field = value
        }

    constructor(color: String, icon: String,title: String,sum: Int,note: String){
        mColor = color
        mImage = icon
        mTitle = title
        mSum = sum
        mNote = note
    }


}