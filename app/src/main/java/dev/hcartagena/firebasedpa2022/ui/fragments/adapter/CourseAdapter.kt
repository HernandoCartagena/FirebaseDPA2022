package dev.hcartagena.firebasedpa2022.ui.fragments.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import dev.hcartagena.firebasedpa2022.R
import dev.hcartagena.firebasedpa2022.ui.fragments.model.CourseModel

class CourseAdapter(private var lstCourse: List<CourseModel>)
    : RecyclerView.Adapter<CourseAdapter.ViewHolder>(){
    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val tvCourse: TextView = itemView.findViewById(R.id.tvCourse)
        val tvScore: TextView = itemView.findViewById(R.id.tvScore)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(layoutInflater.inflate(R.layout.item_course, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val itemCourse = lstCourse[position]
        holder.tvCourse.text = itemCourse.description
        holder.tvScore.text = itemCourse.score
    }

    override fun getItemCount(): Int {
        return lstCourse.size
    }
}