-- Tables

CREATE TABLE IF NOT EXISTS brand (
    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    name varchar(30) NOT NULL
);

CREATE TABLE IF NOT EXISTS category (
    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    name varchar(30) NOT NULL,
    category_id integer NULL,
    CONSTRAINT category_category
        FOREIGN KEY (category_id)
        REFERENCES category (id)
);

CREATE TABLE IF NOT EXISTS item (
    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    category_id integer NOT NULL,
    size_id integer NOT NULL,
    brand_id integer NULL,
    seller_id integer NOT NULL,
    name varchar(40) NOT NULL,
    status integer NOT NULL,
    description varchar(150) NOT NULL,
    price decimal(5,2) NOT NULL,
    user_id integer NULL,
    CONSTRAINT item_category
        FOREIGN KEY (category_id)
        REFERENCES category (id),
    CONSTRAINT item_size
        FOREIGN KEY (size_id)
        REFERENCES size (id),
    CONSTRAINT item_brand
        FOREIGN KEY (brand_id)
        REFERENCES brand (id),
    CONSTRAINT item_user
        FOREIGN KEY (user_id)
        REFERENCES "user" (id),
    CONSTRAINT item_user_seller
        FOREIGN KEY (seller_id)
        REFERENCES "user" (id)
);

CREATE TABLE IF NOT EXISTS liked_items (
    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    user_id integer NOT NULL,
    item_id integer NOT NULL,
    CONSTRAINT liked_items_item
        FOREIGN KEY (item_id)
        REFERENCES item (id),
    CONSTRAINT liked_items_user
        FOREIGN KEY (user_id)
        REFERENCES "user" (id)
);

CREATE TABLE IF NOT EXISTS picture (
    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    item_id integer NOT NULL,
    file_name varchar(30) NOT NULL,
    file_location varchar NOT NULL,
    CONSTRAINT picture_item
        FOREIGN KEY (item_id)
        REFERENCES item (id)
);

CREATE TABLE IF NOT EXISTS size (
    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    name varchar(15) NOT NULL
);

CREATE TABLE IF NOT EXISTS "user" (
    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    name varchar(40) NOT NULL,
    email varchar(40) NOT NULL,
    password varchar(20) NOT NULL,
    address varchar(40) NOT NULL,
    additional_info varchar(200) NOT NULL
);
