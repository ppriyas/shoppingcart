create table cartitem(id bigint not null auto_increment,
    productName varchar(50) not null,
    price double not null,
    quantity int not null,
    primary key (id)
);

insert into cartitem values(1,'abc',2.0,1);		