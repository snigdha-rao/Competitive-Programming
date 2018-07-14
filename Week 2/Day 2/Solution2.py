import unittest
def is_valid(code):
       stack=[]
       for i in range(len(code)):
           
          if (code[i] == '{' or code[i] == '(' or code[i] == '['):
              stack.append(code[i])
          if (code[i] == '}' or code[i] == ')' or code[i] == ']'):
              if not stack:
                   return False
              elif (matching(stack.pop(), code[i]) ==False ):
                  return False
     
       if not stack:
           return True
       else:
           return False



def matching(a,b):
       if (a== '(' and  b== ')'):
         return True
       elif (a== '{' and b== '}'):
         return True
       elif (a== '[' and b == ']'):
         return True
       else:
         return False














# Tests

class Test(unittest.TestCase):

    def test_valid_short_code(self):
        result = is_valid('()')
        self.assertTrue(result)

    def test_valid_longer_code(self):
        result = is_valid('([]{[]})[]{{}()}')
        self.assertTrue(result)

    def test_mismatched_opener_and_closer(self):
        result = is_valid('([][]}')
        self.assertFalse(result)

    def test_missing_closer(self):
        result = is_valid('[[]()')
        self.assertFalse(result)

    def test_extra_closer(self):
        result = is_valid('[[]]())')
        self.assertFalse(result)

    def test_empty_string(self):
        result = is_valid('')
        self.assertTrue(result)


unittest.main(verbosity=2)