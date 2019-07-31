drop database if exists ghibli;

create database ghibli;

use ghibli;

-- SCHEMA
create table movie (
	movieid int primary key auto_increment,
    title varchar(100) not null,
    posterurl varchar(512) null
);

create table `character` (
	characterid int primary key auto_increment,
    `name` varchar(100) not null,
    movieid int not null,
    constraint fk_character_movieid
		foreign key (movieid) 
        references movie(movieid)
);

create table scene (
	sceneid int primary key auto_increment,
    `name` varchar(250),
    movieid int not null,
    constraint fk_scene_movieid
		foreign key (movieid) 
        references movie(movieid)
);

create table characterscene (
	characterid int not null,
    sceneid int not null,
    constraint pk_characterscene
		primary key (characterid, sceneid),
	constraint fk_characterscene_characterid
		foreign key (characterid) 
        references `character`(characterid),
	constraint fk_characterscene_sceneid
		foreign key (sceneid) 
        references `scene`(sceneid)
);

-- DATA
insert into movie (movieid, title, posterurl) 
	values
	(1, 'Nausicaä of the Valley of the Wind', 'https://upload.wikimedia.org/wikipedia/en/b/bc/Nausicaaposter.jpg'),
    (2, 'My Neighbor Totoro', 'https://upload.wikimedia.org/wikipedia/en/0/02/My_Neighbor_Totoro_-_Tonari_no_Totoro_%28Movie_Poster%29.jpg'),
    (3, 'Kiki''s Delivery Service', 'https://upload.wikimedia.org/wikipedia/en/0/07/Kiki%27s_Delivery_Service_%28Movie%29.jpg'),
    (4, 'Princess Mononoke', 'https://upload.wikimedia.org/wikipedia/en/8/8c/Princess_Mononoke_Japanese_poster.png'),
    (5, 'Spirited Away', 'https://upload.wikimedia.org/wikipedia/en/d/db/Spirited_Away_Japanese_poster.png'),
    (6, 'Howl''s Moving Castle', 'https://upload.wikimedia.org/wikipedia/en/a/a0/Howls-moving-castleposter.jpg');
    
insert into `character` (characterid, `name`, movieid)
	values
    (1, 'Nausicaä', 1),
    (2, 'Lord Yupa', 1),
    (3, 'Satsuki Kusakabe', 2),
    (4, 'Mei Kusakabe', 2),
    (5, 'Chihiro Ogino', 5),
    (6, 'Haku', 5),
    (7, 'Kamaji', 5);
    
insert into scene (sceneid, `name`, movieid)
	values
    (1, 'the death of Nausicaä''a father', 1),
    (2, 'waiting for the bus in the rain', 2),
    (3, 'turning invisible', 5),
    (4, 'first meeting Kamaji', 5);
    
insert into characterscene (characterid, sceneid)
	values
    (1, 1),
	(2, 1),
    (3, 2),
    (4, 2),
    (5, 3),
    (6, 3),
    (5, 4),
    (7, 4);
    
    
    
