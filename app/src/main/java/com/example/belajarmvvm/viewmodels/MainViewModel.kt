package com.example.belajarmvvm.viewmodels

import android.app.Application
import androidx.databinding.ObservableField
import androidx.lifecycle.AndroidViewModel
import com.example.belajarmvvm.models.Mahasiswa

class MainViewModel(application: Application) : AndroidViewModel(application) {
    var nim     : ObservableField<String> = ObservableField()
    var nama    : ObservableField<String> = ObservableField()
    var jurusan : ObservableField<String> = ObservableField()

    fun setData(mahasiswa: Mahasiswa){
        nim.set(mahasiswa.nim)
        nama.set(mahasiswa.nama)
        jurusan.set(mahasiswa.jurusan)
    }
}