package com.mdarfealam.myauthentication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class GithubDashboardActivity : AppCompatActivity() {

    var userName = ""
    var email = ""

    private lateinit var githubUserName: TextView
    private lateinit var githubEmail: TextView
    private lateinit var logoutBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_github_dashboard)

        githubUserName = findViewById(R.id.id)
        githubEmail = findViewById(R.id.userEmail)

        logoutBtn = findViewById(R.id.logOut)

        userName = intent.getStringExtra("githubUserName")!!
        githubUserName.text = userName

        email = intent.getStringExtra("githubEmail")!!
        githubEmail.text = email

        logoutBtn.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            Toast.makeText(this, "Logging Out", Toast.LENGTH_SHORT).show()
            this.startActivity(intent)
            finish()
        }
    }
}
