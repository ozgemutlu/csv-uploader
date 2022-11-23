package com.assignment.csvuploader.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "CSV_FILE")
@Getter
@Setter
public class CsvFile {

    @Id
    @Column(name="CODE")
    String code;

    @Column(name="SOURCE")
    String source;

    @Column(name="CODE_LIST_CODE")
    String codeListCode;

    @Column(name="DISPLAY_VALUE")
    String displayValue;

    @Column(name="LONG_DESCRIPTION")
    String longDescription;

    @Column(name="FROM_DATE")
    String fromDate;

    @Column(name="TO_DATE")
    String toDate;

    @Column(name="SORTING_PRIORITY")
    Integer sortingPriority;
}
