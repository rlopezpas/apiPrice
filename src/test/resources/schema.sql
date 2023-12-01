-- Tabla PRICE_TARIFF

DROP TABLE IF EXISTS PRICE_TARIFF;

CREATE TABLE PRICE_TARIFF (
    PRICE_ID INT PRIMARY KEY, -- ID de tabla
    BRAND_ID INT, -- foreing key de brand
    START_DATE TIMESTAMP, -- fecha inicio  de precio de producto
    END_DATE TIMESTAMP, -- fecha fin de precio de producto
    PRICE_LIST INT, -- id de tarifa aplicable
    PRODUCT_ID INT, -- foreing key de producto
    PRIORITY INT, -- prioridad de precio
    FINAL_PRICE DECIMAL(10, 2), -- precio del producto
    CURRENCY_ISO VARCHAR(3) -- tipo de moneda
);
