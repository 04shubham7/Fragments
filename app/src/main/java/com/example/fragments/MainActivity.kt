package com.example.fragments

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.example.fragments.databinding.ActivityMainBinding
import com.example.fragments.ui.login.LoginFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding.btnTime.setOnClickListener {

            replaceFrameWithFragment(Clock_Fragment())
        }
        binding.btnExam.setOnClickListener {

            replaceFrameWithFragment(Exam_Fragment())
        }
        binding.btnValidate.setOnClickListener {

            replaceFrameWithFragment(LoginFragment())
        }
    }

    private fun replaceFrameWithFragment(fragment: Fragment) {
        val fragManager=supportFragmentManager
        val fragTransaction=fragManager.beginTransaction()
        fragTransaction.replace(R.id.framelayout,fragment)
        fragTransaction.commit()
    }
}