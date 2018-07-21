class Solution:
   def binaryGap(self, N):
       last = None
       ans = 0
       for i in range(32):
           if (N >> i) & 1:
               if last is not None:
                   ans = max(ans, i - last)
               last = i
       return ans
z=Solution()
print(z.binaryGap(0))
print(z.binaryGap(55))
print(z.binaryGap(-5))
print(z.binaryGap(12354))
print(z.binaryGap(6))
print(z.binaryGap(256))
