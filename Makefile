#Makefile for the Retina Scan C project

all : create_dataset.o dataset_creator.o
	gcc objs/create_dataset.o objs/dataset_creator.o -o add_image

create_dataset.o : create_dataset.o
	gcc -c src_c/create_dataset.c -o objs/create_dataset.o
dataset_creator.o : dataset_creator.o
	gcc -c src_c/dataset_creator.c -o objs/dataset_creator.o

clean : 
	rm -rf objs/* 