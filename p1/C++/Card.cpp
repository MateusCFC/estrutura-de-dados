#include "Card.h"

Card::Card(int n,int val)
{
    valor = val;
    switch(n)
    {
    case(0):
        naipe = "H";
        break;
    case(1):
        naipe = "D";
        break;
    case(2):
        naipe = "S" ;
        break;
    case(3):
        naipe = "C";
        break;
    }
}

string Card::toString()
{
    stringstream ss;
    ss << valor;
    string b = ss.str();
    return naipe+b;
}
