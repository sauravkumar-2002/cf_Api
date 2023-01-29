package com.example.cf_prob.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cf_prob.R
import com.example.cf_prob.Model_classes.problems


class Adapter() : RecyclerView.Adapter<Adapter.ViewHolder>() {
     var prob_list= mutableListOf<problems>()
    fun setProblems(prob_list: List<problems>){
        this.prob_list= prob_list as MutableList<problems>
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val prob_name: TextView = itemView.findViewById(R.id.name);
        val rating: TextView = itemView.findViewById(R.id.rating);
        val contest: TextView = itemView.findViewById(R.id.contest_id);
        val tags: TextView = itemView.findViewById(R.id.tags);
        //val index: TextView = itemView.findViewById(R.id.index);
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context);
        val view = inflater.inflate(R.layout.list_item, parent, false);
        return (ViewHolder(view))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        //holder.index.text =
        holder.contest.text = "Contest:"+ prob_list.get(position).contestId.toString()
        holder.rating.text = "Rating:"+ prob_list.get(position).rating.toString()
        holder.prob_name.text = prob_list.get(position).index +". "+ (prob_list.get(position).name)
        var arr:List<String>?
        var tag:String="Use-> "
     /*arr= prob_list.get(position).tags
        if (arr != null) {
            for(i in 0..arr.size-1){
               tag=tag+arr[i]+","
                if(i%3==2)tag=tag+"\n"
            }
        }
        holder.tags.text=tag


      */

    }

    override fun getItemCount(): Int {

        return prob_list.size;
    }
}