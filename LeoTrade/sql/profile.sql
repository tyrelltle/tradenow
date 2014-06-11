create table profile(
	prof_id int not null AUTO_INCREMENT,
	social_id varchar(255) not null,
	firstname varchar(255),
	lastname varchar(255),
	email	varchar(255),
	aboutme varchar(255),
	location varchar(255),
	image   MEDIUMBLOB,
	primary key (prof_id)
)