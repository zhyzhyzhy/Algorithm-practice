line_total=`cat file.txt | wc -l` 
if [ $line_total -lt 10 ]
then
	echo ""
else
	cat file.txt | head -n10 | tail -n1
fi

