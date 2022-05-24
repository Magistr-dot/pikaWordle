package com.example.pikawordle.presentation.activity

import android.content.Context
import android.content.Intent
import android.graphics.Rect
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.KeyEvent
import android.view.View
import android.view.View.FOCUS_LEFT
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.pikawordle.R
import com.example.pikawordle.presentation.MainViewModel


class GameActivity : AppCompatActivity() {
    private lateinit var viewModel: MainViewModel
    var firstChar: Char = '\u0000'
    var secondChar: Char = '\u0000'
    var thirdChar: Char = '\u0000'
    var fourthChar: Char = '\u0000'
    var fifthChar: Char = '\u0000'

    var charsET = mutableListOf<EditText>()


    lateinit var firstCharET: EditText
    lateinit var secondCharET: EditText
    lateinit var thirdCharET: EditText
    lateinit var fourthCharET: EditText
    lateinit var fifthCharET: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        println(viewModel.word.name)

        initET()
        val buttonCheck = initButton()
        jumpFocusRight(buttonCheck)
        deleteChar()

    }

    private fun deleteChar() {
        for (i in 0..4) {
            charsET[i].setOnKeyListener { _, keyCode, _ ->
                if (i != 0 && keyCode == KeyEvent.KEYCODE_DEL) {
                    charsET[i - 1].requestFocus()
                }
                false
            }
        }

        charsET.forEach { some ->
            some.setOnClickListener {
                println(some.isFocused)
                some.text.clear()
            }
        }
    }

    private fun jumpFocusRight(buttonCheck: Button?) {
        charsET.forEach {
            it.addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(
                    s: CharSequence?,
                    start: Int,
                    count: Int,
                    after: Int
                ) {
                }

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

                }

                override fun afterTextChanged(s: Editable) {

                    if (s.length == 1) {
                        when (it.id) {
                            charsET[0].id -> charsET[1].requestFocus()
                            charsET[1].id -> charsET[2].requestFocus()
                            charsET[2].id -> charsET[3].requestFocus()
                            charsET[3].id -> charsET[4].requestFocus()
                            charsET[4].id -> buttonCheck!!.requestFocus()
                        }
                    }
                }
            })
        }
    }

    private fun initButton(): Button? {
        val buttonCheck = findViewById<Button>(R.id.pull_button)
        buttonCheck.setOnClickListener {

            println(viewModel.letterScreenList)
//            if(charsET.contains())
//            viewModel.letterList.forEach {
//
//            }
            println(viewModel.letterScreenList)

        }
        return buttonCheck
    }


    private fun initET() {
        for (i in 0..4) {
            when (i) {
                0 -> charsET.add(i, findViewById(R.id.first_char_current_line))
                1 -> charsET.add(i, findViewById(R.id.second_char_current_line))
                2 -> charsET.add(i, findViewById(R.id.third_char_current_line))
                3 -> charsET.add(i, findViewById(R.id.fourth_char_current_line))
                4 -> charsET.add(i, findViewById(R.id.fifth_char_current_line))
            }
        }
        charsET[0].requestFocus()
    }

    companion object {
        private const val EXTRA_MODE = "extra_mode"
        private const val NEW_GAME = true

        fun newIntent(context: Context): Intent {
            val intent = Intent(context, GameActivity::class.java)
            intent.putExtra(EXTRA_MODE, NEW_GAME)
            return intent
        }

    }
}