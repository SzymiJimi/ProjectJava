#include<stdlib.h>
#include<stdio.h>
#include<string.h>
#include<iostream>
#include<fstream>
#include<ctime>

using namespace std;

void generuj(ofstream *plik)
{
	srand(time(NULL));
	int id_zaliczenia,wynagrodzenie ,dzien,miesiac,rok,tmp2=0, urlop, stanowisko;

	(*plik).open("pracownicy.csv");
	for (int i = 0; i < 50; i++)
	{
		id_zaliczenia = i+1;
		wynagrodzenie=1000 + rand()%50 * 100;
		urlop = rand()%2;
		stanowisko=1+rand()%5;
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
		*plik << id_zaliczenia << ";" << wynagrodzenie  <<  ";"<<dzien<<"/"<<miesiac<<"/"<<rok <<
		";" << urlop << ";" << id_zaliczenia << ";" << stanowisko <<";" << id_zaliczenia << ";" << "1" <<
		";"<< ";" << endl;

	}

}

int main()
{
	ofstream plik;
	generuj(&plik);
	cout << "Wygenerowano!" << endl;
    return 0;
}
