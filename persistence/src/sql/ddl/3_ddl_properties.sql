-- --------------------------------------------------------

--
-- Table definition for table 'appl_property'

CREATE TABLE senseschema.appl_property
(
  name varchar(25) NOT NULL,
  value  varchar(255) NOT NULL,
  enabled integer NOT NULL default 1,
  CONSTRAINT appl_property_pk  PRIMARY KEY (name)
)
WITH (
  OIDS=FALSE
) ;


--- End Script

