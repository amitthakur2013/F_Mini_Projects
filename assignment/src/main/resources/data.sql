insert into role values(1,'CONSUMER'),(2,'SELLER');

insert into user(`user_id`,`username`,`password`) values(1,'jack','pass_word'),(2,'bob','pass_word'),(3,'apple','pass_word'),(4,'glaxo','pass_word');

insert into user_role values(1,1),(2,1),(3,2),(4,2);

insert into category(`category_id`,`category_name`) values(1,'Fashion'),(2,'Electronics'),(3,'Books'),(4,'Groceries'),(5,'Medicines');

insert into product values(1,29190,'Apple iPad 10.2 8th Gen WiFi iOS Tablet',2,3),(2,10,'Crocin pain relief tablet',5,4);

insert into cart values(1,20,1),(2,0,2);

insert into cart_product(`cp_id`,`cart_id`,`product_id`,`quantity`) values(1,1,2,2);