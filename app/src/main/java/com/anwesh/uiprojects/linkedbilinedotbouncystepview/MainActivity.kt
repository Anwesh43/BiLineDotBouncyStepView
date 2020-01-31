package com.anwesh.uiprojects.linkedbilinedotbouncystepview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.anwesh.uiprojects.bilinedotbouncystepview.BiLineDotBouncyStepView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        BiLineDotBouncyStepView.create(this)
    }
}
