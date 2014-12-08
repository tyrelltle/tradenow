create table trade(
	trade_id int not null AUTO_INCREMENT,
	prod1_id int,
	prod2_id int not null,
	user1_id int not null,
	user2_id int not null,
	trans_date	date not null,	
	status1	 varchar(10) default 'Pending',
	status2	 varchar(10) default 'Pending',
	method1  varchar(10) default 'In Person',
	method2  varchar(10) default 'In Person',
	primary key (trade_id),
	foreign key (prod1_id) references product(prod_id),
	foreign key (prod2_id) references product(prod_id),
	foreign key (user1_id) references user(userid),
	foreign key (user2_id) references user(userid)
)