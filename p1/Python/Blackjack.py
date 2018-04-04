from random import shuffle #função de embaralhar lista
import os

'''
'' Define uma carta, através de um número e um naipe.
'''
class Card: 
	#construtor, que recebe um número e um naipe.
	def __init__(self,num,suit):
		self.num = num
		self.suit = suit

	#imprime a carta em formato numero + naipe (ex.: 4 of swords = 4S).
	def printCard(self):
		return str(self.num) + self.suit

	#retorna o valor da carta baseado nas regras do jogo.
	def getValue(self):
		if self.num > 10:
			return 10
		else:
			return self.num

'''
'' Define um deck de cartas através de uma lista de cartas embaralhadas.
'''
class Deck:
	#construtor, que cria uma lista embaralhada de cartas.
	def __init__(self):
		suitList = ["H", "C", "D", "S"]
		self.deck = []
		for i in range(1,14):
			for j in suitList:
				self.deck.append(Card(i,j))
		shuffle(self.deck)

	#remove a primeira carta da lista e a remove da lista.
	def drawCard(self):
		out = self.deck[0]
		self.deck.pop(0)
		return out

'''
'' Define as regras e a execução do jogo.
'''
class Game:
	_deck = Deck() #deck usado no jogo.
	#pontos de cada jogador, juntamente com a mão de cada um deles.
	_playerPoints = 0
	_CPUPoints = 0
	_playerCards = []
	_CPUCards = []

	#imprime a tela inicial.
	def opening(self):
		os.system('cls')
		print("==========")
		print("Blackjack Game")
		print("==========")
		input("Tap Enter to play!")
		os.system('cls')

	#imprime as opções disponíveis ao usuário e recebe a entrada do mesmo.
	def getInput(self):
		print("D: Draw a card")
		print("S: Stand")
		print("Q: Quit")
		return input("")

	#reinicia os atributos do jogo.
	def resetGame(self):
		self._deck = Deck()
		self._playerPoints = 0
		self._CPUPoints = 0
		self._playerCards = []
		self._CPUCards = []

	#puxa uma carta do deck e adiciona na mão do jogador que a puxou, contabilizando a pontuação.
	def computeDrawnCard(self,player):
		drawnCard = self._deck.drawCard()
		if player == "Player":
			self._playerPoints += drawnCard.getValue()
			self._playerCards.append(drawnCard.printCard())
			print("You drew {0}.".format(drawnCard.printCard()))
			print("You have {0} points.".format(self._playerPoints))
			print("Your draws: {0}.".format(self._playerCards) + "\n")
		else:
			self._CPUPoints += drawnCard.getValue()
			self._CPUCards.append(drawnCard.printCard())
			print("The CPU drew {0}.".format(drawnCard.printCard()))
			print("The CPU has {0} points.".format(self._CPUPoints))
			print("CPU's draws: {0}.".format(self._CPUCards) + "\n")

	#executa os métodos previamente declarados de forma a manter a sequência do jogo.
	def execute(self):
		self.opening()
		while True:
			opt = self.getInput()
			if opt == "Q":
				print("Thanks for playing!")
				break
			elif opt == "D":
				self.computeDrawnCard("Player")
				if self._playerPoints > 21:
					print("You lost! You went over 21!")
					print("Play again? Press R to do it.")
					opt2 = input("")
					if opt != "R":
						self.resetGame()
						self.execute()
						break
					else:
						self.resetGame()
						self.execute()
			elif opt == "S":
				print("You chose to stand with {0} points!".format(self._playerPoints))
				print("Now, the CPU is going to play.")
				while self._CPUPoints < self._playerPoints:
					if self._CPUPoints >= 21 or self._CPUPoints > self._playerPoints:
						break
					self.computeDrawnCard("CPU")
				if self._CPUPoints > 21:
					print("You won! The CPU went over 21!")
					print("Silly CPU, isn't it? :p")
				elif self._CPUPoints > self._playerPoints:
					print("You lost! Your score was {0} and the CPU score was {1}.".format(self._playerPoints,self._CPUPoints))
					print("Better luck next time :D")
				elif self._CPUPoints < self._playerPoints:
					print("You won! Congratulations! Your score was {0} and the CPU score was {1}!".format(self._playerPoints,self._CPUPoints))
					print("Feel free to play again anytime!")
				else:
					print("You and the CPU both drew with {0} points! Isn't that nice?".format(self._CPUPoints))
					
				print("Your cards: {0}".format(self._playerCards))	
				print("CPU's cards: {0}".format(self._CPUCards))
				input("Press any key to reset the game\n")
				os.system('cls')
				self.resetGame()		
			else:
				print("ERROR: Invalid option!")
 
#função principal
g = Game()
g.execute()
