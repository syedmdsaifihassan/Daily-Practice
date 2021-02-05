from tkinter import *
from tkinter .ttk import *
from time import strftime

root = Tk()
root.title("C L O C K")

def time():
	string=strftime('%d-%m-%Y %H:%M:%S %a')
	label.config(text=string)
	label.after(1000, time)


label = Label(root, font=("library 3 am soft", 100), background="black", foreground="red")
label.pack(anchor='center')
time()

mainloop()