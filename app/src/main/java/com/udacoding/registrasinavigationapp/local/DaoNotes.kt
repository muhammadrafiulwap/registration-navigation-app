package com.udacoding.registrasinavigationapp.local

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

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