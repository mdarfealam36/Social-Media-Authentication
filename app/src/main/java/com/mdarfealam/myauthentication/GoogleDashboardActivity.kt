package com.mdarfealam.myauthentication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.firebase.auth.FirebaseAuth
import com.mdarfealam.myauthentication.databinding.ActivityGoogleDashboardBinding


class GoogleDashboardActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    lateinit var binding: ActivityGoogleDashboardBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGoogleDashboardBinding.inflate(layoutInflater)
        setContentView(binding.root)


        auth = FirebaseAuth.getInstance()

        val displayName = intent.getStringExtra("name")
        val email = intent.getStringExtra("email")

        binding.tvName.text = displayName
        binding.tvEmail.text = email

        binding.logout.setOnClickListener {
            auth.signOut()
            startActivity(Intent(this,MainActivity::class.java))
        }

    }
}