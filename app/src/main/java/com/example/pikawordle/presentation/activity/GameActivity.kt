package com.example.pikawordle.presentation.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.pikawordle.R
import com.example.pikawordle.presentation.MainViewModel
import com.example.pikawordle.presentation.UsersListAdapter

class GameActivity : AppCompatActivity() {
    private lateinit var viewModel: MainViewModel
    private lateinit var usersListAdapter: UsersListAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupRecycler()
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        usersListAdapter.submitList(viewModel.list)
    }

    private fun setupRecycler() {
        val rvUsersList = findViewById<RecyclerView>(R.id.users_list)
        with(rvUsersList) {
            usersListAdapter = UsersListAdapter()
            adapter = usersListAdapter
        }
    }
//        viewModel.addLetter(viewModel.letterList[10])
//        viewModel.addLetter(viewModel.letterList[16])
//        viewModel.addLetter(viewModel.letterList[19])
//        viewModel.addLetter(viewModel.letterList[18])
//        viewModel.addLetter(viewModel.letterList[14])
//        viewModel.addLetter(viewModel.letterList[14])
////        viewModel.deleteLetter(viewModel.letterList[18])
//
//        //viewModel.deleteLetter(viewModel.letterScreenList[2])
//        viewModel.letterScreenList.forEach { println(it) }
////        print(viewModel.checkLetter(viewModel.letterList[9], MyColor.green))
////        viewModel.letterList.forEach { println(it) }
////        viewModel.deleteShopList(ShopItem("Name 0",0,true,0))
////        viewModel.editShopList(ShopItem("Name 1",1,true,1))
////        viewModel.shopList.observe(this){
////            Log.d("Main1", it.toString())
////        }
//        println(viewModel.word)
//        println(viewModel.word)
//        println(viewModel.word)
//        println(viewModel.word)
//        viewModel.addWord(viewModel.word)
//        viewModel.addWord(viewModel.word)
//        viewModel.addWord(viewModel.word)
//        println("fff${viewModel.word}")
//        viewModel.checkWord(viewModel.word, viewModel.letterScreenList)
//        println(viewModel.letterList)

//        val user = Users("",2,"new",5.0,1)
//
//        println(viewModel.list)
//        viewModel.pushUser(user)
//        println(viewModel.list)
//        var newList = viewModel.getUsers(10)
//        println(newList)
}