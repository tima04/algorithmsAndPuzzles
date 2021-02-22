import re

#--- pattern, redefine fun 
def fun(x):
   out = x.isdigit() and len(x) ==10 and x[0] in ("7", "8", "9")
   return "YES" if out else "NO"

n = input()
for i in range(int(n)):
    x = input()
    print(fun(x))
#----

# validate credit card numbers
"""
► It must start with a 4, 5 or 6.
► It must contain exactly 16 digits.
► It must only consist of digits (0-9).
► It may have digits in groups of 4, separated by one hyphen "-".
► It must NOT use any other separator like ' ' , '_', etc.
► It must NOT have 4 or more consecutive repeated digits. 
"""

def consecutive(x, n=4):
    if len(x) < n:
        return False
    for d in set(x):
        pt = d + "{" f"{n}" + "}"
        if re.search(pt, x):
            return True
    return False

def proper_hyphen_sep(x):
    if not re.sub("-", "", x).isdigit():
        return False
    # if - then 4 digits before and after
    if "-" in x:
        ys = x.split("-")
        return set([len(y) for y in ys]) == set([4])
    return True

def fun(x):
    if not proper_hyphen_sep(x):
        return "Invalid"
    y = re.sub("-", "", x)
    if len(y) == 16 and y[0] in ('4', '5', '6') and y.isdigit() and not consecutive(y):
        return "Valid"
    else:
        return "Invalid"

x = '4123456789123456'
x = '61234-567-8912-3456'
y = fun(x)    
print(y)
