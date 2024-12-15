package com.example.pertemuan10.repository

import com.example.pertemuan10.data.dao.MahasiswaDao
import com.example.pertemuan10.data.entity.Mahasiswa
import java.util.concurrent.Flow

class LocalRepositoryMhs(
    private val mahasiswaDao: MahasiswaDao
) : RepositoryMhs {

    override suspend fun insertMhs(mahasiswa: Mahasiswa){
        mahasiswaDao.insertMahasiswa(mahasiswa)
    }

    fun getAllMhs(): Flow<List<Mahasiswa>>
    fun getMhs(nim: String): Flow<Mahasiswa>
    suspend fun deleteMhs(mahasiswa: Mahasiswa)
}