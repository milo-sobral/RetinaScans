#Makefile for the Retina Scan C project

all : create_dataset.o dataset_creator.o src_java/*.java
	gcc objs/create_dataset.o objs/dataset_creator.o -o add_image
	javac -d ./classes src_java/*.java

c : create_dataset.o dataset_creator.o
	gcc objs/create_dataset.o objs/dataset_creator.o -o add_image

java : src_java/*.java
	javac -d ./classes src_java/*.java

create_dataset.o :
	gcc -c src_c/create_dataset.c -o objs/create_dataset.o
dataset_creator.o : 
	gcc -c src_c/dataset_creator.c -o objs/dataset_creator.o

clean :
	rm -rf objs/* classes/*
