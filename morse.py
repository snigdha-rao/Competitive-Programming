class Morse(object):
   def uniqueMorseRepresentations(self, words):
       MORSE = [".-","-...","-.-.","-..",".","..-.","--.",
                "....","..",".---","-.-",".-..","--","-.",
                "---",".--.","--.-",".-.","...","-","..-",
                "...-",".--","-..-","-.--","--.."]

       s = {"".join(MORSE[ord(c) - ord('a')] for c in word)
               for word in words}

       return len(s)
l1=["gin", "zen", "gig", "msg"]
l2=["a", "z", "g", "m"]
l3=["bhi", "vsv", "sgh", "vbi"]
l4=["a", "b", "c", "d"]  
l5=["hig", "sip", "pot"]

z=Morse()
print(z.uniqueMorseRepresentations(l1))
print(z.uniqueMorseRepresentations(l2))
print(z.uniqueMorseRepresentations(l3))
print(z.uniqueMorseRepresentations(l4))
print(z.uniqueMorseRepresentations(l5))
