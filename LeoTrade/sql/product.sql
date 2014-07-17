create table product(
	prod_id int not null AUTO_INCREMENT,
	ownerid int not null,
	catid int not null,
	title varchar (30) not null default '',
	detail varchar (200) default '',
	price float default 0,
	quantity int not null default 0,
	status varchar (3) not null default '',
	tradefor varchar(200) default '',
	thumurl varchar(200) default '',
	latitude double,
	longitude double,
	primary key (prod_id),
	foreign key (catid) references category(catid),
	foreign key (ownerid) references user(userid)
)