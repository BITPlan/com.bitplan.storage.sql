-- 
-- database setup script for testsqlstorage
-- the tables will be created and dropped by the corresponding JUnit tests via JPA/Eclipselink
-- 
create database testsqlstorage;
grant all privileges on testsqlstorage.* to 'cm'@'localhost' identified by 'secret';