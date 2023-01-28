import random

drop = [[random.randint(0,5) for j in range(6)] for i in range(5)]
tmpx = [[6 for j in range(6)] for i in range(5)]
tmpy = [[6 for j in range(6)] for i in range(5)]
for i in range(5):
	print(drop[i])

count = 1
combo = 0
k = 0
for i in range(5):
	for j in range(6):
		for k in range(6):
			if tmpx[i][j] > 6:
				break
			elif drop[i][j] == drop[i][k+1]:
				count += 1
			else:
				break
		if count >= 3:
			for l in range(count):
				tmpx[i][j+l] = drop[i][j]+7
				print(tmpx[i][j+l])
				print(drop[i][j]+7)
			combo += 1
		count = 0
		for k in range(5):
			if tmpy[i][j] > 6:
				break
			elif drop[i][j] == drop[k+1][j]:
				count += 1
			else:
				break
		if count >= 3:
			for l in range(count):
				tmpy[i+l][j] = drop[i][j]+7
			combo += 1
		count = 0

print("")
for i in range(5):
	print(tmpx[i])

