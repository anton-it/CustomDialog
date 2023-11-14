package com.example.customdialog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AlertDialog
import com.example.customdialog.databinding.ActivityMainBinding
import com.example.customdialog.databinding.DialogViewBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).also { setContentView(it.root) }

        binding.btnShow.setOnClickListener {
            val dialogBinding = DialogViewBinding.inflate(layoutInflater)
            //val view = View.inflate(this@MainActivity, R.layout.dialog_view, null)

            val builder = AlertDialog.Builder(this@MainActivity)
            //builder.setView(view)
            builder.setView(dialogBinding.root)

            val dialog = builder.create()
            dialog.show()
            dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)

            dialogBinding.btnConfirm.setOnClickListener {
                dialog.dismiss()
            }
        }


    }
}