package com.example.giatorsjava.Roomdatabase;


import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;


@androidx.room.Dao

public interface Dao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void createUser(Usertable usertable);

    @Query("select * from Usertable where email=:email")
    List<Usertable> checkmail(String email);


    @Query("select * from Usertable where email=:email and password=:password")
    List<Usertable> login(String email, String password);


    @Query("update Usertable set name=:name, moblie=:mobi,email=:email,city=:city,password=:pass where email=:changemail")
    void updateUser(String name,
                    String mobi,
                    String email,
                    String city,
                    String pass,
                    String changemail);

}
