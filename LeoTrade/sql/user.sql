create table user(
	userid int not null AUTO_INCREMENT,
	socialuid varchar(255),
	firstname varchar(255),
	lastname varchar(255),
	email	varchar(255),
	password varchar(255),
	aboutme varchar(255),
	location varchar(255),
	latitude double,
	longitude double,
	image   MEDIUMBLOB,
	enabled TINYINT NOT NULL DEFAULT 1,
	isnoob	TINYINT not null default 1,
	primary key (userid)
)