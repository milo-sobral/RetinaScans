#include <dataset_creator.c>

int main(int argc, char* argv[]){

	if( argc < 2 ){
    	printf( "Usage: $ %s <bmp_filename> <1 or 0>\n", argv[0] );
    	exit(EXIT_FAILURE);
  	}

  	//Opens a file to store the data and creates some variables
  	FILE *fp = fopen("dataset.txt", "a+");
  	unsigned int image_width, image_height, bits_per_pixel, row_padding, data_size, data_offset;
  	unsigned char *img_data = NULL;

  	char *file_name = argv[1];

  	//Opens the bmp file and stores its img data into the array img_data
  	int return_code = bmp_open(file_name , &image_width, &image_height, &bits_per_pixel, &row_padding, &data_size, &data_offset, &img_data );

  	//Checks if the procedure went well 
  	if( return_code ){
    	printf( "create_dataset function returned an error.\n" );
    	return return_code;
	}

	//Checks if the array for the pixel values filled without problem
	if (img_data == NULL){
		printf("Something went wrong somewhere");
	} 	

	

}