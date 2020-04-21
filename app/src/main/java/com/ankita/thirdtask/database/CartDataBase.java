package com.ankita.thirdtask.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Cart.class}, version = 1,exportSchema = false)
public abstract class CartDataBase extends RoomDatabase {
    public abstract CartDao cartDao();

    private static  CartDataBase INSTANCE;

    public static CartDataBase getDatabase( Context context) {
                if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(context.getApplicationContext(), CartDataBase.class, "cart_database").allowMainThreadQueries().build();
            }
            return INSTANCE;
        }
        public static void destroyInstance() {
            INSTANCE = null;
        }

    }
