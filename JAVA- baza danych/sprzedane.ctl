load data
infile 'dane\sprzedane.csv'
into table sprzedane
replace
fields terminated by ';' 
( id_sprzedazy char,
data_sprzedazy date 'DD/MM/YYYY',
kwota_sprzed char,
samochod_id char,
klient_id char,
sprzed_pracow_id char
)