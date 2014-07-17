create table user(
	userid int not null AUTO_INCREMENT,
	userconid varchar(255),
	providerid varchar(255),
	provideruserid varchar(255),
	social_id varchar(255),
	firstname varchar(255),
	lastname varchar(255),
	email	varchar(255),
	password varchar(255),
	aboutme varchar(255),
	location varchar(255),
	latitude double,
	longitude double,
	image   MEDIUMBLOB,
	primary key (userid)
)