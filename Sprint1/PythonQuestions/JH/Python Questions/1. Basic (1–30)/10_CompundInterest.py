
p= float(input("Enter the principal amount: "))
t= float(input("Enter the timeperiod of the interest: "))
r= float(input("Enter the rate of interest: "))
a=p*(1+(r/100))**t
ci=a-p 

print("The compound interest is: ",ci)
