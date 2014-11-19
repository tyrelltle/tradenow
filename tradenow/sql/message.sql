create table message(
	msgid int not null AUTO_INCREMENT,
	trade_id int not null,
	side int not null,
	msg varchar (200) not null,
	create_date timestamp not null,
	primary key (msgid),
	foreign key (trade_id) references trade(trade_id)

)