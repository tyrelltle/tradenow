create table favorite(
	userid int not null,
	prod_id int not null,
	primary key (userid,prod_id),
	foreign key (userid) references user(userid),
	foreign key (prod_id) references product(prod_id)
)