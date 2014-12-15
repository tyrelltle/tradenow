use leotrade;
delete from userconnection where userid=43;
delete from favorite where userid = 43;
delete from favorite where prod_id in (select prod_id from product where ownerid=43);

delete from message where trade_id in (select trade_id from trade where p
rod1_id in (select prod_id from product where ownerid=43));

delete from message where trade_id in (select trade_id from trade where p
rod2_id in (select prod_id from product where ownerid=43));

delete from trade where prod1_id in (select prod_id from product where ow
nerid=43);

delete from trade where prod2_id in (select prod_id from product where ow
nerid=43);

delete from product where ownerid=43;
delete from notification where userid=43;
delete from regconfirm where userid=43;
delete from user_roles where userid=43;
delete from user where userid=43;
exit
