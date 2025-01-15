
p= float(input("\nEnter the principal amount: "))
t= float(input("\nEnter the timeperiod of the interest: "))
r= float(input("\nEnter the rate of interest: "))
a=p*(1+(r/100))**t
ci=a-p 

print("\nThe compound interest is: ",ci)
