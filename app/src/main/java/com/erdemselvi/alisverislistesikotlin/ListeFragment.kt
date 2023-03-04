package com.erdemselvi.alisverislistesikotlin

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.database.sqlite.SQLiteDatabase.openOrCreateDatabase
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import java.lang.Exception


class ListeFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_liste, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sqlVeriAl()
    }

    @SuppressLint("UseRequireInsteadOfGet")
    private fun sqlVeriAl() {
        try{

            activity?.let {
                val database=activity!!.openOrCreateDatabase("Urunler",Context.MODE_PRIVATE,null)

                val cursor=database.rawQuery("SELECT * FROM urunler",null)
                val isimIndex=cursor.getColumnIndex("urunIsmi")
                val idIndex=cursor.getColumnIndex("id")

                while(cursor.moveToNext()){
                    println(isimIndex)
                    println(idIndex)
                }
                cursor.close()
            }

        } catch (e:Exception){

        }
    }
}