import unittest


def get_closing_paren(sentence, opening_paren_index):

    # Find the position of the matching closing parenthesis
    a=opening_paren_index
    l=len(sentence)
    count=0
    while a<l:
        c=sentence[a]
        if c=="(":
            count+= 1
        elif c== ")":
            count-= 1
            if count == 0:
                return a
        a+= 1
    if count!=0:
        raise Exception

















# Tests

class Test(unittest.TestCase):

    def test_all_openers_then_closers(self):
        actual = get_closing_paren('((((()))))', 2)
        expected = 7
        self.assertEqual(actual, expected)


    def test_mixed_openers_and_closers(self):
        actual = get_closing_paren('()()((()()))', 5)
        expected = 10
        self.assertEqual(actual, expected)

    def test_no_matching_closer(self):
        with self.assertRaises(Exception):
            get_closing_paren('()(()', 2)


unittest.main(verbosity=2)