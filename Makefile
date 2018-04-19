#Makefile for the Retina Scan C project
#Author : Milo Sobral

#MAKE EVERYTHING
all : create_dataset.o dataset_creator.o src_java/LoadImages.java src_java/RetinaScanToolBox.java
	gcc objs/create_dataset.o objs/dataset_creator.o -o add_image
	javac -d ./classes src_java/LoadImages.java src_java/RetinaScanToolBox.java

#MAKE C PART
c : create_dataset.o dataset_creator.o
	gcc objs/create_dataset.o objs/dataset_creator.o -o add_image
create_dataset.o :
	gcc -c src_c/create_dataset.c -o objs/create_dataset.o
dataset_creator.o :
	gcc -c src_c/dataset_creator.c -o objs/dataset_creator.o

#MAKE JAVA PART
java : src_java/LoadImages.java src_java/RetinaScanToolBox.java
	javac -d ./ src_java/LoadImages.java src_java/RetinaScanToolBox.java

#CLEAN UP FILE SYSTEM
clean :
	rm -rf objs/* classes/* add_image *.class
