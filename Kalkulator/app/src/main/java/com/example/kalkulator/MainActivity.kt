package com.example.kalkulator

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private  lateinit var  edtAwal: EditText
    private  lateinit var  edtAkhir: EditText
    private  lateinit var  btnTambah: Button
    private  lateinit var  btnKurang: Button
    private  lateinit var  btnBagi: Button
    private  lateinit var  btnKali: Button
    private  lateinit var  tvHasil: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        edtAwal = findViewById(R.id.edt_awal)
        edtAkhir = findViewById(R.id.edt_akhir)
        btnTambah = findViewById(R.id.btn_tambah)
        btnKurang = findViewById(R.id.btn_kurang)
        btnBagi = findViewById(R.id.btn_bagi)
        btnKali = findViewById(R.id.btn_kali)
        tvHasil = findViewById(R.id.tv_hasil)


        btnTambah.setOnClickListener {
            kalkulasi('+')
        }

        btnKurang.setOnClickListener {
            kalkulasi('-')
        }

        btnBagi.setOnClickListener {
            kalkulasi('/')
        }

        btnKali.setOnClickListener {
            kalkulasi('*')
        }

        if (savedInstanceState != null) {
            tvHasil.text = savedInstanceState.getString(("HASIL OPERASI"))
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("HASIL OPERASI", tvHasil.text.toString())
    }

    private fun kalkulasi(operator: Char) {
        if (edtAwal.text.toString().isEmpty()) {
            edtAwal.error = "Silahkan Masukan Angka!"
            return
        }

        if (edtAkhir.text.toString().isEmpty()) {
            edtAkhir.error = "Silahkan Masukan Angka!"
            return
        }


        val hasilNilaiAwal = edtAwal.text.toString().toDouble()
        val hasilNilaiAkhir = edtAkhir.text.toString().toDouble()

        val hasil = when(operator) {
            '+' -> hasilNilaiAwal + hasilNilaiAkhir
            '-' -> hasilNilaiAwal - hasilNilaiAkhir
            '/' -> hasilNilaiAwal / hasilNilaiAkhir
            '*' -> hasilNilaiAwal * hasilNilaiAkhir
            else -> 0.0
        }


        tvHasil.text = hasil.toString()
    }


}