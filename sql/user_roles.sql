CREATE TABLE user_roles (
  user_role_id INT(11) NOT NULL AUTO_INCREMENT,
  userid int NOT NULL,
  ROLE VARCHAR(45) NOT NULL,
  PRIMARY KEY (user_role_id),
  UNIQUE KEY uni_username_role (ROLE,userid),
  KEY fk_username_idx (userid),
  CONSTRAINT fk_username FOREIGN KEY (userid) REFERENCES user (userid))