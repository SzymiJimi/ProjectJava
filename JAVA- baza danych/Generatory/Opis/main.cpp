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
	int id_zaliczenia, serwis, skr, st, nad, kra;
    string skrzynia [] = {"Automatyczna", "Manualna"};
    string stan [] = {"Nowy", "Używany", "Uszkodzony"};
    string nadwozie [] = {"Sedan", "Lift-back", "Hatch-back", "Kombi", "Pick-up", "Kabriolet", "Minivan"};
    string kraje [] = {"Rosja", "Polska", "USA", "Niemcy", "Wielka Brytania"};
	(*plik).open("opis.csv");
	for (int i = 0; i < 400; i++)
	{
		id_zaliczenia = i+1;
		skr=rand()%2;
		st=rand()%3;
		nad=rand()%7;
		kra=rand()%5;
		serwis=rand()%2;

		*plik << id_zaliczenia << ";" << skrzynia[skr] << ";" << stan[st] << ";" << nadwozie[nad] << ";"
		<< kraje[kra] << ";" << serwis << ";" << "-" << endl;

	}

}

int main()
{
	ofstream plik;
	generuj(&plik);
	cout << "Wygenerowano!" << endl;
    return 0;
}
