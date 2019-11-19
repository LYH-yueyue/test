package com.liu.Repository;

import com.liu.pojo.Scenic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ScenicRepository extends JpaRepository<Scenic, Integer>, JpaSpecificationExecutor<Scenic> {

    Scenic findScenicById(Integer id);
}
