-- test consumer
INSERT INTO needicaschema.entity(entityid,type) VALUES
            ('a0eebc99-9c0b-4ef8-bb6d-6bb9bd380a11', 'C');
INSERT INTO needicaschema.consumer(cid,firstname,lastname,addressline1,addressline2,city,state, zip, 
            country, status, createdate, updatedate) VALUES
            ('a0eebc99-9c0b-4ef8-bb6d-6bb9bd380a11', 'Brian', 'Enochson', '1013 Curtis Avenue',
            null, 'Point Pleasant', 'NJ', '08742', 'USA', 'ACTIVE', CURRENT_TIMESTAMP,  null);

-- test vendor
INSERT INTO needicaschema.entity(entityid,type) VALUES
            ('c0eebc99-9c0b-4ef8-bb6d-6bb9bd380a11', 'V');
INSERT INTO needicaschema.vendor(cid,firstname,lastname,addressline1,addressline2,city,state, zip,
            country, status, createdate, updatedate) VALUES
            ('c0eebc99-9c0b-4ef8-bb6d-6bb9bd380a11', 'Elijah', 'Enochson', '1013 Curtis Avenue',
            null, 'Point Pleasant', 'NJ', '08742', 'USA', 'ACTIVE', CURRENT_TIMESTAMP,  null);

