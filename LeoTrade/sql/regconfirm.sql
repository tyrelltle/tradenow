create table regconfirm(
	id varchar(36) not null,
	userid int not null,
	primary key (id),
	foreign key (userid) references user(userid)
)