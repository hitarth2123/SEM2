
ones = ['', 'one', 'two', 'three', 'four', 'five', 'six', 'seven', 'eight', 'nine']
teens = ['ten', 'eleven', 'twelve', 'thirteen', 'fourteen', 'fifteen', 'sixteen', 'seventeen', 'eighteen', 'nineteen']
tens = ['', '', 'twenty', 'thirty', 'forty', 'fifty', 'sixty', 'seventy', 'eighty', 'ninety']

n = int(input("Enter a number: ")) 
if n < 10:
    result = ones[n]
elif n < 20:
    result = teens[n - 10]
elif n < 100:
    result = tens[n // 10] + ('' if n % 10 == 0 else ' ' + ones[n % 10])
elif n < 1000:
    result = ones[n // 100] + ' hundred' + ('' if n % 100 == 0 else ' ' + (tens[(n % 100) // 10] + ('' if (n % 100) % 10 == 0 else ' ' + ones[(n % 100) % 10]) if (n % 100) >= 20 else teens[(n % 100) - 10]))
elif n < 1000000:
    result = (ones[n // 1000] + ' thousand' if n // 1000 != 1 else 'one thousand') + ('' if n % 1000 == 0 else ' ' + (ones[(n % 1000) // 100] + ' hundred' + ('' if (n % 1000) % 100 == 0 else ' ' + (tens[((n % 1000) % 100) // 10] + ('' if ((n % 1000) % 100) % 10 == 0 else ' ' + ones[((n % 1000) % 100) % 10]) if ((n % 1000) % 100) >= 20 else teens[((n % 1000) % 100) - 10])) if (n % 1000) >= 100 else (tens[(n % 1000) // 10] + ('' if (n % 1000) % 10 == 0 else ' ' + ones[(n % 1000) % 10]) if (n % 1000) >= 20 else teens[(n % 1000) - 10])))
else:
    result = 'Number out of range'

print(result)




