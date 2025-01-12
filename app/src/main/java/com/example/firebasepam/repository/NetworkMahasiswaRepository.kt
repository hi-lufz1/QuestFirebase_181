package com.example.firebasepam.repository

import com.example.firebasepam.model.Mahasiswa
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow

class NetworkMahasiswaRepository (
    private val firestore: FirebaseFirestore
) : MahasiswaRepository {
    override suspend fun getMahasiswa(): Flow<List<Mahasiswa>> = callbackFlow {

        val mhsCollection = firestore.collection("Mahasiswa")
            .orderBy("nama", Query.Direction.ASCENDING)
            .addSnapshotListener { value, error ->

                if ( value != null){
                    val mhsList = value.documents.mapNotNull {
                        it.toObject(Mahasiswa::class.java)!!
                    }
                    trySend(mhsList) // try send memberikan fungsi untuk mengirim data ke flow
                }
            }
        awaitClose{
            mhsCollection.remove()
        }

    }

    override suspend fun insertMahasiswa(mahasiswa: Mahasiswa) {
        TODO("Not yet implemented")
    }

    override suspend fun updateMahasiswa(nim: String, mahasiswa: Mahasiswa) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteMahasiswa(nim: String) {
        TODO("Not yet implemented")
    }

    override suspend fun getMahasiswaByID(nim: String): Flow<Mahasiswa>  = callbackFlow {
        val mhsDocument = firestore.collection("Mahasiswa")
            .document(nim)
            .addSnapshotListener { value, error ->
                if(value != null){
                    val mhs = value.toObject(Mahasiswa::class.java)!!
                    trySend(mhs)
                }
            }
        awaitClose {
            mhsDocument.remove()
        }
    }
}