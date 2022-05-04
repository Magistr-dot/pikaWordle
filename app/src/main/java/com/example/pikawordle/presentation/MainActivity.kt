package com.example.pikawordle.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.example.pikawordle.R

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        viewModel.letterList.forEach { println(it) }
        viewModel.

        viewModel.deleteLetter(viewModel.letterList[0])
//        viewModel.deleteShopList(ShopItem("Name 0",0,true,0))
//        viewModel.editShopList(ShopItem("Name 1",1,true,1))
//        viewModel.shopList.observe(this){
//            Log.d("Main1", it.toString())
//        }


    }
}