#include<stdlib.h>
#include<stdio.h>
#include<string.h>
#include<iostream>
#include<fstream>
#include<ctime>
#include <string>

using namespace std;

void generuj(ofstream *plik)
{
	srand(time(NULL));
	int id_zaliczenia,tmp,dzien,miesiac,rok,tmp2=0, urlop, stanowisko, kwota, sprzedawca;
	(*plik).open("sprzedane.csv");
	for (int i = 0; i < 150; i++)
	{

		id_zaliczenia = i+1;
		kwota = 5000+rand()%665*100;
		sprzedawca= 1 + rand()%50;
				tmp = rand() % 3 ;
		miesiac = rand() % 12 + 1;
		tmp2 = 0;
		while (tmp2 == 0)
		{
			dzien = rand() % 31 + 1;
			if ((miesiac == 4 || miesiac == 6 || miesiac == 9 || miesiac == 11) && dzien > 30)
			{
				tmp2 = 0;
			}
			else {
				if (miesiac == 2&&dzien>28)
				{
					tmp2 = 0;
				}
				else {
					tmp2 = 1;
				}
			}

		}
		rok = rand() % 3 + 2015;
		*plik << id_zaliczenia <<  ";"<<dzien<<"/"<<miesiac<<"/"<<rok <<";" << kwota << ";" << id_zaliczenia
		<< ";" << id_zaliczenia << ";" << sprzedawca << endl;



	}

}

int main()
{
	ofstream plik;
	generuj(&plik);
	cout << "Wygenerowano!" << endl;
    return 0;
}
