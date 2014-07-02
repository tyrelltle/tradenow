create table notification(
	noti_id int not null AUTO_INCREMENT,
	userid int not null,
	msg varchar (200) not null,
	url varchar (200),
	primary key (noti_id),
	foreign key (userid) references user(userid)
)