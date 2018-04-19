for image in `ls $1/*.jpg`
do
  mogrify -resize 20% image.jpg
  java LoadImages.class image 1 dataset.txt
done

for image in `ls $2/*.jpg`
do
  mogrify -resize 20% image.jpg
  java LoadImages.class image 1 dataset.txt
done

echo "done"
