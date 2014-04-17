create table custproduct(

	custprodid int not null AUTO_INCREMENT,
	guid	varchar(255) not null,
	id int not null,
	quantity int not null,
	len	float not null,
	color varchar(255) not null,
	primary key (custprodid),
	foreign key (id) references product(id)

)