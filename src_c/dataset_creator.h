/*
 */

/* FUNCTION: bmp_open
 * 
 * BRIEF:    Attempts to read the header information of bmp_filename to
 *           populate the file information variables. If successful,
 *           creates sufficient heap memory to store the entire image 
 *           including both the header and the pixel data. Then reads
 *           the image from file into this memory.
 *
 * RETURN:   0 if image is read successfully. Then all params must be valid.
 *           -1 for any error. Then user code should not use any params.
 * 
 * PARAMS:   bmp_filename   [IN]  The path to the BMP file to be opened
 *           width          [OUT] The width of each image row
 *           height         [OUT] The height of each image column
 *           bits_per_pixel [OUT] BBP = num_colors * 8 for all BMPs we will use
 *           row_padding    [OUT] Additional bytes placed at the end of each row
 *                                to ensure the row size is a multiple of 4
 *           data_size      [OUT] The number of bytes in img_data, includes header
 *           header_size    [OUT] The number of bytes just for the header. Usually 56.
 *           img_data       [OUT] Pointer to the image data on the heap.
 * 
 */ 
int bmp_open( char* bmp_filename,        unsigned int *width, 
              unsigned int *height,      unsigned int *bits_per_pixel, 
              unsigned int *padding,     unsigned int *data_size, 
              unsigned int *data_offset, unsigned char** img_data );

/* FUNCTION: bmp_close
 *
 * BRIEF:    frees the memory that was allocated on the heap by any successful bmp_open
 * 
 * PARAMS:   img_data [IN/OUT] Pointer to the image data on heap. Must be free'd and 
 *                             set to NULL. It is up to the calling code to ensure the
 *                             address at *img_data is valid heap memory.
 */
void bmp_close( unsigned char **img_data );