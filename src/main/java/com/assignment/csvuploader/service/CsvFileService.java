package com.assignment.csvuploader.service;

import com.assignment.csvuploader.model.CsvFile;
import com.assignment.csvuploader.repository.CsvFileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CsvFileService {

    private final CsvFileRepository csvFileRepository;

    @Autowired
    public CsvFileService(CsvFileRepository csvFileRepository) {
        this.csvFileRepository = csvFileRepository;
    }

    /**
     * Saves all lines into CSV_FILE table
     *
     * @param lines of csv file
     */
    public void saveAll(List<CsvFile> lines) {
        csvFileRepository.saveAll(lines);
    }

    /**
     * Returns all data of CSV_FILE table
     *
     * @return List of CsvFile objects
     */
    public List<CsvFile> findAll() {
        return csvFileRepository.findAll();
    }

    /**
     * Returns all data of CSV_FILE table by code
     *
     * @param code of CsvFile
     * @return List of CsvFile objects
     */
    public List<CsvFile> findByCode(String code) {
        return csvFileRepository.findCsvFileByCode(code);
    }

    /**
     * Deletes all data of CSV_FILE table
     */
    @Transactional
    public void deleteAll() {
        csvFileRepository.deleteAll();
    }
}
