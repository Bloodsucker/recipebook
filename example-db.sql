# create table hibernate_sequence (next_val bigint) engine=InnoDB;
# insert into hibernate_sequence values ( 1 );
# create table ingredient (id bigint not null, is_vegetarian bit, name varchar(255), primary key (id)) engine=InnoDB;
# create table recipe (id bigint not null, name varchar(255), instructions TEXT, vegetarian bit not null, owner_id bigint not null, primary key (id)) engine=InnoDB;
# create table recipes_has_ingredients (amount varchar(255), recipe_id bigint not null, ingredient_id bigint not null, primary key (ingredient_id, recipe_id)) engine=InnoDB;
# create table user (id bigint not null, primary key (id)) engine=InnoDB;
# create table user_favourite_recipes (user_id bigint not null, recipe_id bigint not null) engine=InnoDB;
# alter table ingredient drop index UK_hkmmdpwcj4kux0vddoijk4tw;
# alter table ingredient add constraint UK_hkmmdpwcj4kux0vddoijk4tw unique (name);
# alter table recipe add constraint FKjuqaa5jj2ukh9k520hs9yuuwd foreign key (owner_id) references user (id);
# alter table recipes_has_ingredients add constraint FK61bfxgj140bx6dp21eidjb7ca foreign key (ingredient_id) references ingredient (id);
# alter table recipes_has_ingredients add constraint FK36u4fcc9hi274h8iijatmiswm foreign key (recipe_id) references recipe (id);
# alter table user_favourite_recipes add constraint FKa46sq7k6ou0u6ghk23pwgk47p foreign key (recipe_id) references recipe (id);
# alter table user_favourite_recipes add constraint FKit7d50cbqvptb07oviwywkivb foreign key (user_id) references user (id);

# curl localhost:8080/users -X POST -d '{}' -H "Content-Type: application/json"
-- Add users
insert into user (id) values (1);
insert into user (id) values (2);
insert into user (id) values (3);

insert into ingredient (is_vegetarian, name, id) values (true, 'potato', 4);
insert into ingredient (is_vegetarian, name, id) values (true, 'egg', 5);
insert into ingredient (is_vegetarian, name, id) values (true, 'oil', 6);
insert into ingredient (is_vegetarian, name, id) values (true, 'salt', 7);

insert into ingredient (is_vegetarian, name, id) values (true, 'onion', 8);
insert into ingredient (is_vegetarian, name, id) values (true, 'chicken', 9);
insert into ingredient (is_vegetarian, name, id) values (true, 'rabbit', 10);
insert into ingredient (is_vegetarian, name, id) values (true, 'snijbonen', 11);
insert into ingredient (is_vegetarian, name, id) values (true, 'vinager', 12);
insert into ingredient (is_vegetarian, name, id) values (true, 'tomato', 13);
insert into ingredient (is_vegetarian, name, id) values (true, 'water', 14);
insert into ingredient (is_vegetarian, name, id) values (true, 'rice', 15);
insert into ingredient (is_vegetarian, name, id) values (true, 'chicken broth', 16);
insert into ingredient (is_vegetarian, name, id) values (true, 'salmon', 17);
insert into ingredient (is_vegetarian, name, id) values (true, 'mushrooms', 18);
insert into ingredient (is_vegetarian, name, id) values (true, 'courgete', 19);
insert into ingredient (is_vegetarian, name, id) values (true, 'cream', 20);
insert into ingredient (is_vegetarian, name, id) values (true, 'penne', 21);
insert into ingredient (is_vegetarian, name, id) values (true, 'meat', 22);
insert into ingredient (is_vegetarian, name, id) values (true, 'tomato sauce', 23);
insert into ingredient (is_vegetarian, name, id) values (true, 'rice oil', 24);
insert into ingredient (is_vegetarian, name, id) values (true, 'water with salt', 25);
insert into ingredient (is_vegetarian, name, id) values (true, 'sausages', 26);
insert into ingredient (is_vegetarian, name, id) values (true, 'butter', 27);
insert into ingredient (is_vegetarian, name, id) values (true, 'smash potato', 28);

