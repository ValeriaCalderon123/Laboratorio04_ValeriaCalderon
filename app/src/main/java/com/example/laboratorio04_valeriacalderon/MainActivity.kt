package com.example.laboratorio04_valeriacalderon

import android.content.Context
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.view.View
import android.widget.*
import androidx.lifecycle.lifecycleScope
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.launch
import org.idnp.datastoresamplegra.DataStore
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch


class MainActivity : AppCompatActivity() {
    private val Context.dataStore by preferencesDataStore(DataStore.PREFS_NAME)
    lateinit var notePrefsData: DataStore
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        notePrefsData = DataStore(dataStore)
        setContentView(R.layout.activity_main)

        var buttonSaveColor: Button = findViewById(R.id.buttonColor)
        var buttonSizeL : Button = findViewById(R.id.buttonSize)
        var buttonFontL : Button = findViewById(R.id.buttonFonts)
        var layoutConst: ConstraintLayout = findViewById(R.id.principal)
        var colorVar=""
        var fontVar=""
        val spinner_colors = findViewById<Spinner>(R.id.spinner)
        val spinner_fuentes = findViewById<Spinner>(R.id.spinner2)
        val lista_colors = resources.getStringArray(R.array.colors)
        val lista_fuentes = resources.getStringArray(R.array.fuente)
        var sizeT: EditText = findViewById(R.id.editTextSize)
        var text1: TextView=findViewById(R.id.text1)
        var text2: TextView=findViewById(R.id.text2)
        var text3: TextView=findViewById(R.id.text3)
        val text4: TextView=findViewById(R.id.text4)
        val text5: TextView=findViewById(R.id.text5)
        val text6: TextView=findViewById(R.id.text6)
        val text7: TextView=findViewById(R.id.text7)
        val text8: TextView=findViewById(R.id.text8)
        val text9: TextView=findViewById(R.id.text9)
        val text10: TextView=findViewById(R.id.text10)
        val text11: TextView=findViewById(R.id.text11)
        val text12: TextView=findViewById(R.id.text12)

        val tableL:TableLayout = findViewById(R.id.tableLayout)

        val adapter_colors = ArrayAdapter(this, android.R.layout.simple_spinner_item,lista_colors)
        val adapter_fuentes = ArrayAdapter(this, android.R.layout.simple_spinner_item,lista_fuentes)
        spinner_colors.adapter = adapter_colors
        spinner_fuentes.adapter = adapter_fuentes

        layoutConst.setBackgroundColor(Color.WHITE)

        lifecycleScope.launch {
            notePrefsData.backgroundColor.collect { mycolor ->
                layoutConst.setBackgroundColor(Integer.parseInt(mycolor.toString()))
            }


            notePrefsData.sizeText.collect { mySize ->
                text1.setTextSize((mySize).toFloat())
                text2.setTextSize((mySize).toFloat())
                text3.setTextSize((mySize).toFloat())
                text4.setTextSize((mySize).toFloat())
                text5.setTextSize((mySize).toFloat())
                text6.setTextSize((mySize).toFloat())
                text7.setTextSize((mySize).toFloat())
                text8.setTextSize((mySize).toFloat())
                text9.setTextSize((mySize).toFloat())
                text10.setTextSize((mySize).toFloat())
                text11.setTextSize((mySize).toFloat())
                text12.setTextSize((mySize).toFloat())
                // text2.setTextSize(mySize.toFloat())

            }
        }

        buttonSaveColor.setOnClickListener{
            if(colorVar=="Azul"){
                lifecycleScope.launch {

                    notePrefsData.saveBackground(Color.rgb(41,128,185).toString())

                }
            }else if (colorVar=="Anaranjado"){
                lifecycleScope.launch {
                    notePrefsData.saveBackground(Color.rgb(230,126,34).toString())

                }
            }else if (colorVar=="Rosado"){
                lifecycleScope.launch {
                    notePrefsData.saveBackground(Color.rgb(245,183,177).toString())

                }
            }else if (colorVar=="Blanco"){
                lifecycleScope.launch {
                    notePrefsData.saveBackground(Color.WHITE.toString())

                }
            }

        }

        buttonSizeL.setOnClickListener{
            lifecycleScope.launch {
                notePrefsData.saveSize(sizeT.text.toString());
            }
/*
            text1.setTextSize((sizeT.text.toString()).toFloat())
            text2.setTextSize((sizeT.text.toString()).toFloat())
            text3.setTextSize((sizeT.text.toString()).toFloat())
            text4.setTextSize((sizeT.text.toString()).toFloat())
            text5.setTextSize((sizeT.text.toString()).toFloat())
            text6.setTextSize((sizeT.text.toString()).toFloat())
            text7.setTextSize((sizeT.text.toString()).toFloat())
            text8.setTextSize((sizeT.text.toString()).toFloat())
            text9.setTextSize((sizeT.text.toString()).toFloat())
            text10.setTextSize((sizeT.text.toString()).toFloat())
            text11.setTextSize((sizeT.text.toString()).toFloat())
            text12.setTextSize((sizeT.text.toString()).toFloat())
*/
        }

        buttonFontL.setOnClickListener{
            if(fontVar=="Negrita"){
                lifecycleScope.launch {

                    notePrefsData.saveFont(Color.rgb(41,128,185).toString())

                }
            }else if (fontVar=="Sans-Serif"){
                lifecycleScope.launch {
                    notePrefsData.saveFont(Color.rgb(230,126,34).toString())

                }
            }else if (fontVar=="Cursiva") {
                lifecycleScope.launch {
                    notePrefsData.saveFont(Color.rgb(245, 183, 177).toString())

                }
            }
        }

        spinner_colors.onItemSelectedListener = object:
            AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                colorVar= lista_colors[position];
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }

        spinner_fuentes.onItemSelectedListener = object:
            AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                fontVar= lista_fuentes[position];
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }


    }



}