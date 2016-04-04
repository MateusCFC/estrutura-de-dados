#include "Blackjack.h"

Blackjack::Blackjack()
{

}

int Blackjack::getPoints(Card c)
{
    if (c.valor <= 10) return c.valor;
    else return 10;
}

int Blackjack::getScore(list<Card> l)
{
    int lsize = l.size();
    int sum=0;
    for (int i=0; i<lsize; i++)
    {
        Card actual = l.front();
        sum += getPoints(actual);
        l.pop_front();
    }
    return sum;
}

char Blackjack::getCommand()
{
    char c;
    do
    {
        cout << "Enter d for draw or s for stand" << endl;
        cin >> c;
    }
    while(c != 'd' && c != 's');
    return c;
}

list<Card> Blackjack::humanPlayer(Deck* d)
{
    string show = "";
    list<Card> aux;
    char x;
    do
    {
        x = getCommand();
        if (x == 'd')
        {
            Card actual = d->draw();
            show += actual.toString() + " ";
            cout << "[ " << show;
            aux.push_back(actual);
            cout << "] --- ";
            cout << "Score: " << getScore(aux);
            if (getScore(aux) > 21)
            {
                cout << endl;
                return aux;
            }
            cout << endl;
        }
    }
    while (x != 's');
    return aux;
}

list<Card> Blackjack::computerPlayer(Deck* d,int humanScore)
{
    list<Card> aux;
    string show = "";
    while (true)
    {
        Card actual = d->draw();
        show += actual.toString() + " ";
        cout << "[ " << show;
        aux.push_back(actual);
        cout << "] --- ";
        cout << "Score: " << getScore(aux);
        if (getScore(aux) > 21)
        {
            cout << endl;
            return aux;
        }
        else if (getScore(aux) > humanScore)
        {
            cout << endl;
            return aux;
        }
        cout << endl;
    }
}

void Blackjack::game()
{
    srand(time(NULL));
    Deck d;
    Blackjack blackj;
    d.riffleShuffle(7);
    int scoreHuman = getScore(blackj.humanPlayer(&d));
    if (scoreHuman > 21) cout << "You lost, your score is above 21" << endl;
    else
    {
        int scoreComputer = getScore(blackj.computerPlayer(&d,scoreHuman));
        if (scoreComputer > 21) cout << "You won, your score is " << scoreHuman << " while the computer's score is above 21" << endl;
        else if (scoreComputer > scoreHuman) cout << "You lost, your score is " << scoreHuman << " while the computer scored " << scoreComputer << endl;
        else if (scoreComputer == scoreHuman) cout << "It is a draw, both you and the computer scored " << scoreComputer << endl;
        else cout << "You won, your score is " << scoreHuman << " while the computer scored " << scoreComputer << endl;
    }
}
