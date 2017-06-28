load data
infile 'dane\adresy.csv'
into table adresy
replace
fields terminated by ';' 
( adres_id char,
nr_domu char,
miejscowosc char,
kod_pocztowy char,
poczta char,
nr_mieszkania char,
ulica char
)