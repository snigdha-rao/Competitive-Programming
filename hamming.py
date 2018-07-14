class Solution(object):
   def hamming(self, x, y):
       biX = bin(x)[2:]
       biY = bin(y)[2:]
       ll = max(len(biX),len(biY))
       sl = min(len(biX),len(biY))
       if len(biX)<=len(biY):
           biX = '0'*(ll-sl) + biX
       else:
           biY = '0'*(ll-sl) + biY
       n = 0
       for i in range(ll):
           if biX[i] != biY[i]:
               n += 1
       return n
x = 1
y = 4
z = Solution()
print(z.hamming(x,y))
x = 25
y = 30
print(z.hamming(x,y))
x = 100
y = 250
print(z.hamming(x,y))
x = 1
y = 30
print(z.hamming(x,y))
x = 0
y = 255
print(z.hamming(x,y))



