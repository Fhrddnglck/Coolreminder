package com.fagorn.coolreminder

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.fagorn.coolreminder.Adapters.AdapterItem
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerView.adapter = AdapterItem(getTasks())
        recyclerView.apply {
            setHasFixedSize(true)
            adapter = AdapterItem(model1)
            addItemDecoration(DividerItemDecoration(this.context,DividerItemDecoration.VERTICAL))
        }
        addButton.setOnClickListener {
            val intent = Intent(this,RecordActivity::class.java).apply {
                putExtra("selam","selam")
            }
            startActivity(intent)
        }
        CountShow()
        val itemTouchHelperCallBack = object : ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT){
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                AdapterItem(getTasks()).removeItem(viewHolder)
                CountShow()
            }
        }
        val itemTouchHelper = ItemTouchHelper(itemTouchHelperCallBack)
        itemTouchHelper.attachToRecyclerView(recyclerView)
    }
    private fun CountShow(){
        BookCount.text = "You have a ${AdapterItem(getTasks()).itemCount.toString()} books"
    }
}
