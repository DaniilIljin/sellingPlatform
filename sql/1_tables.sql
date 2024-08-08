-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2024-08-08 20:12:25.064

-- tables
-- Table: brand
CREATE TABLE brand (
    id serial  NOT NULL,
    name varchar(30)  NOT NULL,
    CONSTRAINT brand_pk PRIMARY KEY (id)
);

-- Table: category
CREATE TABLE category (
    id serial  NOT NULL,
    name varchar(30)  NOT NULL,
    category_id int  NULL,
    CONSTRAINT category_pk PRIMARY KEY (id)
);

-- Table: item
CREATE TABLE item (
    id serial  NOT NULL,
    category_id int  NOT NULL,
    size_id int  NOT NULL,
    brand_id int  NULL,
    seller_id int  NOT NULL,
    name varchar(40)  NOT NULL,
    status int  NOT NULL,
    description varchar(150)  NOT NULL,
    price decimal(5,2)  NOT NULL,
    user_id int  NULL,
    CONSTRAINT item_pk PRIMARY KEY (id)
);

-- Table: liked_items
CREATE TABLE liked_items (
    id serial  NOT NULL,
    user_id int  NOT NULL,
    item_id int  NOT NULL,
    CONSTRAINT liked_items_pk PRIMARY KEY (id)
);

-- Table: picture
CREATE TABLE picture (
    id serial  NOT NULL,
    item_id int  NOT NULL,
    file_name varchar(30)  NOT NULL,
    file_location varchar  NOT NULL,
    CONSTRAINT picture_pk PRIMARY KEY (id)
);

-- Table: size
CREATE TABLE size (
    id serial  NOT NULL,
    name varchar(15)  NOT NULL,
    CONSTRAINT size_pk PRIMARY KEY (id)
);

-- Table: user
CREATE TABLE "user" (
    id serial  NOT NULL,
    name varchar(40)  NOT NULL,
    email varchar(40)  NOT NULL,
    password varchar(20)  NOT NULL,
    address varchar(40)  NOT NULL,
    additional_info varchar(200)  NOT NULL,
    CONSTRAINT user_pk PRIMARY KEY (id)
);

-- foreign keys
-- Reference: category_category (table: category)
ALTER TABLE category ADD CONSTRAINT category_category
    FOREIGN KEY (category_id)
    REFERENCES category (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: item_brand (table: item)
ALTER TABLE item ADD CONSTRAINT item_brand
    FOREIGN KEY (brand_id)
    REFERENCES brand (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: item_category (table: item)
ALTER TABLE item ADD CONSTRAINT item_category
    FOREIGN KEY (category_id)
    REFERENCES category (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: item_size (table: item)
ALTER TABLE item ADD CONSTRAINT item_size
    FOREIGN KEY (size_id)
    REFERENCES size (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: item_user (table: item)
ALTER TABLE item ADD CONSTRAINT item_user
    FOREIGN KEY (user_id)
    REFERENCES "user" (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: item_user_seller (table: item)
ALTER TABLE item ADD CONSTRAINT item_user_seller
    FOREIGN KEY (seller_id)
    REFERENCES "user" (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: liked_items_item (table: liked_items)
ALTER TABLE liked_items ADD CONSTRAINT liked_items_item
    FOREIGN KEY (item_id)
    REFERENCES item (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: liked_items_user (table: liked_items)
ALTER TABLE liked_items ADD CONSTRAINT liked_items_user
    FOREIGN KEY (user_id)
    REFERENCES "user" (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: picture_item (table: picture)
ALTER TABLE picture ADD CONSTRAINT picture_item
    FOREIGN KEY (item_id)
    REFERENCES item (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- End of file.

