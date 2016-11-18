def isDivisible(s):
    i = 1
    if int(s[i:i+3]) % 2 != 0:
        return False
        
    i += 1
    if int(s[i:i+3]) % 3 != 0:
        return False
        
    i += 1
    if int(s[i:i+3]) % 5 != 0:
        return False
        
    i += 1
    if int(s[i:i+3]) % 7 != 0:
        return False
        
    i += 1
    if int(s[i:i+3]) % 11 != 0:
        return False
        
    i += 1
    if int(s[i:i+3]) % 13 != 0:
        return False
        
    i += 1
    if int(s[i:i+3]) % 17 != 0:
        return False
    return True


print(isDivisible("1406357289"))
