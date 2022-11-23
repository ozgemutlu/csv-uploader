package com.assignment.csvuploader.repository;

import com.assignment.csvuploader.model.CsvFile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CsvFileRepository extends JpaRepository<CsvFile, String> {

    List<CsvFile> findCsvFileByCode(String code);
}
