package com.ankita.thirdtask.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface CartDao {
    @Insert
    void insertAll(Cart... cart);

    @Query("SELECT * FROM cart_table")
    List<Cart> getAllItem();
}
