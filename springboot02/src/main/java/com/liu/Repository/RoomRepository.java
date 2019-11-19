package com.liu.Repository;

import com.liu.pojo.Hotel;
import com.liu.pojo.Room;
import com.liu.pojo.Roomtype;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface RoomRepository extends JpaRepository<Room, Integer>, JpaSpecificationExecutor<Hotel> {
    Room findRoomById(Integer id);
}
