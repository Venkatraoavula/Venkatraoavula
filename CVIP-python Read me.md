from tkinter import *
import random
from timeit import default_timer 
import difflib
 
print("-----------ProjectVenkat - Python Typing Speed test------------")
 
root=Tk()
root.title('ProjectGurukul Typing test')
root.geometry("400x400")
 
entered=StringVar() 
 
greet = Label(root, font = ('arial', 30, 'bold'), text = "Welcome!")
greet.grid(row = 0,columnspan = 3)
 
words=['We are developing Python project', 'This is Windows Os', 'We are Hiring', 'Lets Play a game','Python is a programming language', 'We love Coding', 'This is an amazing Article', 'I am an Intern', 'Lets check the Output', 'we are Compiling this program' ]
word=random.choice(words)
 
def check():
    global entered
    global word
    global start
 
    string=f"{entered.get()}"
    end=  default_timer()
    time= round(end-start,2)
    print(time)
    speed=round(len(word.split())*60/time,2)
    print(speed)
 
    if string==word:
        Msg1 ="Time= " + str(time) + ' seconds'
        Msg2=" Accuracy= 100% "
        Msg3= " Speed= " + str(speed) + 'wpm' 
 
    else:
        accuracy=difflib.SequenceMatcher(None,word,string).ratio()
        accuracy=str(round(accuracy*100,2))
        Msg1 ="Time= "+ str(time) + ' seconds'
        Msg2=" Accuracy= " + accuracy + '%'
        Msg3= " Speed= " + str(speed) + ' wpm' #words per minute 
 
    
    label=Label(root, font = ('arial', 15, 'bold'), text = Msg1)
    label.grid(row = 7, columnspan = 3)
 
    label=Label(root, font = ('arial', 15, 'bold'), text = Msg2)
    label.grid(row = 8, columnspan = 3)
 
    label=Label(root, font = ('arial', 15, 'bold'), text = Msg3)
    label.grid(row = 9, columnspan = 3)
   
def play():
    global word
    global start
    global entered  
 
    label=Label(root, font = ('arial', 15), text = "Type here")
    label.grid(row = 5, column=1)
 
    entered=StringVar() 
    enter=Entry(root,textvariable=entered,font =('arial', 15),width=20)
    enter.grid(row=5,column=3)
 
    btn = Button(root, text = "Check",command=check,bg="DodgerBlue2",fg="white", font = ('arial', 10))
    btn.grid(row = 6,columnspan = 6)
 
 
label=Label(root, font = ('arial', 20, 'bold'), text = word)
label.grid(row = 3, columnspan = 3)
 
 
btn = Button(root, text = " Start typing",command=play,bg="DodgerBlue2",fg="white", font = ('arial', 10))
btn.grid(row = 4,columnspan = 6)
start= default_timer()
 
mainloop()
