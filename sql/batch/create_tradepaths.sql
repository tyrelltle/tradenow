
/*manually create a user first which will have userid=1. manually create because sql script can not create encrypted password*/
/*insert into user (userid,firstname,lastname,email,password,latitude,longitude) values (1,'admin','user','t@t.t','asd',53.7266683,-127.6476206);*/
insert into user (userid,firstname,lastname,email,password,latitude,longitude) values (2,'asd','dsa','t2@t.t','asd',53.7266683,-127.6476206);
insert into user (userid,firstname,lastname,email,password,latitude,longitude) values (3,'assd','usfer','t3@t.t','asd',53.7266683,-127.6476206);
insert into user (userid,firstname,lastname,email,password,latitude,longitude) values (4,'adsmin','ugser','t4@t.t','asd',53.7266683,-127.6476206);
insert into user (userid,firstname,lastname,email,password,latitude,longitude) values (5,'adxmin','usvr','t5@t.t','asd',53.7266683,-127.6476206);
insert into user (userid,firstname,lastname,email,password,latitude,longitude) values (6,'admisn','uster','t6@t.t','asd',53.7266683,-127.6476206);
insert into user (userid,firstname,lastname,email,password,latitude,longitude) values (7,'admfsin','usdser','t7@t.t','asd',53.7266683,-127.6476206);
insert into user (userid,firstname,lastname,email,password,latitude,longitude) values (8,'adfamin','ussger','t8@t.t','asd',53.7266683,-127.6476206);
insert into user (userid,firstname,lastname,email,password,latitude,longitude) values (9,'admsain','udfsfser','t9@t.t','asd',53.7266683,-127.6476206);



insert into product (prod_id,ownerid,catid,title,latitude,longitude) values (1,1,1,'prod1',53.7266683,-127.6476206);
insert into product (prod_id,ownerid,catid,title,latitude,longitude) values (2,2,1,'prod2',53.7266683,-127.6476206);
insert into product (prod_id,ownerid,catid,title,latitude,longitude) values (3,3,1,'prod3',53.7266683,-127.6476206);
insert into product (prod_id,ownerid,catid,title,latitude,longitude) values (4,4,1,'prod4',53.7266683,-127.6476206);
insert into product (prod_id,ownerid,catid,title,latitude,longitude) values (5,5,1,'prod5',53.7266683,-127.6476206);
insert into product (prod_id,ownerid,catid,title,latitude,longitude) values (6,6,1,'prod6',53.7266683,-127.6476206);
insert into product (prod_id,ownerid,catid,title,latitude,longitude) values (7,7,1,'prod7',53.7266683,-127.6476206);
insert into product (prod_id,ownerid,catid,title,latitude,longitude) values (8,8,1,'prod8',53.7266683,-127.6476206);
insert into product (prod_id,ownerid,catid,title,latitude,longitude) values (9,9,1,'prod9',53.7266683,-127.6476206);


insert into trade (trade_id,prod1_id,prod2_id,user1_id,user2_id,status1,status2,trans_date) values (1,1,2,1,2,'ACCEPTED','ACCEPTED',NOW());
insert into trade (trade_id,prod1_id,prod2_id,user1_id,user2_id,status1,status2,trans_date) values (2,2,3,1,3,'ACCEPTED','ACCEPTED',NOW());
insert into trade (trade_id,prod1_id,prod2_id,user1_id,user2_id,status1,status2,trans_date) values (3,3,4,1,4,'ACCEPTED','ACCEPTED',NOW());
insert into trade (trade_id,prod1_id,prod2_id,user1_id,user2_id,status1,status2,trans_date) values (4,4,5,1,5,'ACCEPTED','ACCEPTED',NOW());
insert into trade (trade_id,prod1_id,prod2_id,user1_id,user2_id,status1,status2,trans_date) values (5,5,6,1,6,'ACCEPTED','ACCEPTED',NOW());
insert into trade (trade_id,prod1_id,prod2_id,user1_id,user2_id,status1,status2,trans_date) values (6,6,7,1,7,'ACCEPTED','ACCEPTED',NOW());
insert into trade (trade_id,prod1_id,prod2_id,user1_id,user2_id,status1,status2,trans_date) values (7,7,8,1,8,'ACCEPTED','ACCEPTED',NOW());

