#include<stdlib.h>
#include<stdio.h>
#include<string.h>
#include<iostream>
#include<fstream>
#include<ctime>
#include <string>

#define VIN_TEMPLATE "nllllnnnlllnnnnnn"
#define	VIN_LENGTH	(17)
using namespace std;


//znalezione w sieci
void GenerateVIN(char vin[])
{
	char* p = VIN_TEMPLATE;
	int index = 0;

	for (char* p = VIN_TEMPLATE; *p != NULL; p++)
	{
		if (*p == 'n')
		{
			vin[index++] = ((int)'0') + ((int)(((1.0 * rand()) / RAND_MAX) * 10));
		}
		else
		{
			vin[index++] = ((int)'A') + ((int)(((1.0 * rand()) / RAND_MAX) * 26));
		}
	}

	vin[index] = NULL;
}


void generuj(ofstream *plik)
{
	srand(time(NULL));
	int id_zaliczenia,samochod,rok, przebieg, moc, siln, pojemn, pracownik ;
    char vin[18];
    	    string marka[] = {"Alfa Romeo" , "Alfa Romeo", "Alfa Romeo", "Aston Martin", "Aston Martin", "Aston Martin",
        "Audi", "Audi", "Audi", "BMW", "BMW", "BMW",  "Chevrolet", "Chevrolet", "Chevrolet",
        "Citroën", "Citroën", "Citroën", "Dodge", "Dodge", "Dodge", "Ferrari","Ferrari","Ferrari",
	      "Fiat", "Fiat","Fiat", "Honda", "Honda","Honda", "Hyundai", "Hyundai","Hyundai",
	      "Kia","Kia","Kia", "Mercedes-Benz", "Mercedes-Benz","Mercedes-Benz",
	      "Opel","Opel","Opel", "Peugeot","Peugeot","Peugeot", "Porsche","Porsche","Porsche",
	      "Renault", "Renault","Renault", "SEAT", "SEAT","SEAT",
	       "Volkswagen", "Volkswagen", "Volkswagen"};

	    string modele[]= {"4C", "Giulia", "Stelvio" , "DB7", "DBS", "DB9","A4", "A6", "Q7", "E87", "Z4 Coupé", "X3",
	     "Cruze", "Spark", "Sonic", "Berlingo", "C3", "C-Elysee", "Challenger", "Ram", "Charger",
	     "488 Spider", "California T", "LaFerrari", "126p", "Punto", "Panda", "Civic", "Skydeck", "S2000",
	     "I30", "Kona", "Santa Fe", "Stonic", "Rio", "Cee'd", "CLA", "Klasa B", "Klasa A",
	     "Corsa", "Astra", "Vectra", "208", "301", "508", "Cayenne", "Carrera", "Macan", "Megane", "Clio",
	     "Captur", "Ibiza", "Toledo", "Leon SC", "Polo", "Golf", "Arteon"};

	     string silnik[] = {"Benzyna", "Diesel", "Hybrydowy", "Elektryczny"};

	     string pojemnosc[] = {"1,0", "1,2", "1,4", "1,6", "1,9", "2,0"};
	(*plik).open("samochody.csv");
	for (int i = 0; i < 400; i++)
	{



        GenerateVIN(vin);
		id_zaliczenia = i+1;
		samochod = rand()%56;
		przebieg = 10000 + rand()%40*1000;
		moc = 85 + rand()%365;
		siln = rand()%4;
		pojemn = rand()%6;
		pracownik= 1+rand()%50;
		rok = rand() % 17 + 2000;

		*plik << id_zaliczenia << ";" << marka[samochod]  <<  ";" << modele[samochod] << ";"
		<< rok <<";" << vin << ";" << przebieg << ";" << moc << ";" << silnik[siln] << ";"
		<< pojemnosc[pojemn] << ";" << id_zaliczenia << ";" << id_zaliczenia << ";"
		<< pracownik << endl;


	}

}
//Too many warnings!
//ale cos robi
int main()
{
	ofstream plik;
	generuj(&plik);
	cout << "Wygenerowano!" << endl;
    return 0;
}
