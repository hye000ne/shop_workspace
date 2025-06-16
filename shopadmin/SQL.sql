---------------------------
--어드민 표
---------------------------
create table admin(
	admin_id int primary key auto_increment,
	id varchar(20),
	pwd varchar(20),
	name varchar(20),
	email varchar(20));
---------------------------
--최상위 카테고리
---------------------------
CREATE TABLE topcategory(
	topcategory_id int PRIMARY KEY auto_increment,
	top_name varchar(20)
);
---------------------------
--하위 카테고리
---------------------------
create table subcategory(
	subcategory_id int primary key auto_increment,
	sub_name varchar(20),
	topcategory_id int,
	constraint fk_topcategory_subcategory foreign key(topcategory_id)
	references topcategory(topcategory_id)
);
insert into topcategory(top_name) values('상의');
insert into topcategory(top_name) values('하의');
insert into topcategory(top_name) values('신발');
insert into topcategory(top_name) values('액세서리');
insert into subcategory(sub_name, topcategory_id) values('티셔츠', 1);
insert into subcategory(sub_name, topcategory_id) values('가디건', 1);
insert into subcategory(sub_name, topcategory_id) values('점퍼', 1);
insert into subcategory(sub_name, topcategory_id) values('셔츠', 1);
insert into subcategory(sub_name, topcategory_id) values('치마', 2);
insert into subcategory(sub_name, topcategory_id) values('반바지', 2);
insert into subcategory(sub_name, topcategory_id) values('청바지', 2);
insert into subcategory(sub_name, topcategory_id) values('면바지', 2);
insert into subcategory(sub_name, topcategory_id) values('운동화', 3);
insert into subcategory(sub_name, topcategory_id) values('구두', 3);
insert into subcategory(sub_name, topcategory_id) values('슬리퍼', 3);
insert into subcategory(sub_name, topcategory_id) values('샌들', 3);
insert into subcategory(sub_name, topcategory_id) values('반지', 4);
insert into subcategory(sub_name, topcategory_id) values('목걸이', 4);
insert into subcategory(sub_name, topcategory_id) values('팔지', 4);
insert into subcategory(sub_name, topcategory_id) values('귀걸이', 4);
---------------------------
--색상 표
---------------------------
create table color(
	color_id int primary key auto_increment,
	color_name varchar(15));
---------------------------
--사이즈 표
---------------------------
create table size(
	size_id int primary key auto_increment,
	size varchar(10));
---------------------------
--상품 테이블
---------------------------
create table product(
	product_id int primary key auto_increment
	, product_name varchar(20)
	, brand varchar(15)
	, price int default 0
	, discount int default 0
	, introduce varchar(250)
	, detail text
	, subcategory_id int
	, constraint fk_subcategory_product foreign key(subcategory_id)
	references subcategory(subcategory_id));
---------------------------
--상품 별 사이즈 정보
---------------------------
create table product_size(
	product_size_id int primary key auto_increment,
	product_id int,
	size_id int,
	constraint fk_product_product_size foreign key(product_id)
	references product(product_id),
	constraint fk_size_product_size foreign key(size_id)
	references size(size_id));
---------------------------
--상품 별 색상 정보
---------------------------
create table product_color(
	product_color_id int primary key auto_increment,
	product_id int,
	color_id int,
	constraint fk_product_product_color foreign key(product_id)
	references product(product_id),
	constraint fk_color_product_color foreign key(color_id)
	references color(color_id));

select * from product_color;

