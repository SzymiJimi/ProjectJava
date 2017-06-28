load data
infile 'dane\opis.csv'
into table opis
replace
fields terminated by ';' 
( opis_id char,
skrzynia_biegow char,
stan_pojazdu char,
nadwozie char,
kraj_pochodzenia char,
serwisowany char,
dod_opis char
)