package com.example.assessment2app2

import android.app.AlertDialog
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView

class ItemAdapter (val context: Context, val itemList:ArrayList<ItemHolder>): RecyclerView.Adapter<ItemAdapter.itemViewHolder>() {
    inner class itemViewHolder(val view: View):RecyclerView.ViewHolder(view){
        val name = view.findViewById<TextView>(R.id.Title_tv)
        val content = view.findViewById<TextView>(R.id.Content_tv)
        var menu:ImageView

      //first to be executed
        init {
            menu = view.findViewById<ImageView>(R.id.Menu_iv)
            menu.setOnClickListener { popupMenu(it) }
        }

        private fun popupMenu(view:View){
            val position = itemList[adapterPosition]
            val popupMenu = PopupMenu(context,view)
            //popup Menu Display Settings grp
            popupMenu.inflate(R.menu.show_menu)
            popupMenu.setOnMenuItemClickListener {
                when(it.itemId){
                   /* R.id.editText-> {
                        val view = LayoutInflater.from(context).inflate(R.layout.item_add, null)
                        val name = view.findViewById<EditText>(R.id.firstInput_et)
                        val time = view.findViewById<EditText>(R.id.secondInput_et)
                        AlertDialog.Builder(context)
                            .setView(view)
                            .setPositiveButton("Ok") { dialog, _ ->
                                position.name = name.text.toString()
                                position.content = time.text.toString()
                                notifyDataSetChanged()
                                Toast.makeText(context, "User Information is Edited", Toast.LENGTH_SHORT)
                                    .show()
                                dialog.dismiss()

                            }
                            .setNegativeButton("Cancel") { dialog, _ ->
                                dialog.dismiss()

                            }
                            .create()
                            .show()

                        true
                    }

                    */
                    //Delete item grp
                    R.id.delete->{
                        AlertDialog.Builder(context)
                            .setTitle("Delete")
                            .setIcon(R.drawable.ic_baseline_warning_24)
                            .setMessage("Delete this item?")
                            .setPositiveButton("Yes"){
                                dialog,_->
                                itemList.removeAt(adapterPosition)
                                notifyDataSetChanged()
                                Toast.makeText(context, "Deleted",Toast.LENGTH_SHORT).show()
                                dialog.dismiss()
                            }
                            .setNegativeButton("No"){
                                dialog,_->
                                dialog.dismiss()
                            }
                            .create()
                            .show()
                        true
                    }
                    else->true
                }
            }
            popupMenu.show()
            val ShowPopup =PopupMenu::class.java.getDeclaredField("mPopup")
            ShowPopup.isAccessible =true
            val MenuPopup =ShowPopup.get(popupMenu)
            MenuPopup.javaClass.getDeclaredMethod("setForceShowIcon", Boolean::class.java)
                .invoke(MenuPopup,true)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): itemViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val _view = inflater.inflate(R.layout.list_rv,parent,false)
        return itemViewHolder(_view)
    }

    override fun onBindViewHolder(holder: itemViewHolder, position: Int) {
        val newItemList = itemList[position]
        holder.name.text = newItemList.name
        holder.content.text = newItemList.content
    }

    override fun getItemCount(): Int {
        return itemList.size
    }
}