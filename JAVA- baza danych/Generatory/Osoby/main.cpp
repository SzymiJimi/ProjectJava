#include<stdlib.h>
#include<stdio.h>
#include<string.h>
#include<iostream>
#include<fstream>
#include<ctime>

using namespace std;


void pesel_daj(char pesel[])
{
    for(int i=0; i<11; i++)
    {
        pesel[i]=(int)48+rand()%10;
    }
    pesel[11]='\0';
}

void nip_daj (char nip[])
{
    //char nip[13];
    for(int i=0; i<13; i++)
    {
        if(i==3||i==7||i==10)
        {
            nip[i]='-';
        }
        else if(i==14)
        {
            nip[i]='\0';
        }

        else
            nip[i]=(int)48+rand()%10;
    }
}


void generuj(ofstream *plik)
{
    srand(time(NULL));
    int id_zaliczenia, nr_albumu, id_przed, nr_wykl, nr_grupy, id_typu, id_stopien, ocena,tmp,dzien,miesiac,rok,tmp2=0;
    char nip[14];
    char pesel[12];
    (*plik).open("osoby.csv");
    for (int i = 0; i < 200; i++)
    {

        id_zaliczenia = i+1;
        nr_albumu = rand()%700+1;
        id_przed = rand() % 23+1;
        nr_wykl = rand() % 20+1;
        nr_grupy = rand() % 25+1;
        id_typu = rand() % 3+1;
        id_stopien = rand() % 4+1;
        ocena = rand() % 3 + 3;
        tmp = rand() % 3 ;
        miesiac = rand() % 12 + 1;
        tmp2 = 0;
        nip_daj(nip);
        pesel_daj(pesel);
        while (tmp2 == 0)
        {
            dzien = rand() % 31 + 1;
            if ((miesiac == 4 || miesiac == 6 || miesiac == 9 || miesiac == 11) && dzien > 30)
            {
                tmp2 = 0;
            }
            else
            {
                if (miesiac == 2&&dzien>28)
                {
                    tmp2 = 0;
                }
                else
                {
                    tmp2 = 1;
                }
            }

        }
        rok = rand() % 3 + 2015;
        //*plik << id_zaliczenia << ";" << nr_albumu << ";" << id_przed << ";" << nr_wykl << ";"<< nr_grupy<< ";" << nip << ";" << id_typu << ";" << id_stopien << ";" << ocena << ";" << termin[tmp] << ";"<<dzien<<"/"<<miesiac<<"/"<<rok << endl;
        *plik << id_zaliczenia << ";" << ";" << ";" <<nip << ";" <<pesel<< endl;


    }

}



int main()
{
    ofstream plik;
    generuj(&plik);
    cout << "Wygenerowano!" << endl;
    return 0;
}
