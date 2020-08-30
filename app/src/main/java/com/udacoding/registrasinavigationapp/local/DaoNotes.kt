package com.udacoding.registrasinavigationapp.local

import androidx.room.*

@Dao
interface DaoNotes {

    @Query("SELECT * FROM notes")
    fun getAll(): List<Notes>

    @Insert
    fun insert(notes: Notes)

    @Update
    fun update(notes: Notes)

    @Delete
    fun delete(notes: Notes)

}