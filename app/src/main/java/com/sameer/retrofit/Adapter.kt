package com.sameer.retrofit

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class Adapter(val list:ArrayList<MyDataItem>,val context: Context):RecyclerView.Adapter<
        ViewHolder>()
{


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.quiz_layout,parent,false))
    }

    override fun getItemCount(): Int {
        println("listing from adapter size"+list.size)
        return list.size;
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.ques.text = list.get(position).question
        holder.op1.text = list.get(position).answers.answer_a
        holder.op2.text = list.get(position).answers.answer_b
        holder.op3.text = list.get(position).answers.answer_c
        holder.op4.text = list.get(position).answers.answer_d


    }

}
class ViewHolder (view: View) : RecyclerView.ViewHolder(view) {

  var ques = view.findViewById<TextView>(R.id.ques)
    val op1 = view.findViewById<CheckBox>(R.id.opt1)
    val op2 = view.findViewById<CheckBox>(R.id.opt2)
    val op3 = view.findViewById<CheckBox>(R.id.opt3)
    val op4 = view.findViewById<CheckBox>(R.id.opt4)
    // Holds the TextView that will add each animal to


}