load data
infile 'dane\klienci.csv'
into table klienci
replace
fields terminated by ';' 
( klient_id char,
data_p_zakup date 'DD/MM/YYYY',
plec char,
osoba_id char,
adres_id char
)