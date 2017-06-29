load data
infile 'dane\na_stanie.csv'
into table na_stanie
replace
fields terminated by ';' 
( id_stanu char,
wartosc char,
miejscowosc char,
nr_garazu char,
pozycja char,
samochod_id char
)