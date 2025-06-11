-- 사이즈 테이블
create table size(
	size_id int	primary key auto_increment,
	size_name varchar(20)
);

-- 상품 테이블
create table product (
	product_id int primary key auto_increment
	, prdouct_name varchar(25)
	, brand varchar(15)
	, price int default 0
	, discount int default 0
	, introduce varchar(250)
	, detail text
	, subcategory_id int 
	, constraint fk_subcategory_product foreign key(subcategory_id) 
	references subcategory(subcategory_id)
);

-- 해당 상품의 사이즈 정보
create table product_size(
	product_size_id int primary key auto_increment
	, product_id int 
	, size_id int
	, constraint fk_product_product_size foreign key(product_id)
	references product(product_id)
	, constraint fk_size_product_size foreign key(size_id)
	references size(size_id)
);

-- 해당 상품의 색상 정보
create table product_color(
	product_color_id int primary key auto_increment
	, product_id int 
	, color_id int
	, constraint fk_product_product_color foreign key(product_id)
	references product(product_id)
	, constraint fk_color_product_color foreign key(color_id)
	references color(color_id)
);

