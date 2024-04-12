package com.example.giatorsjava.Roomdatabase;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;





@Database(entities = {Usertable.class},exportSchema = false,version = 1)

public abstract class DataBase extends RoomDatabase{
    abstract public Dao dao();
    public static DataBase dataBase;
    public static DataBase getdatabase(final Context context){
        if(dataBase==null){
            synchronized (DataBase.class){
                dataBase= Room.databaseBuilder(context,DataBase.class,"DataBase").allowMainThreadQueries().build();
            }
        }

        return dataBase;
    }


}
