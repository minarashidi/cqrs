DROP SCHEMA contactservice CASCADE;
CREATE SCHEMA contactservice;

CREATE SEQUENCE contactservice.s_contact START WITH 1 INCREMENT BY 1;
CREATE TABLE contactservice.contact (
  id       INTEGER DEFAULT nextval('contactservice.s_contact') PRIMARY KEY,
  name     VARCHAR(45),
  email    VARCHAR(45),
  phone    VARCHAR(15)
);