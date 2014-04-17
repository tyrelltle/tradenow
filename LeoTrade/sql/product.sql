create table product(
	id int not null AUTO_INCREMENT,
	name varchar(255) not null,
	unitprice	float not null,
	colorbag varchar(255),
	catid int,
	primary key (id),
	foreign key (catid) references category(catid)

)