
create table tab_inventory_for_rush1(
    id int(10) not null AUTO_INCREMENT,
    product_id int(10) not null,
    stock int(10) not null default 100,
    create_time timestamp not null default current_timestamp,
    update_time timestamp not null default current_timestamp on update current_timestamp,
    primary key (id)
)engine=innodb default charset=utf8;


create table tab_inventory_for_rush2(
    id int(10) not null AUTO_INCREMENT,
    product_id int(10) not null,
    stock int(10) not null default 100,
    create_time timestamp not null default current_timestamp,
    update_time timestamp not null default current_timestamp on update current_timestamp,
    primary key (id)
)engine=innodb default charset=utf8;


create table tab_inventory_for_rush3(
    id int(10) not null AUTO_INCREMENT,
    product_id int(10) not null,
    stock int(10) not null default 100,
    create_time timestamp not null default current_timestamp,
    update_time timestamp not null default current_timestamp on update current_timestamp,
    primary key (id)
)engine=innodb default charset=utf8;

create table tab_inventory_for_rush4(
    id int(10) not null AUTO_INCREMENT,
    product_id int(10) not null,
    stock int(10) not null default 100,
    create_time timestamp not null default current_timestamp,
    update_time timestamp not null default current_timestamp on update current_timestamp,
    primary key (id)
)engine=innodb default charset=utf8;

create table tab_inventory_for_rush5(
    id int(10) not null AUTO_INCREMENT,
    product_id int(10) not null,
    stock int(10) not null default 100,
    create_time timestamp not null default current_timestamp,
    update_time timestamp not null default current_timestamp on update current_timestamp,
    primary key (id)
)engine=innodb default charset=utf8;