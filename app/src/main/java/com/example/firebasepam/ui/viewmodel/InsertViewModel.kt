package com.example.firebasepam.ui.viewmodel

import com.example.firebasepam.model.Mahasiswa


data class FormErrorState(
    val nim: String? = null,
    val nama: String? = null,
    val jenis_kelamin: String? = null,
    val alamat: String? = null,
    val kelas: String? = null,
    val angkatan: String? = null
) {
    fun isValid(): Boolean {
        return nim != null && nama != null && jenis_kelamin != null
                && alamat != null && kelas != null && angkatan != null
    }
}


// variabel untuk simpan data dari form input
data class MahasiswaEvent(
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