# curl http://localhost:8080/recipes/ -X POST -d '{"vegetarian": true, "description": "something", "owner": "http://localhost:8080/users/1", "ingredients":[{"amount": "2.5kg", "ingredient": "http://localhost:8080/ingredient/2"}]}' -H "Content-Type: application/json"
insert into recipe (name, instructions, owner_id, vegetarian, id) values ('Spanish Tortilla', 'Cut potato. Cut onion. Bake potato and onion on pan. Add egg. Flip a couple of times.', 1, 1, 30);
insert into recipe (name, instructions, owner_id, vegetarian, id) values ('Valencian Paella', 'Cut chicken, fry for 30 minutes. Add rabbit too. Add veggies. Fry. Add tons of water. Boil. Add rice and profit.', 1, 0, 31);
insert into recipe (name, instructions, owner_id, vegetarian, id) values ('Bolognese penne', 'Boil pasta. Fry meat. Add tomato sauce. Add oil.', 1, 0, 32);
insert into recipe (name, instructions, owner_id, vegetarian, id) values ('Salmon with courgete', 'Fry courggete, add mushrooms. Fry salmon. Serve', 1, 0, 33);
insert into recipe (name, instructions, owner_id, vegetarian, id) values ('Dutch Stamppot', 'Fry sausages on butter. Prepare smashed potatoes. Boil snijbonnen. Serve.', 1, 0, 34);


insert into recipes_has_ingredients (amount, ingredient_id, recipe_id) values ('3', 4, 30);
insert into recipes_has_ingredients (amount, ingredient_id, recipe_id) values ('1', 5, 30);
insert into recipes_has_ingredients (amount, ingredient_id, recipe_id) values ('spoon', 6, 30);
insert into recipes_has_ingredients (amount, ingredient_id, recipe_id) values ('hint', 7, 30);
insert into recipes_has_ingredients (amount, ingredient_id, recipe_id) values ('1 piece', 8, 30);

insert into recipes_has_ingredients (amount, ingredient_id, recipe_id) values ('1 full', 9, 31);
insert into recipes_has_ingredients (amount, ingredient_id, recipe_id) values ('1 full', 10, 31);
insert into recipes_has_ingredients (amount, ingredient_id, recipe_id) values ('Plenty of it', 11, 31);
insert into recipes_has_ingredients (amount, ingredient_id, recipe_id) values ('0.5kg', 15, 31);
insert into recipes_has_ingredients (amount, ingredient_id, recipe_id) values ('3 liters', 14, 31);

insert into recipes_has_ingredients (amount, ingredient_id, recipe_id) values ('1 piece', 17, 33);
insert into recipes_has_ingredients (amount, ingredient_id, recipe_id) values ('1', 19, 33);
insert into recipes_has_ingredients (amount, ingredient_id, recipe_id) values ('200 ml', 20, 33);

insert into recipes_has_ingredients (amount, ingredient_id, recipe_id) values ('2 l', 14, 32);
insert into recipes_has_ingredients (amount, ingredient_id, recipe_id) values ('0.5 kg', 21, 32);
insert into recipes_has_ingredients (amount, ingredient_id, recipe_id) values ('0.5 kg', 23, 32);
insert into recipes_has_ingredients (amount, ingredient_id, recipe_id) values ('1 spoon', 6, 32);

insert into recipes_has_ingredients (amount, ingredient_id, recipe_id) values ('1 spoon', 27, 34);
insert into recipes_has_ingredients (amount, ingredient_id, recipe_id) values ('8 sausages', 26, 34);
insert into recipes_has_ingredients (amount, ingredient_id, recipe_id) values ('1 kg', 28, 34);
insert into recipes_has_ingredients (amount, ingredient_id, recipe_id) values ('500 g', 11, 34);
