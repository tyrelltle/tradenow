create table image(
	img_id 			int not null AUTO_INCREMENT,
    image_type      varchar(25) default '',
    image           blob        not null,
    image_size      varchar(25) default '',
    image_name      varchar(50) default '',
    primary key (img_id)
)