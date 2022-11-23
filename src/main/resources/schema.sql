CREATE TABLE CSV_FILE
(
    SOURCE VARCHAR(10),
    CODE_LIST_CODE VARCHAR(10),
    CODE VARCHAR(20) NOT NULL,
    DISPLAY_VALUE VARCHAR(100),
    LONG_DESCRIPTION VARCHAR(500),
    FROM_DATE VARCHAR(15),
    TO_DATE VARCHAR(15),
    SORTING_PRIORITY INTEGER,
    PRIMARY KEY (CODE)
);