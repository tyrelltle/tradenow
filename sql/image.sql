create table image(
	img_id 			int not null AUTO_INCREMENT,
	prod_id 		int not null,
    image_type      varchar(25) default '',
    image           MEDIUMBLOB,
    image_size      int,
    image_name      varchar(50) default '',
   
    FOREIGN KEY (prod_id) REFERENCES product (prod_id) ON DELETE CASCADE ON UPDATE CASCADE,
    primary key (img_id)
)