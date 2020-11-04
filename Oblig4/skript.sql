DROP SCHEMA IF EXISTS oblig4 CASCADE;
CREATE SCHEMA oblig4;
SET search_path = oblig4;

CREATE TABLE bruker 
(
   fornavn CHARACTER VARYING (20),
   etternavn CHARACTER VARYING (20),
   mobil integer,
   pwd_hash CHARACTER (128),
   pwd_salt CHARACTER (64),
   kjonn CHARACTER VARYING(20),
   PRIMARY KEY (mobil)
);

INSERT INTO bruker VALUES 
	('Kjetil','Johansen','95335603',-- passord: qwerty
		'DF32FB5C3D132F276CA0E9B582ADA7E7B72CA1E5DE58C35D86C378A9446EE005',
		'38943AF5CA14AE5C1B9438FBB20233CA','Mann')
	