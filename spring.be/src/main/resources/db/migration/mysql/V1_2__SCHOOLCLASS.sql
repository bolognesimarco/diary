INSERT INTO SCHOOL_CLASS (NAME, HEADMASTER_ID) 
VALUES 
('Nistri II A', (SELECT ID FROM `user` WHERE USERNAME='bolo') );