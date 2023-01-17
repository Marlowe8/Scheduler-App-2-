package com.example.assessment2app2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item_add.*

class Schedulerpage : AppCompatActivity() {
    //Data Grp
    private lateinit var Add_btn: FloatingActionButton
    private lateinit var Displaylist: RecyclerView
    private lateinit var itemList: ArrayList<ItemHolder>
    private lateinit var itemAdapter: ItemAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_menu)

        val actionbar = supportActionBar
        actionbar!!.title = "Schedule"
        actionbar.setDisplayHomeAsUpEnabled(true)


        //list
        itemList = ArrayList()
        //initializing grp
        Add_btn = findViewById(R.id.itemAdd_btn)
        Displaylist = findViewById(R.id.Main_rv)
        itemAdapter = ItemAdapter(this, itemList)

        Displaylist.layoutManager = LinearLayoutManager(this)
        Displaylist.adapter = itemAdapter
        //Dialog
        Add_btn.setOnClickListener { addItem() }

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    private fun addItem(){
        val inflater = LayoutInflater.from(this)
        val view = inflater.inflate(R.layout.item_add,null)
        val name = view.findViewById<EditText>(R.id.firstInput_et)
        val time = view.findViewById<EditText>(R.id.secondInput_et)
        //Dialog grp
        val addDialog = AlertDialog.Builder(this)
        addDialog.setView(view)
        addDialog.setPositiveButton("Confirm"){
                dialog,_->
            //user input & Storing
            val name = name.text.toString()
            val time = time.text.toString()

            itemList.add(ItemHolder("Name: $name", "Time: $time"))
            itemAdapter.notifyDataSetChanged()
            Toast.makeText(this,"Adding info success",Toast.LENGTH_SHORT).show()
            dialog.dismiss()
        }
        addDialog.setNegativeButton("Cancel"){
                dialog,_->
            dialog.dismiss()
            Toast.makeText(this,"Cancelled",Toast.LENGTH_SHORT).show()
        }
        addDialog.create()
        addDialog.show()


    }

}