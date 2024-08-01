package com.test.checkListner.repository;

import com.test.checkListner.entity.TableData;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RepoClass extends JpaRepository<TableData,Long> {

@Query("SELECT t FROM TableData t WHERE t.processed = true")
List<TableData> findUnprocessedRecords();

@Query("SELECT t FROM TableData t WHERE t.updatedAt > :timestamp AND t.processed = false")
List<TableData> findNewRecords(@Param("timestamp") java.sql.Timestamp timestamp);

List<TableData> findAllById(Long id);



}
