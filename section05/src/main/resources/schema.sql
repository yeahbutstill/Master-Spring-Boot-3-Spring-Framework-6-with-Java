create table course (
  id bigint not null,
  name varchar(30) not null,
  author varchar(30) not null,
  primary key(id)
);

insert into course(id, name, author) values(1, "Learn AWS", "Yeahbutstill");
insert into course(id, name, author) values(2, "Learn Docker", "Yeahbutstill");
insert into course(id, name, author) values(3, "Learn Vault", "Yeahbutstill");
insert into course(id, name, author) values(4, "Learn Key Cloak", "Yeahbutstill");
insert into course(id, name, author) values(5, "Learn OAuth2", "Yeahbutstill");
