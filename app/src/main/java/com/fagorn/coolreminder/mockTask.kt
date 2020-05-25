package com.fagorn.coolreminder

import com.fagorn.coolreminder.Model.DateSubmit
import com.fagorn.coolreminder.Model.ItemModel
import com.fagorn.coolreminder.Model.TimeSubmit


/** Code passion <3

Created By Fahreddin GÖLCÜK

Fahreddingolcuk@gmail.com

(((   24/05/2020 - 3:21 AM   )))

 **/
val model1 : MutableList<ItemModel> = mutableListOf()

fun addNewItem(Task: ItemModel){
    model1.add(Task)
}

fun getTasks(): MutableList<ItemModel> {
    return model1
}