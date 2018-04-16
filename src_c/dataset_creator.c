/*
 *
 */

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <math.h>
#include <assert.h>

#include <dataset_creator.h>

int bmp_open( char* bmp_filename,        unsigned int *width, 
              unsigned int *height,      unsigned int *bits_per_pixel, 
              unsigned int *padding,     unsigned int *data_size, 
              unsigned int *data_offset, unsigned char** img_data ){

  //Opens the BMP file to read from it
  FILE *bmp_file = fopen(bmp_filename, "rb");

  //Checks if the file is of the right format
  char b, m;
  fread(&b, 1, 1, bmp_file);
  fread(&m, 1, 1, bmp_file);
  if (b != 'B' || m != 'M'){
    printf("The file provided is not of the right format. Please provide a BMP image.");
    return -1;
  }

  //Reads the size of the file and closes the file to stop reading 
  unsigned int size;
  fread(&size, 1, sizeof(unsigned int), bmp_file);
  *data_size = size;
  
  //Advancing 4 bytes
  char useless1;
  for (int i = 0; i < 4; i++) {
    fread (&useless1, 1, sizeof (char), bmp_file);
  }

  //data_offset
  unsigned int offset;
  fread (&offset,1,sizeof (unsigned int),bmp_file);
  *data_offset= offset;

  //Advancing 1 byte
  int useless2 = 0;
  fread (&useless2, 1, sizeof (int), bmp_file);

  //width of the image
  unsigned int w;
  fread (&w, 1, sizeof(unsigned int), bmp_file);
  *width = w;
  
  //height of the image
  unsigned int h;
  fread (&h, 1, sizeof(unsigned int), bmp_file);
  *height = h;

  //Advancing 2 bytes
  for (int i = 0; i < 2; i++) {
    fread (&useless1, 1, sizeof(char), bmp_file);
  }
  
  //bits per pixel
  unsigned int bpp;
  fread (&bpp, 1, sizeof (unsigned int), bmp_file);
  *bits_per_pixel = bpp;  

  //padding
  unsigned int p;
  p = ( (*width) % (*bits_per_pixel) ) % 4;
  *padding = p;

  fclose(bmp_file);
        
  bmp_file = fopen (bmp_filename, "rb");

  //allocating memory and copying the image data into the heap
  *img_data = (unsigned char*)malloc(*data_size);
  fread (*img_data, 1, *data_size, bmp_file); 
  
  fclose (bmp_file);

  return 0;  
}

// We've implemented bmp_close for you. No need to modify this function
void bmp_close( unsigned char **img_data ){

  if( *img_data != NULL ){
    free( *img_data );
    *img_data = NULL;
  }
}