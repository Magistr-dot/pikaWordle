package com.example.pikawordle.presentation.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.KeyEvent
import android.view.View.VISIBLE
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.lifecycle.ViewModelProvider
import com.example.pikawordle.R
import com.example.pikawordle.domain.word.Word
import com.example.pikawordle.presentation.MainViewModel


class GameActivity : AppCompatActivity() {
    private lateinit var viewModel: MainViewModel

    var charsET = mutableListOf<EditText>()

    private lateinit var firstCharET: EditText
    private lateinit var secondCharET: EditText
    private lateinit var thirdCharET: EditText
    private lateinit var fourthCharET: EditText
    private lateinit var fifthCharET: EditText

    private var state = "first"
    private var end = false
    private var wordInScreen = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        println(viewModel.word.name)

        initET()
        val buttonCheck = button()
        jumpFocusRight(buttonCheck)
        deleteChar()

    }

    private fun button(): Button? {
        val buttonCheck = findViewById<Button>(R.id.pull_button)
        buttonCheck.setOnClickListener {

            end = false
            viewModel.letterScreenList.clear()
            wordInScreen = ""

            addListScreen()

            wordInVocabulary()

            fillET()


        }
        return buttonCheck
    }

    private fun fillET() {
        if (!end) {
            viewModel.letterScreenList =
                viewModel.checkWord(viewModel.word, viewModel.letterScreenList)

            if (viewModel.letterScreenList.isNotEmpty() && !end) {

                firstCharET = findViewById(
                    resources.getIdentifier(
                        "first_char_${state}_line",
                        "id",
                        packageName
                    )
                )
                secondCharET = findViewById(
                    resources.getIdentifier(
                        "second_char_${state}_line",
                        "id",
                        packageName
                    )
                )
                thirdCharET = findViewById(
                    resources.getIdentifier(
                        "third_char_${state}_line",
                        "id",
                        packageName
                    )
                )
                fourthCharET = findViewById(
                    resources.getIdentifier(
                        "fourth_char_${state}_line",
                        "id",
                        packageName
                    )
                )
                fifthCharET = findViewById(
                    resources.getIdentifier(
                        "fifth_char_${state}_line",
                        "id",
                        packageName
                    )
                )

                firstCharET.setText(viewModel.letterScreenList[0].oneLetter.toString())
                secondCharET.setText(viewModel.letterScreenList[1].oneLetter.toString())
                thirdCharET.setText(viewModel.letterScreenList[2].oneLetter.toString())
                fourthCharET.setText(viewModel.letterScreenList[3].oneLetter.toString())
                fifthCharET.setText(viewModel.letterScreenList[4].oneLetter.toString())

                firstCharET.setBackgroundColor(viewModel.letterScreenList[0].color.rgb)
                secondCharET.setBackgroundColor(viewModel.letterScreenList[1].color.rgb)
                thirdCharET.setBackgroundColor(viewModel.letterScreenList[2].color.rgb)
                fourthCharET.setBackgroundColor(viewModel.letterScreenList[3].color.rgb)
                fifthCharET.setBackgroundColor(viewModel.letterScreenList[4].color.rgb)

                charsET[0].setText("")
                charsET[1].setText("")
                charsET[2].setText("")
                charsET[3].setText("")
                charsET[4].setText("")

                findViewById<LinearLayoutCompat>(
                    resources.getIdentifier(
                        "${state}_line",
                        "id",
                        packageName
                    )
                ).visibility = VISIBLE
                viewModel.letterScreenList.clear()

                when (state) {
                    "first" -> state = "second"
                    "second" -> state = "third"
                    "third" -> state = "fourth"
                    "fourth" -> state = "fifth"
                    "fifth" -> state = "sixth"
                    "sixth" -> state = "endgame"
                }
            }

        }
    }

    private fun wordInVocabulary() {
        if (!end) {
            wordInScreen = viewModel.letterScreenList.joinToString(separator = "") {
                it.oneLetter.toString().uppercase()
            }
            if (viewModel.existsWord(Word(wordInScreen))) {
                end = false
            } else {
                end = true
                Toast.makeText(this, "$wordInScreen в словаре не найдено", Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }

    private fun addListScreen() {
        charsET.forEach {

            if (it.text.isNotEmpty() && viewModel.letterInList(it.text[0]) != null) {

                viewModel.addLetter(it.text[0])
            } else {
                end = true
                Toast.makeText(
                    this,
                    "Недостаточно букв или неправильная буква",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
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
                        if (viewModel.letterInList(s[0]) == null) {
                            Toast.makeText(this@GameActivity, "wrong symbol", Toast.LENGTH_SHORT)
                                .show()
                        } else {
                            when (it.id) {
                                charsET[0].id -> charsET[1].requestFocus()
                                charsET[1].id -> charsET[2].requestFocus()
                                charsET[2].id -> charsET[3].requestFocus()
                                charsET[3].id -> charsET[4].requestFocus()
                                charsET[4].id -> buttonCheck!!.requestFocus()
                            }
                        }
                    }
                }
            })
        }
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