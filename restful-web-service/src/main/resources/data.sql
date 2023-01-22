insert into user_details(id, name, birth_date) values(1001, 'Dani', current_date());
insert into user_details(id, name, birth_date) values(1002, 'Maya', current_date());
insert into user_details(id, name, birth_date) values(1003, 'Winda', current_date());

insert into posting(id, user_id, description) values(2001, 1001, 'I want to learn AWS');
insert into posting(id, user_id, description) values(2002, 1001, 'I want to learn Docker');
insert into posting(id, user_id, description) values(2003, 1001, 'I want to learn OAuth2');
insert into posting(id, user_id, description) values(2004, 1001, 'I want to learn Vault');
insert into posting(id, user_id, description) values(2005, 1001, 'I want to learn Keycloak');
insert into posting(id, user_id, description) values(2006, 1002, 'I want to learn Cooking');
insert into posting(id, user_id, description) values(2007, 1003, 'I want to learn Matlab');