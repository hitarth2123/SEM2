class A:
    def feature1(self):
        print("Feature 1 from A")

class B:
    def feature2(self):
        print("Feature 2 from B")

class C(A, B):
    def feature3(self):
        print("Feature 3 from C")

c = C()
c.feature1()
c.feature2()
c.feature3()
