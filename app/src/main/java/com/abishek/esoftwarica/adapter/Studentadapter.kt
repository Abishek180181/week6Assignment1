package com.abishek.esoftwarica.adapter

import android.app.Dialog
import android.content.Context
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import com.abishek.esoftwarica.R
import com.abishek.esoftwarica.lstStudents
import com.abishek.esoftwarica.model.Studentmodel
import com.bumptech.glide.Glide

class Studentadapter (val context: Context?, val listStudent:ArrayList<Studentmodel>):RecyclerView.Adapter<Studentadapter.StudentHolder>(){

    class StudentHolder(v:View):RecyclerView.ViewHolder(v)
    {
        var cvDp : ImageView
        var tvName : TextView
        var tvAge : TextView
        var tvAdr : TextView
        var tvGender : TextView
        var ivDelete : ImageView
        var ivUpdate : ImageView

        init {
            cvDp =v.findViewById(R.id.cvDp)
            tvName = v.findViewById(R.id.tvName)
            tvAge = v.findViewById(R.id.tvAge)
            tvAdr = v.findViewById(R.id.tvAdr)
            tvGender = v.findViewById(R.id.tvGender)
            ivDelete = v.findViewById(R.id.ivDelete)
            ivUpdate = v.findViewById(R.id.ivUpdate)

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.studentlist,parent,false)
        return  StudentHolder(view)
    }

    override fun getItemCount(): Int {
        return  listStudent.size
    }

    override fun onBindViewHolder(holder: StudentHolder, position: Int) {
        val data = listStudent[position]
        holder.tvName.text = data.name
        holder.tvAge.text = data.age.toString()
        holder.tvAdr.text = data.address
        holder.tvGender.text = data.gender
        Glide.with(context!!).load(data.display).into(holder.cvDp)


        holder.ivDelete.setOnClickListener {
            lstStudents.removeAt(position)
            notifyDataSetChanged()
        }

        val dialog = Dialog(context)
        dialog.setContentView(R.layout.update)
        dialog.window!!.setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT)
        dialog.setCancelable(false)
        var etFn : EditText = dialog.findViewById(R.id.etFn)
        var etAge : EditText = dialog.findViewById(R.id.etAge)
        var etAddress : EditText = dialog.findViewById(R.id.etAddress)
        var etprofile : EditText = dialog.findViewById(R.id.etprofile)
        var radioGroup : RadioGroup = dialog.findViewById(R.id.radioGroup)
        var gender = "Male"
        var btnUpdate : Button = dialog.findViewById(R.id.btnUpdate)
        var btnCancel : Button = dialog.findViewById(R.id.btnCancel)

        holder.ivUpdate.setOnClickListener {
            etFn.setText(data.name)
            etAge.setText(data.age.toString())
            etAddress.setText(data.address)
            etprofile.setText(data.display)
            when(data.gender)
            {
                "Male" -> radioGroup.check(R.id.rbMale)
                "Female" -> radioGroup.check(R.id.rbFemale)
                "Others" -> radioGroup.check(R.id.rbOther)
            }
            dialog.show()
        }

        radioGroup.setOnCheckedChangeListener { group, checkedId ->
            when(checkedId)
            {
                R.id.rbMale ->{
                    gender = "Male"
                }
                R.id.rbFemale ->{
                    gender = "Female"
                }
                R.id.rbOther ->{
                    gender = "Others"
                }
            }
        }
        btnUpdate.setOnClickListener {
            if(TextUtils.isEmpty(etFn.text))
            {
                etFn.error = "Enter Firstname"
                etFn.requestFocus()
            }
            else if(TextUtils.isEmpty(etAge.text))
            {
                etAge.error = "Enter Age"
                etAge.requestFocus()
            }
            else if(TextUtils.isEmpty(etAddress.text))
            {
                etAddress.error = "Enter Address"
                etAddress.requestFocus()
            }
            else if(TextUtils.isEmpty(etprofile.text))
            {
                etprofile.error = "Enter Profile image"
                etprofile.requestFocus()
            }
            else
            {
                lstStudents[position].name = etFn.text.toString()
                lstStudents[position].address = etAddress.text.toString()
                lstStudents[position].display = etprofile.text.toString()
                lstStudents[position].age = etAge.text.toString().toInt()
                lstStudents[position].gender = gender
                notifyDataSetChanged()
                dialog.cancel()
            }
        }
        btnCancel.setOnClickListener {
            dialog.cancel()
        }





        
    }
}