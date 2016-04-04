#include "Deck.h"

Deck::Deck()
{
    for (int i=0; i<4; i++)
    {
        for (int j=1; j<14; j++) cl.push_back(Card(i,j));
    }
}

string Deck::toString()
{
    string aux = "";
    list<Card> aux2 = cl;
    while (!(aux2.empty()))
    {
        aux += aux2.front().toString() + " ";
        aux2.pop_front();
    }
    return aux;
}

Card Deck::draw()
{
    if (!(cl.empty()))
    {
        Card actual = cl.front();
        cl.pop_front();
        return actual;
    }
}

int Deck::cut(int n)
{
    double sum = 0;
    int index;
    double r = ((double) rand() / (RAND_MAX));
    for(int i = 0; i < n; i++)
    {
        double num = 1;
        double denom = 1;
        double mult;
        for(int j=0; j <= i; j++)
        {
            num *= (n-j);
            denom *= (j+1);
            mult = num/denom;
        }
        mult /= pow(2,n);
        sum += mult;
        if (sum >= r){
            index = i;
            break;
        }
    }
    return index;
}

list<Card> Deck::split(list<Card>* l,int c)
{
    list<Card> aux;
    for (int i=0; i<c; i++)
    {
        Card actual = l->front();
        aux.push_back(actual);
        l->pop_front();
    }
    return aux;
}

list<Card> Deck::riffle(list<Card> l1,list<Card> l2)
{
    list<Card> out;
    Card actual(0,1);

    for (int i=0; i<52; i++)
    {
        double l1size = l1.size();
        double l2size = l2.size();
        double ab = l1size/(l1size+l2size);
        double x = ((double) rand() / (RAND_MAX));
        if (ab >= x)
        {
            actual = l1.front(), l1.pop_front();
        }
        else
        {
            actual = l2.front(), l2.pop_front();
        }
        out.push_back(actual);
    }
    return out;
}

void Deck::riffleShuffle(int n)
{
    for (int i=0; i<n; i++)
    {
        int x = cut(52);
        list<Card> aux = split(&cl,x);
        cl = riffle(aux,cl);
    }
}
