for image in `ls $1/*.jpg`
do
  convert $image -resize 400x $image
  java LoadImages $image 1 dataset.txt
done

for image in `ls $2/*.jpg`
do
  convert $image -resize 400x $image
  java LoadImages $image 2 dataset.txt
done

echo "done"
