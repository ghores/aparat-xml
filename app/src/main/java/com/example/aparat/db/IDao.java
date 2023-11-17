package com.example.aparat.db;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.aparat.model.Video;

import java.util.List;

@Dao
public interface IDao {

    @Insert
    long insert(Video video);

    @Update
    void update(Video video);

    @Query("SELECT * FROM tbl_video")
    List<Video> getVideoList();

    @Query("SELECT * FROM tbl_video where id =:id")
    boolean isRowIsExist(int id);

    @Query("delete from tbl_video where id=:id")
    void deleteVideo(int id);
}
