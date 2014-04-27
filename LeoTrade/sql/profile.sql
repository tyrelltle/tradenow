create table profile(
	prof_id int not null AUTO_INCREMENT,
	social_id varchar(255) not null,
	aboutme varchar(255),
	location varchar(255),
	primary key (prof_id)
)