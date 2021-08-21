package org.sabgil.kspsample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import org.sabgil.annotation.MyAnnotation

class MainActivity : AppCompatActivity() {
    private lateinit var myInterface: MyInterface

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}

@MyAnnotation
interface MyInterface