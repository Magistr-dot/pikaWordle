package com.example.pikawordle.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.example.pikawordle.R
import com.example.pikawordle.domain.enum.MyColor

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]




        viewModel.addLetter(viewModel.letterList[10])
        viewModel.addLetter(viewModel.letterList[16])
        viewModel.addLetter(viewModel.letterList[19])
        viewModel.addLetter(viewModel.letterList[18])
        viewModel.addLetter(viewModel.letterList[14])
        viewModel.addLetter(viewModel.letterList[14])
//        viewModel.deleteLetter(viewModel.letterList[18])

        //viewModel.deleteLetter(viewModel.letterScreenList[2])
        viewModel.letterScreenList.forEach { println(it) }
//        print(viewModel.checkLetter(viewModel.letterList[9], MyColor.green))
//        viewModel.letterList.forEach { println(it) }
//        viewModel.deleteShopList(ShopItem("Name 0",0,true,0))
//        viewModel.editShopList(ShopItem("Name 1",1,true,1))
//        viewModel.shopList.observe(this){
//            Log.d("Main1", it.toString())
//        }
        println(viewModel.word)
        println(viewModel.word)
        println(viewModel.word)
        println(viewModel.word)
        viewModel.addWord(viewModel.word)
        viewModel.addWord(viewModel.word)
        viewModel.addWord(viewModel.word)
        println("fff${viewModel.word}")
        viewModel.checkWord(viewModel.word, viewModel.letterScreenList)
        println(viewModel.letterList)
    }
}