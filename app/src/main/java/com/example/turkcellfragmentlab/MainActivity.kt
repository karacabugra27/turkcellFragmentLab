package com.example.turkcellfragmentlab

import android.content.DialogInterface
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout

class MainActivity : AppCompatActivity() {
    var alertCalisti = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val ft = supportFragmentManager.beginTransaction()
        ft.replace(R.id.container1, FragmentBuyuk())
        ft.commit()


        val container2: ConstraintLayout = findViewById<ConstraintLayout>(R.id.container2)
        container2.visibility = View.INVISIBLE
    }

    fun btnFragment(view: View) {

        if (alertCalisti == false) {
            val uyari = AlertDialog.Builder(this)
            uyari.setTitle("Kücük Ekran Uyarisi")
            uyari.setMessage("Kücük Ekrana Gececektir Emin Misiniz?")
            uyari.setPositiveButton(
                "Eminim",
                DialogInterface.OnClickListener { dialogInterface, i ->
                    alertCalisti = true
                    val container2: ConstraintLayout =
                        findViewById<ConstraintLayout>(R.id.container2)
                    container2.visibility = View.VISIBLE
                    val container1: ConstraintLayout =
                        findViewById<ConstraintLayout>(R.id.container1)
                    container1.visibility = View.INVISIBLE

                    val ft = supportFragmentManager.beginTransaction()
                    ft.replace(R.id.container2, KucukFragment())
                    ft.commit()

                    Toast.makeText(this,"Kücük ekrana gecildi.",Toast.LENGTH_SHORT).show()
                })
            uyari.setNegativeButton("Hayır", null)

            uyari.create().show()

        }

    }


}
