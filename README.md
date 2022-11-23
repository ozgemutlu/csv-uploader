# csv-uploader

Java 17\
Spring Boot 2.7.5

Database = H2 (in-memory)\
Database Url = jdbc:h2:mem:csvDb\
Database Username = sa\
Database Password =

Requests\
/upload (POST) = uploads csv file\
/list (GET) = lists all the data\
/listByCode (POST) = lists all the data by code\
/deleteAll (GET) = deletes all the data

schema.sql file can be found in resources directory.
