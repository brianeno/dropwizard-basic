CREATE USER senseuser WITH PASSWORD 'sense123';

create TABLESPACE sensets;

CREATE DATABASE sensedb
  WITH OWNER = senseuser
       ENCODING = 'UTF8'
       TABLESPACE = sensets
       LC_COLLATE = 'en_US.UTF-8'
       LC_CTYPE = 'en_US.UTF-8'
       CONNECTION LIMIT = -1;

 CREATE SCHEMA senseschema
       AUTHORIZATION senseuser;


-- Needed to set schema for DB objects
ALTER ROLE senseuser SET search_path = 'senseschema';