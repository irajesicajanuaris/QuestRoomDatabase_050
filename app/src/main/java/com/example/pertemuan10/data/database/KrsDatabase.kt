package com.example.pertemuan10.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.pertemuan10.data.dao.MahasiswaDao
import com.example.pertemuan10.data.entity.Mahasiswa

@Database(entities = [Mahasiswa::class], version = 1, exportSchema = false)
abstract class KrsDatabase : RoomDatabase() {
    //mendefinisikan fungsi untuk mengakses data mahasiswa
    abstract fun mahasiswaDao(): MahasiswaDao

    companion object{
        @Volatile // memastikan bahwa nilai variabel instance selalu sama di semua
        private var Instance: KrsDatabase?= null

        fun getDatabase(context: Context): KrsDatabase{
            return (Instance ?: synchronized(this){
                Room.databaseBuilder(
                    context.applicationContext,
                    KrsDatabase::class.java, //class database
                    "KrsDatabase" // Nama database
                )
                    .build().also { Instance = it }
            })
        }
    }
}