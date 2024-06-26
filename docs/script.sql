create database if not exists dbtravelsystem;
use dbtravelsystem; 

create table if not exists user (
    id int auto_increment,
    password varchar(100) not null,
    login varchar(100) not null,
    role int default 1,
    primary key(id)
)ENGINE=INNODB CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=1; 

create table if not exists country (
    id int auto_increment,
    name varchar(100),
    primary key(id)
)ENGINE=INNODB CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=1;

create table if not exists place_visited (
    id int auto_increment,
    image varchar(100) not null,
    name varchar(100) not null,
    id_country int,
    id_user int,
    primary key(id),
    constraint foreign key(id_country) references country(id) on delete cascade on update cascade,
    constraint foreign key(id_user) references user(id) on delete cascade on update cascade
)ENGINE=INNODB CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=1;


create table if not exists experience (
    id int auto_increment,
    content varchar(100) not null,
    rating int default null,
    total_cost double not null,
    arrival_day date not null,
    departure_day date not null,
    id_place_visited int not null,
    id_user int not null,
    primary key(id),
    constraint foreign key(id_place_visited) references place_visited(id) on delete cascade on update cascade,
    constraint foreign key(id_user) references user(id) on delete cascade on update cascade
)ENGINE=INNODB CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=1; 

create table if not exists comment (
    id int auto_increment,
    content varchar(100),
    id_user int not null,
    id_experience int not null,
    primary key(id),
    constraint foreign key(id_user) references user(id) on delete cascade on update cascade,
    constraint foreign key(id_experience) references experience(id) on delete cascade on update cascade	
)ENGINE=INNODB CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=1; 



-- Countries inserts --

