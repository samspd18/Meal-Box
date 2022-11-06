package com.satya.mealbox.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.satya.mealbox.databinding.InstructionLayoutBinding
import com.satya.mealbox.model.recipiesDetail.Step

class InstructionAdapter : RecyclerView.Adapter<InstructionAdapter.ViewHolder>()  {

    private var recipesInstruction = mutableListOf<Step>()

    fun setRecipesInstructions(recipesInstruction: List<Step>) {
        this.recipesInstruction = recipesInstruction.toMutableList()
        notifyDataSetChanged()
    }

    class ViewHolder(var binding: InstructionLayoutBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = InstructionLayoutBinding.inflate(inflater,parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val recipesInstructionData = recipesInstruction[position]
        "Step - ${recipesInstructionData.number.toString()}".also { holder.binding.tvInstructionStep.text = it }
        holder.binding.tvInstructionDetail.text = recipesInstructionData.step

    }

    override fun getItemCount(): Int {
        return recipesInstruction.count()
    }
}