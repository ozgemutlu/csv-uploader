package com.assignment.csvuploader.controller;

import com.assignment.csvuploader.dto.ResponseDto;
import com.assignment.csvuploader.model.CsvFile;
import com.assignment.csvuploader.service.CsvFileService;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;

@RestController
public class CsvFileController {

    private final CsvFileService csvFileService;

    @Autowired
    public CsvFileController(CsvFileService csvFileService) {
        this.csvFileService = csvFileService;
    }

    @PostMapping("/upload")
    public ResponseEntity<ResponseDto> uploadCSVFile(@RequestParam("file") MultipartFile file) {
        // if csv file is empty
        if (file.isEmpty()) {
            return ResponseEntity.badRequest().body(new ResponseDto("Can\'t load the file, file is empty!"));
        } else {
            // read csv file and convert it into list of CSVFile objects, then save all
            try (Reader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
                CsvToBean<CsvFile> csvToBean = new CsvToBeanBuilder(reader)
                    .withType(CsvFile.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();

                List<CsvFile> lines = csvToBean.parse();
                csvFileService.saveAll(lines);
            } catch (Exception ex) {
                return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED)
                                     .body(new ResponseDto("Error, can\'t load the file :("));
            }
        }
        return ResponseEntity.ok(new ResponseDto("File is uploaded successfully."));
    }

    @GetMapping("/list")
    public ResponseEntity<List<CsvFile>> list() {
        return ResponseEntity.ok(csvFileService.findAll());
    }

    @PostMapping("/listByCode")
    public ResponseEntity<List<CsvFile>> listByCode(@RequestParam("code") String code) {
        return ResponseEntity.ok(csvFileService.findByCode(code));
    }

    @GetMapping("deleteAll")
    public ResponseEntity<ResponseDto> deleteAll() {
        try {
            csvFileService.deleteAll();
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED)
                    .body(new ResponseDto("Error, can\'t delete the data :("));
        }
        return ResponseEntity.ok(new ResponseDto("All uploaded data is deleted successfully."));
    }
}
