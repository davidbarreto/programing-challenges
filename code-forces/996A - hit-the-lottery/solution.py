
n = int(input())

bills = [100, 20, 10, 5, 1]

min_bills = 0

for bill in bills:
    min_bills += n // bill
    n %= bill

print(min_bills)