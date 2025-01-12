package com.example.firebasepam.ui.viewmodel

import com.example.firebasepam.model.Mahasiswa



// variabel untuk simpan data dari form input
data class MahasiswaEvent (
    val nim: String = "",
    val nama: String = "",
    val jenis_kelamin: String = "",
    val alamat: String = "",
    val kelas: String = "",
    val angkatan: String = ""
)

// simpan input form ke dalam entitiy
fun MahasiswaEvent.toMhsModel(): Mahasiswa = Mahasiswa(
    nim = nim,
    nama = nama,
    jenis_kelamin = jenis_kelamin,
    alamat = alamat,
    kelas = kelas,
    angkatan = angkatan
)