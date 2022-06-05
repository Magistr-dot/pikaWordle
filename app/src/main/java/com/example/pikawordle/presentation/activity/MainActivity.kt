package com.example.pikawordle.presentation.activity

import android.graphics.drawable.BitmapDrawable
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import com.example.pikawordle.R
import com.google.firebase.auth.FirebaseAuth
import com.squareup.picasso.Picasso

class MainActivity : AppCompatActivity() {
    lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        auth = FirebaseAuth.getInstance()
        setImage()

        val buttonHS = findViewById<ImageButton>(R.id.high_score_button)
        buttonHS.setOnClickListener {
            val intent = UserActivity.newIntent(this)
            startActivity(intent)
        }
        val buttonGame = findViewById<ImageButton>(R.id.new_game_button)
        buttonGame.setOnClickListener {
            val intent = GameActivity.newIntent(this)
            startActivity(intent)
        }
        val buttonSettings = findViewById<ImageButton>(R.id.settings_button)
        buttonSettings.setOnClickListener {
            val intent = SettingsActivity.newIntent(this)
            startActivity(intent)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.sign_out) {
            auth.signOut()
            finish()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun setImage() {
        val ab = supportActionBar
        Thread {
            val bMap = Picasso.get().load(auth.currentUser?.photoUrl).get()
            val dIcon = BitmapDrawable(resources, bMap)
            runOnUiThread {
                ab?.setDisplayHomeAsUpEnabled(true)
                ab?.setHomeAsUpIndicator(dIcon)
                ab?.title = "Hello " + auth.currentUser?.displayName
            }
        }.start()
    }

}