INSERT INTO country (name) VALUES ('Afghanistan');
INSERT INTO country (name) VALUES ('Albania');
INSERT INTO country (name) VALUES ('Algeria');
INSERT INTO country (name) VALUES ('American Samoa');
INSERT INTO country (name) VALUES ('Andorra');
INSERT INTO country (name) VALUES ('Angola');
INSERT INTO country (name) VALUES ('Anguilla');
INSERT INTO country (name) VALUES ('Antarctica');
INSERT INTO country (name) VALUES ('Antigua and Barbuda');
INSERT INTO country (name) VALUES ('Argentina');
INSERT INTO country (name) VALUES ('Armenia');
INSERT INTO country (name) VALUES ('Aruba');
INSERT INTO country (name) VALUES ('Australia');
INSERT INTO country (name) VALUES ('Austria');
INSERT INTO country (name) VALUES ('Azerbaijan');
INSERT INTO country (name) VALUES ('Bahamas');
INSERT INTO country (name) VALUES ('Bahrain');
INSERT INTO country (name) VALUES ('Bangladesh');
INSERT INTO country (name) VALUES ('Barbados');
INSERT INTO country (name) VALUES ('Belarus');
INSERT INTO country (name) VALUES ('Belgium');
INSERT INTO country (name) VALUES ('Belize');
INSERT INTO country (name) VALUES ('Benin');
INSERT INTO country (name) VALUES ('Bermuda');
INSERT INTO country (name) VALUES ('Bhutan');
INSERT INTO country (name) VALUES ('Bosnia and Herzegovina');
INSERT INTO country (name) VALUES ('Botswana');
INSERT INTO country (name) VALUES ('Bouvet Island');
INSERT INTO country (name) VALUES ('Brazil');
INSERT INTO country (name) VALUES ('British Indian Ocean Territory');
INSERT INTO country (name) VALUES ('Brunei Darussalam');
INSERT INTO country (name) VALUES ('Bulgaria');
INSERT INTO country (name) VALUES ('Burkina Faso');
INSERT INTO country (name) VALUES ('Burundi');
INSERT INTO country (name) VALUES ('Cambodia');
INSERT INTO country (name) VALUES ('Cameroon');
INSERT INTO country (name) VALUES ('Canada');
INSERT INTO country (name) VALUES ('Cape Verde');
INSERT INTO country (name) VALUES ('Cayman Islands');
INSERT INTO country (name) VALUES ('Central African Republic');
INSERT INTO country (name) VALUES ('Chad');
INSERT INTO country (name) VALUES ('Chile');
INSERT INTO country (name) VALUES ('China');
INSERT INTO country (name) VALUES ('Christmas Island');
INSERT INTO country (name) VALUES ('Cocos (Keeling) Islands');
INSERT INTO country (name) VALUES ('Colombia');
INSERT INTO country (name) VALUES ('Comoros');
INSERT INTO country (name) VALUES ('Congo');
INSERT INTO country (name) VALUES ('Cook Islands');
INSERT INTO country (name) VALUES ('Costa Rica');
INSERT INTO country (name) VALUES ('Croatia');
INSERT INTO country (name) VALUES ('Cuba');
INSERT INTO country (name) VALUES ('Cyprus');
INSERT INTO country (name) VALUES ('Czech Republic');
INSERT INTO country (name) VALUES ('Denmark');
INSERT INTO country (name) VALUES ('Djibouti');
INSERT INTO country (name) VALUES ('Dominica');
INSERT INTO country (name) VALUES ('Dominican Republic');
INSERT INTO country (name) VALUES ('Ecuador');
INSERT INTO country (name) VALUES ('Egypt');
INSERT INTO country (name) VALUES ('El Salvador');
INSERT INTO country (name) VALUES ('Equatorial Guinea');
INSERT INTO country (name) VALUES ('Eritrea');
INSERT INTO country (name) VALUES ('Estonia');
INSERT INTO country (name) VALUES ('Ethiopia');
INSERT INTO country (name) VALUES ('Falkland Islands (Malvinas)');
INSERT INTO country (name) VALUES ('Faroe Islands');
INSERT INTO country (name) VALUES ('Fiji');
INSERT INTO country (name) VALUES ('Finland');
INSERT INTO country (name) VALUES ('France');
INSERT INTO country (name) VALUES ('French Guiana');
INSERT INTO country (name) VALUES ('French Polynesia');
INSERT INTO country (name) VALUES ('French Southern Territories');
INSERT INTO country (name) VALUES ('Gabon');
INSERT INTO country (name) VALUES ('Gambia');
INSERT INTO country (name) VALUES ('Georgia');
INSERT INTO country (name) VALUES ('Germany');
INSERT INTO country (name) VALUES ('Ghana');
INSERT INTO country (name) VALUES ('Gibraltar');
INSERT INTO country (name) VALUES ('Greece');
INSERT INTO country (name) VALUES ('Greenland');
INSERT INTO country (name) VALUES ('Grenada');
INSERT INTO country (name) VALUES ('Guadeloupe');
INSERT INTO country (name) VALUES ('Guam');
INSERT INTO country (name) VALUES ('Guatemala');
INSERT INTO country (name) VALUES ('Guernsey');
INSERT INTO country (name) VALUES ('Guinea');
INSERT INTO country (name) VALUES ('Guinea-Bissau');
INSERT INTO country (name) VALUES ('Guyana');
INSERT INTO country (name) VALUES ('Haiti');
INSERT INTO country (name) VALUES ('Heard Island and McDonald Islands');
INSERT INTO country (name) VALUES ('Holy See (Vatican City State)');
INSERT INTO country (name) VALUES ('Honduras');
INSERT INTO country (name) VALUES ('Hong Kong');
INSERT INTO country (name) VALUES ('Hungary');
INSERT INTO country (name) VALUES ('Iceland');
INSERT INTO country (name) VALUES ('India');
INSERT INTO country (name) VALUES ('Indonesia');
INSERT INTO country (name) VALUES ('Iraq');
INSERT INTO country (name) VALUES ('Ireland');
INSERT INTO country (name) VALUES ('Isle of Man');
INSERT INTO country (name) VALUES ('Israel');
INSERT INTO country (name) VALUES ('Italy');
INSERT INTO country (name) VALUES ('Jamaica');
INSERT INTO country (name) VALUES ('Japan');
INSERT INTO country (name) VALUES ('Jersey');
INSERT INTO country (name) VALUES ('Jordan');
INSERT INTO country (name) VALUES ('Kazakhstan');
INSERT INTO country (name) VALUES ('Kenya');
INSERT INTO country (name) VALUES ('Kiribati');
INSERT INTO country (name) VALUES ('Kuwait');
INSERT INTO country (name) VALUES ('Kyrgyzstan');
INSERT INTO country (name) VALUES ('Lao Peoples Democratic Republic');
INSERT INTO country (name) VALUES ('Latvia');
INSERT INTO country (name) VALUES ('Lebanon');
INSERT INTO country (name) VALUES ('Lesotho');
INSERT INTO country (name) VALUES ('Liberia');
INSERT INTO country (name) VALUES ('Libya');
INSERT INTO country (name) VALUES ('Liechtenstein');
INSERT INTO country (name) VALUES ('Lithuania');
INSERT INTO country (name) VALUES ('Luxembourg');
INSERT INTO country (name) VALUES ('Macao');
INSERT INTO country (name) VALUES ('Madagascar');
INSERT INTO country (name) VALUES ('Malawi');
INSERT INTO country (name) VALUES ('Malaysia');
INSERT INTO country (name) VALUES ('Maldives');
INSERT INTO country (name) VALUES ('Mali');
INSERT INTO country (name) VALUES ('Malta');
INSERT INTO country (name) VALUES ('Marshall Islands');
INSERT INTO country (name) VALUES ('Martinique');
INSERT INTO country (name) VALUES ('Mauritania');
INSERT INTO country (name) VALUES ('Mauritius');
INSERT INTO country (name) VALUES ('Mayotte');
INSERT INTO country (name) VALUES ('Mexico');
INSERT INTO country (name) VALUES ('Monaco');
INSERT INTO country (name) VALUES ('Mongolia');
INSERT INTO country (name) VALUES ('Montenegro');
INSERT INTO country (name) VALUES ('Montserrat');
INSERT INTO country (name) VALUES ('Morocco');
INSERT INTO country (name) VALUES ('Mozambique');
INSERT INTO country (name) VALUES ('Myanmar');
INSERT INTO country (name) VALUES ('Namibia');
INSERT INTO country (name) VALUES ('Nauru');
INSERT INTO country (name) VALUES ('Nepal');
INSERT INTO country (name) VALUES ('Netherlands');
INSERT INTO country (name) VALUES ('New Caledonia');
INSERT INTO country (name) VALUES ('New Zealand');
INSERT INTO country (name) VALUES ('Nicaragua');
INSERT INTO country (name) VALUES ('Niger');
INSERT INTO country (name) VALUES ('Nigeria');
INSERT INTO country (name) VALUES ('Niue');
INSERT INTO country (name) VALUES ('Norfolk Island');
INSERT INTO country (name) VALUES ('Northern Mariana Islands');
INSERT INTO country (name) VALUES ('Norway');
INSERT INTO country (name) VALUES ('Oman');
INSERT INTO country (name) VALUES ('Pakistan');
INSERT INTO country (name) VALUES ('Palau');
INSERT INTO country (name) VALUES ('Panama');
INSERT INTO country (name) VALUES ('Papua New Guinea');
INSERT INTO country (name) VALUES ('Paraguay');
INSERT INTO country (name) VALUES ('Peru');
INSERT INTO country (name) VALUES ('Philippines');
INSERT INTO country (name) VALUES ('Pitcairn');
INSERT INTO country (name) VALUES ('Poland');
INSERT INTO country (name) VALUES ('Portugal');
INSERT INTO country (name) VALUES ('Puerto Rico');
INSERT INTO country (name) VALUES ('Qatar');
INSERT INTO country (name) VALUES ('Romania');
INSERT INTO country (name) VALUES ('Russian Federation');
INSERT INTO country (name) VALUES ('Rwanda');
INSERT INTO country (name) VALUES ('Saint Kitts and Nevis');
INSERT INTO country (name) VALUES ('Saint Lucia');
INSERT INTO country (name) VALUES ('Saint Martin (French part)');
INSERT INTO country (name) VALUES ('Saint Pierre and Miquelon');
INSERT INTO country (name) VALUES ('Saint Vincent and the Grenadines');
INSERT INTO country (name) VALUES ('Samoa');
INSERT INTO country (name) VALUES ('San Marino');
INSERT INTO country (name) VALUES ('Sao Tome and Principe');
INSERT INTO country (name) VALUES ('Saudi Arabia');
INSERT INTO country (name) VALUES ('Senegal');
INSERT INTO country (name) VALUES ('Serbia');
INSERT INTO country (name) VALUES ('Seychelles');
INSERT INTO country (name) VALUES ('Sierra Leone');
INSERT INTO country (name) VALUES ('Singapore');
INSERT INTO country (name) VALUES ('Sint Maarten (Dutch part)');
INSERT INTO country (name) VALUES ('Slovakia');
INSERT INTO country (name) VALUES ('Slovenia');
INSERT INTO country (name) VALUES ('Solomon Islands');
INSERT INTO country (name) VALUES ('Somalia');
INSERT INTO country (name) VALUES ('South Africa');
INSERT INTO country (name) VALUES ('South Georgia and the South Sandwich Islands');
INSERT INTO country (name) VALUES ('South Sudan');
INSERT INTO country (name) VALUES ('Spain');
INSERT INTO country (name) VALUES ('Sri Lanka');
INSERT INTO country (name) VALUES ('Sudan');
INSERT INTO country (name) VALUES ('Suriname');
INSERT INTO country (name) VALUES ('Svalbard and Jan Mayen');
INSERT INTO country (name) VALUES ('Swaziland');
INSERT INTO country (name) VALUES ('Sweden');
INSERT INTO country (name) VALUES ('Switzerland');
INSERT INTO country (name) VALUES ('Syrian Arab Republic');
INSERT INTO country (name) VALUES ('Tajikistan');
INSERT INTO country (name) VALUES ('Thailand');
INSERT INTO country (name) VALUES ('Timor-Leste');
INSERT INTO country (name) VALUES ('Togo');
INSERT INTO country (name) VALUES ('Tokelau');
INSERT INTO country (name) VALUES ('Tonga');
INSERT INTO country (name) VALUES ('Trinidad and Tobago');
INSERT INTO country (name) VALUES ('Tunisia');
INSERT INTO country (name) VALUES ('Turkey');
INSERT INTO country (name) VALUES ('Turkmenistan');
INSERT INTO country (name) VALUES ('Turks and Caicos Islands');
INSERT INTO country (name) VALUES ('Tuvalu');
INSERT INTO country (name) VALUES ('Uganda');
INSERT INTO country (name) VALUES ('Ukraine');
INSERT INTO country (name) VALUES ('United Arab Emirates');
INSERT INTO country (name) VALUES ('United Kingdom');
INSERT INTO country (name) VALUES ('United States');
INSERT INTO country (name) VALUES ('United States Minor Outlying Islands');
INSERT INTO country (name) VALUES ('Uruguay');
INSERT INTO country (name) VALUES ('Uzbekistan');
INSERT INTO country (name) VALUES ('Vanuatu');
INSERT INTO country (name) VALUES ('Viet Nam');
INSERT INTO country (name) VALUES ('Wallis and Futuna');
INSERT INTO country (name) VALUES ('Western Sahara');
INSERT INTO country (name) VALUES ('Yemen');
INSERT INTO country (name) VALUES ('Zambia');
INSERT INTO country (name) VALUES ('Zimbabwe');
INSERT INTO user (password, login, role) VALUES ('admin', 'admin', 2);
