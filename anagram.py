def anagram(s, t):
	a=[]
	b=[]
	for i in s:
		if(i!=' '):
			a.append(i.lower())
	for i in t:
		if(i!=' '):
			b.append(i.lower())
	a.sort()
	b.sort()
	return str(a)==str(b)

print(anagram('anagram','nagaram'))
print(anagram('Keep','Peek'))
print(anagram('Mother In Law','Hitler Woman'))
print(anagram('School Master','The  Classroom'))
print(anagram('ASTRONOMERS','NO MORE STARS'))
print(anagram('Toss','Shot'))
print(anagram('joy','enjoy'))
print(anagram('Debit Card','Bad Credit'))
print(anagram('SiLeNt CAT','LisTen AcT'))
print(anagram('Dormitory','Dirty Room'))


