package org.sabgil.kspsample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sabgil.MyInterface3
import org.sabgil.annotation.MyAnnotation

class MainActivity : AppCompatActivity() {
    private lateinit var myInterface: MyInterface

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val a : MyInterface3
    }
}

@MyAnnotation
interface MyInterface

@MyAnnotation
interface MyInterface2